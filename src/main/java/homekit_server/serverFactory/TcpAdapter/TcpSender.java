package homekit_server.serverFactory.TcpAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpSender implements Runnable {
	private Socket socket;
	private OutputStream os;
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while (true) {
			TcpWorker worker = TcpManager.getInstance().getWork();
			System.out.println(worker.getOperation());
			byte[] operation = new byte[] {(byte) (worker.getOperation()?1:0)};
			try {
				os = socket.getOutputStream();
				os.write(operation);
				os.flush();
				os.close();
				System.out.println("socket status : " + socket.isClosed());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
