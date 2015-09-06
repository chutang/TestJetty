package jetty;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class jettystudy {
	private static Logger logger = Logger.getLogger(jettystudy.class);
	public static void main(String[] args) throws Exception {
		
	hw();
		
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
	
	public static void hw(){
		Server  server = new Server(8080);
		 try {
			 server.setHandler(new HelloHandler());
			server.start();
			testsite();
			
			Thread.sleep(2000);
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testsite() throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.get("localhost:8080");
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
