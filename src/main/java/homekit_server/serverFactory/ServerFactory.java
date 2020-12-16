package homekit_server.serverFactory;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import homekit_server.handlerFactory.HandlerFactory;

public class ServerFactory implements Runnable{
	
	Server httpServer;
	
	public void createServer() {
		httpServer = new Server();
		ServerConnector http = new ServerConnector(httpServer);
		http.setHost("localhost");
		http.setPort(12732);
		http.setIdleTimeout(30000);
		
		httpServer.addConnector(http);
		
		HandlerFactory handlerFactory = new HandlerFactory();
		httpServer.setHandler(handlerFactory.setHandlerList());
	}

	@Override
	public void run() {
		try {
			createServer();
			System.out.println("========== HTTP_Server start ==========");
			httpServer.start();
			System.out.println("========== HTTP_Server start successfully ==========");
			httpServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
