package diningphilosopher;

/**
 * References Which Helped: 
 * 	- http://stackoverflow.com/questions/27084579/dining-philosophers-using-semaphores
 * 	- Preventing Deadlock: http://homes.cs.washington.edu/~arvind/cs422/lectureNotes/deadlock-6.pdf
 * 
 * Used JConsole to verify no deadlock nor starvation: JDK_HOME/bin/jconsole.exe
 * 
 * TODO To Make It Better: 
 * 	- Implement a GUI with ability to slow down speed so we can see it
 * 	- Use a TimerTask to slow/speed up program
 *	- Use ThreadPoolExecutor(s)
 */
public class DiningPhilospoherTestDrive {
	/*
	 * Thread 0 - Can use forks 0 and 1
	 * Thread 1 - Can use forks 1 and 2
	 * Thread 2 - Can use forks 2 and 3
	 * Thread 3 - Can use forks 3 and 4
	 * Thread 4 - Can use forks 4 and 0
	 */
	public static void main(String args[]) {
		  
		  Fork fork0 = new Fork(0);
		  Fork fork1 = new Fork(1);
		  Fork fork2 = new Fork(2);
		  Fork fork3 = new Fork(3);
		  Fork fork4 = new Fork(4);
		  
		  DiningPhilosopher d0 = new DiningPhilosopher(fork0, fork1, 0); 
		  d0.start();
		  
		  DiningPhilosopher d1 = new DiningPhilosopher(fork1, fork2, 1); 
		  d1.start();
		  
		  DiningPhilosopher d2 = new DiningPhilosopher(fork2, fork3, 2); 
		  d2.start();
		  
		  DiningPhilosopher d3 = new DiningPhilosopher(fork3, fork4, 3); 
		  d3.start();
		  
		  DiningPhilosopher d4 = new DiningPhilosopher(fork4, fork0, 4); 
		  d4.start();
	  }
}

