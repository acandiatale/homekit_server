package homekit_server.bootstrap;

import org.eclipse.jetty.server.Server;

import homekit_server.handlerFactory.HandlerFactory;
import homekit_server.serverFactory.ServerFactory;
import homekit_server.serverFactory.TcpAdapter.TcpAdapter;

public class Bootstrap {

	public static void main(String[] args) {
		Server httpServer = new Server();
		ServerFactory.getInstance().createServer(httpServer);
		
		HandlerFactory handlerFactory = new HandlerFactory();
		httpServer.setHandler(handlerFactory.setHandlerList());
		
		try {
			System.out.println("========== HTTP_Server start ==========");
			httpServer.start();
			System.out.println("========== HTTP_Server start successfully ==========");
			System.out.println("========== TCPAdapter start ==========");
			TcpAdapter tcp = new TcpAdapter();
			Thread tcpThread = new Thread(tcp);
			tcpThread.start();
			System.out.println("========== TCPAdapter start successfully ==========");
			httpServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
