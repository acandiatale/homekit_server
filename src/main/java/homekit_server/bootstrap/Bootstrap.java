package homekit_server.bootstrap;

import homekit_server.serverFactory.ServerFactory;
import homekit_server.serverFactory.TcpAdapter.TcpAdapter;

public class Bootstrap {

	public static void main(String[] args) {
		ServerFactory server = new ServerFactory();
		Thread serverThread = new Thread(server);
		serverThread.start();
		
		TcpAdapter adapter= new TcpAdapter();
		Thread tcpThread = new Thread(adapter);
		tcpThread.start();
	}
}
