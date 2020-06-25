package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;
import java.util.concurrent.TimeUnit;


public class Hooks {

    private static WebDriver driver;
    private DriverManager driverManager;

    @Before("@browser")
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();

        /* ************************************************************

                              -> Espera Implícita <-
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ************************************************************ */

        driver.get("https://imalittletester.com/");
        driver.manage().window().maximize();
    }

    @After("@browser")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
