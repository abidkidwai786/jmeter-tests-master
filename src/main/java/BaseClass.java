import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {


    public RemoteWebDriver driver;

    @BeforeClass
    public void setupApplication() throws MalformedURLException, InterruptedException {
        String username = "<username>";
        String authkey = "<access key>";
        String hub = "@hub.lambdatest.com/wd/hub";

        System.out.println("Test print line");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", "Sampletest A");
        caps.setCapability("plugin", "git-testng");

        System.out.println("Test print line");
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

       // System.out.println(driver.toString());

        /*WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(true);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
        //driver.get("https://www.lambdatest.com/support/docs/lambda-tunnel-for-corporate-firewalls-enterprise-restricted-environments/");

        Thread.sleep(2000);
    }

    @AfterClass
    public void closeApplication()
    {
        driver.quit();
    }
}
