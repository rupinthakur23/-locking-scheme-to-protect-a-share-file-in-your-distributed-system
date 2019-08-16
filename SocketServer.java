import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	int portNumber=44444;
	ServerSocket serverSocket=null;
	FileLocking fileLock;
	
	public void runServer() {
		try {
		serverSocket= new ServerSocket(portNumber);
		fileLock= new FileLocking();
		fileLock.start();
		
			
		}
	
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		while(true) {
			try {
				Socket clientSocket= serverSocket.accept();
				 MortageRunner n= new MortageRunner(clientSocket, fileLock);
				 n.run();
				
				
				 
				 new Thread(n).start();
				 
				 
				 
				
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			
			}
			
		}
}
}



