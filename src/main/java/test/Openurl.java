package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author chuta
 *
 */
public class Openurl {
	
	public static void main(String[] args) throws InterruptedException {
		final Logger logger = Logger.getLogger(Openurl.class);
		logger.info("==========Start===========");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		WebElement element = driver.findElement(By.id("kw"));
		element.sendKeys("local");
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("su"))).build().perform();
		//logger.info(element.getAttribute("value"));
		Thread.sleep(3000);		
		driver.close();
		logger.info("============End=============");
		
	}

}
