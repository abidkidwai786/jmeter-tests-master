//This is maven project

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class Lambdatest {

	public RemoteWebDriver driver = null;
   String username = "<username>";
	String accessKey = "<access key>";
	
	@BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "MacOS Big sur");
	     capabilities.setCapability("browserName", "Chrome");
	     capabilities.setCapability("version", "91.0"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Test");
        capabilities.setCapability("name", "Sample Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
    
        try {       
			driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);            
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }
    }

	@Test(enabled = true)
	public void testScript() throws Exception {
				try {
					driver.get("https://lambdatest.github.io/sample-todo-app/");
					driver.findElement(By.name("li1")).click();
					driver.findElement(By.name("li2")).click();
					driver.findElement(By.id("sampletodotext")).clear();
					driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
					driver.findElement(By.id("addbutton")).click();
					driver.quit();					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	}
}
