package homekit_server.serverFactory.TcpAdapter;

public class TcpAdapter implements Runnable{
	private TcpAccepter accepter;
	private TcpReader reader;
	private TcpSender sender;
	private TcpManager manager;
	
	public TcpAdapter() {
		accepter = new TcpAccepter();
		reader = new TcpReader();
		sender = new TcpSender();
		manager = new TcpManager();
	}

	public void run() {
		
	}

	
}
