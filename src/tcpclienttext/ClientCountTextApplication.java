package tcpclienttext;


import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.InputStream;
//import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientCountTextApplication {

	public static void main(String[] args) {
		
		System.out.println("\n\t Executing TCPSummationClientApp");

		try {
			
			// 1. Define server information
			int serverPortNo = 4230;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 2. Bind to the server, request for connection
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			/* 3. Send data to the server
			OutputStream outStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outStream);
			dos.writeInt(number1);
			dos.writeInt(number2);
			dos.writeInt(number3);*/
			
			// 4. Send data to the server
			InputStream inStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(inStream);
			int result = dis.readByte();
			
			// 5. Further processing - display the result
			System.out.println("\tLength of text: " + result);
			
			// Close all the closable
			dis.close();
			//dos.close();
			socket.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		System.out.println("\tEnd of execution at TCPSummationClientApp");
		
	}
}
