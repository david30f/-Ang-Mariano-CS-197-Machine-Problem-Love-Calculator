import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class Server {
	public static final String ERROR_MESSAGE = "S: Something bad happened. :(";
  
  static String compatibilityStrategy;

	public static void main(String[] args) { 
 		Connection connection = new Connection();
    
		try {
			ServerSocket ssocket = new ServerSocket(8888);
			System.out.println("Starting server...");

      compatibilityStrategy = promptForStrategy();
			System.out.println("Using " + compatibilityStrategy + " algorithm...");
      
			System.out.println("Waiting for connections...");
			while(true) {
				waitForConnection(ssocket);
			}
		} 
		catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			System.exit(0);
		}
	}
  
  private static String promptForStrategy() { 
    System.out.println("Choose a compatibility algorithm (default: FLAMES):");
    System.out.println("1. FLAMES");
    System.out.println("2. TRUE LOVE");
    
    Scanner scan = new Scanner(System.in);
    String choice = scan.nextLine();
    scan.close();
    
    return determineStrategy(choice);
  }
  
  private static String determineStrategy(String choice) {  
    if (choice.isEmpty()) {
      return "FLAMES";
    }
    
    if (Integer.parseInt(choice) == 2) {
      return "TRUE LOVE";
    }
    else {
      return "FLAMES";
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
