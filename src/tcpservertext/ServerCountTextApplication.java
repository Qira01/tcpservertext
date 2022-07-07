package tcpservertext;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCountTextApplication {
	
public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4230;
		System.out.println("Waiting for request");
		
		try (ServerSocket serverSocket = new ServerSocket(portNo)) {
			
			TextCountGenerator textCountGenerator = new TextCountGenerator();
			
			// Server needs to be alive forever
			while (true) {
							
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				// Calculate length of text
				String currentTextCount = textCountGenerator.getCountText();
				String message = "Data sent to the client: " + currentTextCount;
				System.out.println(message);
				
				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());
				
				// Send length of text back to the client
				outputStream.writeBytes(currentTextCount);
				
				// Close the socket
				clientSocket.close();
				
			}
		}
		
		

	}

}
