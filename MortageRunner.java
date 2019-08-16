import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MortageRunner extends FileLocking implements Runnable {
	protected Socket clientSocket =null;
	FileLocking fileLock;
	public MortageRunner(Socket clientSocket, FileLocking fileLock) {
this.clientSocket= clientSocket;
	this.fileLock = fileLock;
		
		
	}
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out= new PrintWriter(clientSocket.getOutputStream(),true);
		String arg1;
		arg1= in.readLine();
		out.flush();
		System.out.println("Client says:" + arg1);
		if(fileLock.isFileUnlocked == true) {
			System.out.println("Waiting for the Lock");
		}else {
			System.out.println("Lock Given");
		}
		
		
		
		out.println("thanks for the messgae");
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
