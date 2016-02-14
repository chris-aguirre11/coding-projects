package scratchpad;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class FileWatcher {
	
	Timer timer;
	
	public FileWatcher() {
        timer = new Timer();
        timer.schedule(new FileWatcherTask(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }

	public static void main(String[] args) {
		new FileWatcher();
	}
	
	 class FileWatcherTask extends TimerTask {
	        int numOfTimesChecked = 60;
	        public void run() {
	            if (numOfTimesChecked > 0) {
	                System.out.println("Checking for file...");
	                numOfTimesChecked--;
	                if(fileExists("C:\\dev\\test.txt")) {
	                	System.out.println("File has arrived!");
	                	timer.cancel();
	                }
	            } else {
	                System.out.println("Time's up - no more checking for file");
	                timer.cancel(); 
	            }
	        }
	    }
	 
	 private static boolean fileExists(String pathToFile) {
	    	File f = new File(pathToFile);
	    	return f.exists();
	    }

}
