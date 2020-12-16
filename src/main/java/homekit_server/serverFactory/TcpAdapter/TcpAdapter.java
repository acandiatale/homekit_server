package homekit_server.serverFactory.TcpAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpAdapter implements Runnable{
//	private ServerSocketChannel socketChannel;
//	private TcpConnector connector;
//	private TcpAccepter accepter;
	private TcpSender sender;
//	private TcpReader reader;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public TcpAdapter() {
//		connector = new TcpConnector();
		sender = new TcpSender();
//		reader = new TcpReader();
//		accepter = new TcpAccepter();
	}

	private void checkAlive(Socket socket) {
//		socket.
	}
	
	public void run() {
		try(ServerSocket serverSocket = new ServerSocket()) {
			System.out.println("========== TCP_Adapter Start ==========");
			serverSocket.bind(new InetSocketAddress("121.157.47.56", 13579));
			Thread senderThread = new Thread(sender, "tcpSender");
			senderThread.start();
			while(true) {
				Socket socket = serverSocket.accept();
				sender.setSocket(socket);
//				logger.info("Device connected : " + socket.getRemoteSocketAddress());
				sender.setSocket(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void run() {
//		try(ServerSocketChannel serverSocketChannel  = ServerSocketChannel.open()) {
//			socketChannel = serverSocketChannel;
//			socketChannel.bind(new InetSocketAddress("localhost", 13579));
//			socketChannel.configureBlocking(false);
//			
//			// 채널관리자 생성 및 채널 등록
//			Selector selector = Selector.open();
//			socketChannel.register(selector, SelectionKey.OP_ACCEPT);
//			logger.info("TCP_Adapter init");
//			while(true) {
//				// 이벤트 발생까지 쓰레드 블로킹
//				selector.select();
//				
//				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
//				while(keys.hasNext()) {
//					SelectionKey key = keys.next();
//					keys.remove();
//					
//					if(key.isAcceptable()) {
//						
//					}else if(key.isReadable()) {
//						
//					}else if(key.isWritable()) {
//						
//					}
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	
}
