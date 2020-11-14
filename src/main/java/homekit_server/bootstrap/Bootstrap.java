package homekit_server.bootstrap;

import org.eclipse.jetty.server.Server;

import homekit_server.handlerFactory.HandlerFactory;
import homekit_server.serverFactory.ServerFactory;

public class Bootstrap {

	public static void main(String[] args) {
		Server httpServer = new Server();
		ServerFactory.getInstance().createServer(httpServer);
		
		HandlerFactory handlerFactory = new HandlerFactory();
		httpServer.setHandler(handlerFactory.setHandlerList());
		
		try {
			System.out.println("==========server start==========");
			httpServer.start();
			System.out.println("==========server start successfully==========");
			httpServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
