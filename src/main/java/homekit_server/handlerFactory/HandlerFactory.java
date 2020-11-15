package homekit_server.handlerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewriteRegexRule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homekit_server.httpServlet.TurnOffServlet;
import homekit_server.httpServlet.TurnOnServlet;

public class HandlerFactory {
	private static File resourceFile = new File("dist");
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public HandlerList setHandlerList() {
		if(resourceFile == null) {
			System.out.println("resourceFile is empty or can't find it");
			System.exit(10);
		}
		// for history mode
		RewriteHandler rewrite = new RewriteHandler();
		rewrite.setRewriteRequestURI(true);		
		rewrite.setRewritePathInfo(false);
		rewrite.setOriginalPathAttribute("requestedPath");
		
		RewriteRegexRule rule = new RewriteRegexRule();
		rule.setRegex("\\/main");
		rule.setReplacement("/index.html");
		
		rewrite.addRule(rule);
		
		//set resourceHandler
		URI uri = URI.create(resourceFile.toURI().toASCIIString().replace("/index.html$", "/"));
//		System.out.println("resource URI = " + uri.toString());
		logger.info("resource URI = " + uri.toString());
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		
		handler.setContextPath("/");
		handler.setWelcomeFiles(new String[] {"index.html"});
		try {
			handler.setBaseResource(Resource.newResource(uri));
		} catch (MalformedURLException e) {
			logger.error("Fail to set ResourceURI");
//			System.out.println("Fail to set ResourceURI");
			e.printStackTrace();
		}
		
		rewrite.setHandler(handler);
		
		handler.addServlet(DefaultServlet.class, "/");
		
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(TurnOnServlet.class, "/turn_on");
		servletHandler.addServletWithMapping(TurnOffServlet.class, "/turn_off");
		HandlerList handlerList = new HandlerList();
		
		FilterHolder cors = new FilterHolder(CrossOriginFilter.class);
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,POST,HEAD");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, "false");
		cors.setName("cross-origin");
		FilterMapping fm = new FilterMapping();
		fm.setFilterName("cross-origin");
		fm.setPathSpec("*");
		servletHandler.addFilter(cors, fm);
		
		
		handlerList.setHandlers(new Handler[] {servletHandler, rewrite});
		
		return handlerList;
	}
	
}
