package diningphilosopher;

import java.util.Random;

public class DiningPhilosopher extends Thread {
	/*
	 * Thread 0 - Can use forks 0 and 1
	 * Thread 1 - Can use forks 1 and 2
	 * Thread 2 - Can use forks 2 and 3
	 * Thread 3 - Can use forks 3 and 4
	 * Thread 4 - Can use forks 4 and 0
	 */
	Fork fork1 = null;
	Fork fork2 = null;
	int philosopherNum;
	int eatCount;
	Random randomGenerator = new Random();
	        
	public DiningPhilosopher(Fork fork1, Fork fork2, int philosopherNum) {
		super();
		this.fork1 = fork1;
		this.fork2 = fork2;
		this.philosopherNum = philosopherNum;
	}
  
  @Override
	public void run() {
	  while(true) {
		  pickupForks(fork1, fork2, philosopherNum);
	  }
	}
  
  public void pickupForks(Fork forkNum1, Fork forkNum2, int philosopherNum) {
	  System.out.println("Dining Philospoher " + philosopherNum + " wants to use forks: " 
			  + forkNum1.forkNumber + "," + forkNum2.forkNumber);
	  System.out.flush();
	  
	  boolean lock1Acquired = forkNum1.pickUpFork(philosopherNum);
	  if(lock1Acquired) {
		  
			 // Adding this sleep here can purposely magnify a deadlock problem - IF this was prone to deadlock
			 // http://stackoverflow.com/questions/13105628/dining-philosophers-implementation
			 try {
				Thread.sleep(randomGenerator.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		  boolean lock2Acquired = forkNum2.pickUpFork(philosopherNum);
		  if(!lock2Acquired) 
			  forkNum1.putDownFork(philosopherNum);
		  else {
			  eat(philosopherNum, forkNum1, forkNum2);
			  forkNum1.putDownFork(philosopherNum);
			  forkNum2.putDownFork(philosopherNum);	 
		  }  
	  }
	}

	private void eat(int philosopherNum, Fork forkNum1, Fork forkNum2) {
		System.out.println("Philospoher " + philosopherNum + " NOW EATING with forks: " 
			  + forkNum1.forkNumber + "," + forkNum2.forkNumber);
		System.out.flush();
		eatCount++;
		try {
			Thread.sleep(randomGenerator.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Philospoher " + philosopherNum + " DONE EATING with forks: " 
				  + forkNum1.forkNumber + "," + forkNum2.forkNumber);
		System.out.flush();
		System.out.println("Philospoher " + philosopherNum + " has EATEN " 
				  + eatCount + " times.");
		System.out.flush();
	}
  }
