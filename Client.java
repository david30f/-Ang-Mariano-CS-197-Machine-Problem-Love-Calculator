import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static final String ERROR_MESSAGE = "C: Something bad happened. :(";

	public static void main(String args[]) {
		try {		
      // Connect to server
			System.out.println("C: Connecting to server...");
			String ip = args.length > 0 ? args[0] : "127.0.0.1";
			Socket s = new Socket(ip, 8888);	
			Connection connection = new Connection(s);
			System.out.println("C: Connected.");

      String names = acceptAndValidateNames();

      // Send names to server
      if (!connection.sendMessage(names)) {
        System.out.println(ERROR_MESSAGE);
      }
      String response = connection.getMessage();
      if (response.equals(Server.ERROR_MESSAGE)) {
        throw new Exception();
      }

      // Display server response
      System.out.println("S: " + response);
		}
		catch (Exception e) {
      e.printStackTrace();
			//System.out.println(ERROR_MESSAGE);
		}
		
	}

  private static String acceptAndValidateNames() {
    String names = "";
    InputValidator checker = new InputValidator();
    boolean valid = false;

    Scanner scan = new Scanner(System.in);

    while (!valid) {
      names = promptForNames(scan);
      valid = checker.isValid(names);
      if (valid) {
        System.out.println("Input accepted.");
      }
      else {
        System.out.println("Invalid input. Try again.");
      }
    }

    scan.close();

    return names;
  }

	private static String promptForNames(Scanner scan) {
		System.out.print("Enter names (<name1>,<name2>): ");

    String names = scan.nextLine();

		return names;
	}
}