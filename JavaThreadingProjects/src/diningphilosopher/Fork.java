package diningphilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
	
	int forkNumber;
	public ReentrantLock lock = new ReentrantLock();
	  
	public Fork(int forkNumber) {
		System.out.println("Fork # " + forkNumber + " created");
		this.forkNumber = forkNumber;
	}
	
	public boolean pickUpFork(int philosopherNum) {
		boolean lockAquired = false;
		try {
			lockAquired = lock.tryLock(1, TimeUnit.SECONDS);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(lockAquired) {
			System.out.println("Philospoher " + philosopherNum + " ACQUIRED lock for Fork # " + forkNumber);
			System.out.flush();
		}
		else {
			System.out.println("Philospoher " + philosopherNum + " COULD NOT AQUIRE lock for Fork # " + forkNumber
					+ " within the specified time");
			System.out.flush();
		}
		return lockAquired;
	}
	
	public void putDownFork(int philosopherNum) {
		lock.unlock();
		System.out.println("Philospoher " + philosopherNum + " RELEASED lock for Fork # " + forkNumber);
		System.out.flush();
	}
}
