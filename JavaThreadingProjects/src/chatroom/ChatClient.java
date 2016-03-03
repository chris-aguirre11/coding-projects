package chatroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ChatClient implements Runnable {
	
	private String clientName;

	public ChatClient(String clientName) {
		super();
		this.clientName = clientName;
	}

	@Override
	public void run() {
		
		Socket socket = null;
		BufferedReader in = null;
		
		try {
			// Make connection and initialize streams
	        String serverAddress = "localhost";
	        socket = new Socket(serverAddress, 9001);
	        
	        in = new BufferedReader(new InputStreamReader(
	            socket.getInputStream()));
	        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	        // Process all messages from server, according to the protocol.
	        while (true) {
	            String line = in.readLine();
	            
	            if (line.startsWith("SUBMITNAME")) {
	                out.println(clientName);
	            } 
	            else if (line.startsWith("NAMEACCEPTED")) {
	                System.out.println(new Date() +   "\tClient: " + clientName + " has been accepted by the ChatServer");
	            } 
	            else if (line.startsWith("MESSAGE")) {
	            	//System.out.println(new Date() +   "\t" + clientName + ": " + line.substring(8));
	                //messageArea.append(line.substring(8) + "\n");
	            }
	        }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
