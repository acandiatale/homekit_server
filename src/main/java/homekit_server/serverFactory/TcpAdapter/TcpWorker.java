package homekit_server.serverFactory.TcpAdapter;

public class TcpWorker {
	private boolean operation;
	
	public TcpWorker(boolean operation) {
		this.operation = operation;
	}
	
	public boolean getOperation() {
		return this.operation;
	}
}
