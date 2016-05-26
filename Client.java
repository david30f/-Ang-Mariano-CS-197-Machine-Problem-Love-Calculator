import java.io.*;
import java.net.*;

public class Client {
	public static final String ERROR_MESSAGE = "C: Something bad happened. :(";

	public static void main(String args[]) {
		try {		
			System.out.println("C: Connecting to server...");
			String ip = args.length > 0 ? args[0] : "127.0.0.1";
			Socket s = new Socket(ip, 8888);	
			Connection connection = new Connection(s);
			System.out.println("C: Connected.");
			while (true) {
				String msg = promptMessage();
				if (!connection.sendMessage(msg)) {
					System.out.println(ERROR_MESSAGE);
				}
				String response = connection.getMessage();
				if (response.equals(Server.ERROR_MESSAGE)) {
					throw new Exception();
				}
				System.out.println("S: " + response);
				if (response.equals("Goodbye")) {
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
		}
		
	}

	public static String promptMessage() {
		String msg;
		System.out.print("Enter Names (<name1>,<name2>): ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			msg = input.readLine();
		}
		catch (IOException e) {
			msg = "";
		}
		return msg;
	}
}
