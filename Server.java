import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
	public static final String ERROR_MESSAGE = "S: Something bad happened. :(";
  
  static String compatibilityStrategy;

	public static void main(String[] args) { 
     
    compatibilityStrategy = getStrategy(args);
  
		Connection connection = new Connection();
		try {
			ServerSocket ssocket = new ServerSocket(8888);
			System.out.println("S: Starting server...");
			System.out.println("S: Waiting for connections...");
			while(true) {
				waitForConnection(ssocket);
			}
		} 
		catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			System.exit(0);
		}
	}
  
  private static String getStrategy(String[] args) { 
    if (args == null) {
      return "flames";
    }
    
    if (args[0].equals("truelove")) {
      return "truelove";
    }
    else {
      return "flames";
    }
    
  }

	private static void waitForConnection(ServerSocket ssocket) {
		try {
			Socket s = ssocket.accept();
			(new Thread(new ServerRunnable(s, compatibilityStrategy))).start();		
		}
		catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
