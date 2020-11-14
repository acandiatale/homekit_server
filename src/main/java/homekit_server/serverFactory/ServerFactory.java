package homekit_server.serverFactory;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class ServerFactory{
	private static ServerFactory instance = new ServerFactory();
	
	public static ServerFactory getInstance() {
		return instance;
	}
	
	private ServerFactory() {
		
	}
	
	public void createServer(Server server) {
		ServerConnector http = new ServerConnector(server);
		http.setHost("localhost");
		http.setPort(12732);
		http.setIdleTimeout(30000);
		
		server.addConnector(http);
	}
}
