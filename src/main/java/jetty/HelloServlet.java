package jetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String msg="hello world";
	public HelloServlet(){
		
	}
	public HelloServlet(String info){
		this.msg = info;
	}

	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String pd = request.getParameter("pd");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>"+msg+"</h1>");
		response.getWriter().println("testing </br>session="+request.getSession(true).getId()+"</br>");
		if(name!=null){
			response.getWriter().println("Name="+name+"</br>");
		}
		if(pd!=null){
			response.getWriter().println("pd="+pd+"</br>");
		}
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h1> test Servlet<h1>");
//		out.println("Hello , Everyone");
//		out.println("</body>");
//		out.println("</html>");
	}
	

}
