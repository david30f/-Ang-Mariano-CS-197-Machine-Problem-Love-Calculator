import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Connection {
	//***************************************
	// Fields
	//***************************************
	protected Socket s;
	protected BufferedReader in;
	protected Scanner iscanner;
	protected PrintWriter out;
	//***************************************
	// Constructor
	//***************************************
	public Connection() { }
	public Connection(Socket s) {
		socket(s);
	}
	//***************************************
	// Accessors
	//***************************************
	public Socket socket() { return s; }
	public void socket(Socket s) { 
		this.s = s;
	}

	public InetAddress getIp() {
		return s.getInetAddress();
	}
	//***************************************
	// Accessors (message)
	//***************************************
	public boolean sendMessage(String msg) {
		try {
			initOutStream(s);
			out.println(msg);
			out.flush();
			return true;
		}	
		catch (Exception e) {
			return false;
		}	
	}

	public String getMessage() {
		String str = "";
		try {
			initInStream(s);
			String line = "";
			do {
				str += iscanner.nextLine() + "\n";
			} while (line.equals("\n"));
		}
		catch (Exception e) {
			str = "Something bad happened. :(";
		}
		return str.trim();
	}
	//***************************************
	// I/O stream operations
	//***************************************
	boolean initInStream(Socket s) {
		try {
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			in = new BufferedReader(isr);	
			iscanner = new Scanner(isr);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	boolean initOutStream(Socket s) {
		try {
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			out = new PrintWriter(osw);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}