package homekit_server.serverFactory.TcpAdapter;

import java.nio.channels.SelectionKey;

public class TcpAccepter {
	private SelectionKey key;
	
	public TcpAccepter() {
		
	}
	public TcpAccepter(SelectionKey key) {
		this.key = key;
	}
	
	public void start() {
		
	}

}
