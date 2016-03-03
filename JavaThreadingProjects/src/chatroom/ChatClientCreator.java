package chatroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClientCreator {

	public static void main(String[] args) {
		int numberOfThreads = 1000;
		ExecutorService executor  = Executors.newFixedThreadPool(numberOfThreads);
		
		for(int i = 0; i < numberOfThreads; i++) {
			ChatClient client = new ChatClient("Client" + i);
			executor.submit(client);
		}
		
		executor.shutdown();

	}

}
