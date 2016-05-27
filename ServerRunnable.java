import java.io.*;
import java.net.*;
import java.util.Date;

public class ServerRunnable implements Runnable {
	//***************************************
	// (Required) Fields
	//***************************************
	Socket s;
  LoveComputer compatibilityStrategy;
	//***************************************
	// Constructor
	//***************************************
	public ServerRunnable(Socket socket, String strat) {
		s = socket;
    
    if (strat.equals("truelove")) {
      compatibilityStrategy = new TrueLoveCalculator();
    }
    else if (strat.equals("flames")) {
      compatibilityStrategy = new FlamesCalculator();
    }
	}
	//***************************************
	// Run method
	//***************************************
  public void run() {
    boolean good = true;
		try {
			Connection connection = new Connection(s);
		  InetAddress ip = connection.getIp();
      
			System.out.println("S: " + ip + " connected!");
      
      String names = connection.getMessage();
			System.out.println(ip  + "> " + names);
        
		  String response = getResponse(names);
			connection.sendMessage(response);
		}
		catch (Exception e) {
			System.out.println(Server.ERROR_MESSAGE);
			good = false;
		}
  }
	//***************************************
	// Response logic
	//***************************************
  private String getResponse(String names) {
    String[] namesArray = names.split(",");
    return compatibilityStrategy.compute(namesArray[0], namesArray[1]);
  }
}