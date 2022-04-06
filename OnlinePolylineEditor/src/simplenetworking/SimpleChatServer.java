package simplenetworking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

	private PrintWriter   writer;
	private ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();

	private void echoMessages(Socket sock) {

		try{
			writer = new PrintWriter(sock.getOutputStream());
			writers.add(writer);
		}catch (IOException e){

		}

		new Thread(() -> {
			BufferedReader reader;
			try{
				reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				while(true){
					String s = reader.readLine();
					for (PrintWriter p: writers) {
						p.println(s);
						p.flush();
					}
				}
			}catch (Exception ex){
			}
		}).start();
	}}


	//받은 메세지를 모든 클라이언트에게 센드,프린트 해줘야함
	//챗 서버 에고메세지 메소드 수정 필요
	//소켓이 연결이 될때마다 소켓의 아웃풋스트림으로 만들어진 롸이터들을
	//어레이 리스트타입의 인스턴스 변수 형태로 계속 갖고 있어야함
	//라이터드르 모두 에코 메세지 안에서 다 볼수 있어야함
	//라이터들ㅇ르 이용해 모든 클라이언트들에게 받은 메세지를 전송해야함
	//지금까지 연결된 클라이언트 라이터들을 어레이리스트형태로 관리
	//에코메세지안에서 메세지 하나가 오면 그 어레이리스트에 들어 있는 모든 라이터들에게 프린트라인에서 동일한 메세지 전송
	//클라이언트의 모든 라이터들을 다 스레드들이 공유하게됨
	//동기화에 문제가 생길수 있음-racecondition/ 그걸 안전하게 하려면 어떻게 하는지 신경을 좀 써야함

