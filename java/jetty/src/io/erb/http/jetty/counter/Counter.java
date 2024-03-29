package io.erb.http.jetty.counter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Counter extends AbstractHandler {
	
	private final AtomicInteger counter = new AtomicInteger(0);
	
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/plain");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getOutputStream().write((""+counter.incrementAndGet()).getBytes());
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(8004);
		server.setHandler(new Counter());

		server.start();
		server.join(); 
	}
}