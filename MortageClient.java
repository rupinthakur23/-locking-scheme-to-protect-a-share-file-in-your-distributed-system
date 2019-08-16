import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MortageClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String hostName="127.0.0.1";
		int portNumber=44444;
		
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;
		InputStreamReader ir;
		
		try {
      clientSocket = new Socket(hostName,portNumber);
	
		out= new PrintWriter(clientSocket.getOutputStream(),true);
		ir = new InputStreamReader(clientSocket.getInputStream());
		in=new BufferedReader(ir);
		
		out.println("Connected");
		
		String arg2;
		arg2=in.readLine();
		out.flush();
	
		System.out.println("Server says:" + arg2);
clientSocket.close();
		
	}
		catch(UnknownHostException e) {
			System.exit(1);
			
			
		}
		catch(IOException e) {System.exit(1);
		
			
		}

}
}
