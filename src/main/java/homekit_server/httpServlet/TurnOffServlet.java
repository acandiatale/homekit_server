package homekit_server.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import homekit_server.serverFactory.TcpAdapter.TcpManager;
import homekit_server.serverFactory.TcpAdapter.TcpWorker;

@SuppressWarnings("serial")
public class TurnOffServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		System.out.println(req.getMethod());
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		JsonObject json = new JsonObject();
		json.addProperty("switch", "OFF");
		pw.print(json.toString());
		pw.flush();
		pw.close();
		TcpManager.getInstance().setWork(new TcpWorker(false));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
