package homekit_server.serverFactory.TcpAdapter;

import java.util.concurrent.ArrayBlockingQueue;

public class TcpManager {
	private static TcpManager instance = new TcpManager();

	private TcpManager() {

	}

	public static TcpManager getInstance() {
		return instance;
	}

	private ArrayBlockingQueue<TcpWorker> workQueue = new ArrayBlockingQueue<TcpWorker>(100, true);

	public void setWork(TcpWorker work) {
		try {
			workQueue.put(work);
		} catch (InterruptedException e) {
			System.out.println("ERROR : WorkQueue put error");
			e.printStackTrace();
		}
	}

	public TcpWorker getWork() {
		try {
			return workQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
