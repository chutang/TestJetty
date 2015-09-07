package jetty;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class jettystudy {
	private static Logger logger = Logger.getLogger(jettystudy.class);
	public static void main(String[] args) throws Exception {
		
		ServletTest();
		
	}
	
	public static void fileServerXml() throws Exception{
		 Resource fileserver_xml = Resource.newSystemResource("fileserver.xml");
		 logger.info("abc==");
		 logger.info(fileserver_xml.toString());
		 XmlConfiguration configuration = new XmlConfiguration(fileserver_xml.getInputStream());
		 Server server = (Server)configuration.configure();
		 server.start();
		 server.join();
	}
	
	public static void ServletTest() throws Exception{
		Server server = new Server (8080);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		
		context.addServlet(new ServletHolder(new HelloServlet()), "/a");
		context.addServlet(new ServletHolder(new HelloServlet("Hello input some argus")), "/b");
		context.addServlet(new ServletHolder(new HelloServlet()), "");
		
		server.start();
		logger.info(server.getURI());
		//testsite();
		Thread.sleep(600*1000);
		
		server.stop();
		
	}
	
	public static void hw(){
		Server  server = new Server(8080);
		 try {
			 server.setHandler(new HelloHandler());
			server.start();
			logger.info(server.getURI());
			testsite();
			logger.info(server.getURI());
			Thread.sleep(20000);
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testsite() throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.get("localhost:8080");
		Thread.sleep(1000);
		driver.close();
		
		
	}

}
