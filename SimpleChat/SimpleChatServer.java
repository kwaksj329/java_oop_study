import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleChatServer {
	public void go() {
		try{
			ServerSocket server = new ServerSocket(4242);
			while(true){
				Socket s = server.accept();
				echoMessages(s);
			}
		}catch (Exception ex){
		}
	}

	private PrintWriter	writer;
	private ArrayList<PrintWriter> allprint = new ArrayList<PrintWriter>();

	private void echoMessages(Socket sock) {

		try{
			writer = new PrintWriter(sock.getOutputStream());
			allprint.add(writer);
		}catch (Exception e){
		}

		new Thread( () -> {
			BufferedReader reader;
			try{
					reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					while(true){
						String s = reader.readLine();
						for (PrintWriter pw : allprint) {
							pw.println(s);
							pw.flush();
						}
					}
			}catch (Exception ex){
			}
		}).start();
	}}

