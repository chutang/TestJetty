package jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler{
	public void handle(String arg0,Request arg1,HttpServletRequest baseRequest,HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		((Request) baseRequest).setHandled(true);
		response.getWriter().println("<h1>Hello word! </h1>");
		

	}



}
