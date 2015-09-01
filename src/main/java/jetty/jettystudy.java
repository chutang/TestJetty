package jetty;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;

public class jettystudy {
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(jettystudy.class);
		 Server  server = new Server(8080);
		 try {
			 server.setHandler(new HelloHandler());
			server.start();
			
			Thread.sleep(9000);
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
