package runner.browser_manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
            createDriver();
        }
        return driver;
    }


}
