package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.ComicsPage;
import pom.HomePage;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected ComicsPage comicsPage = PageFactory.initElements(driver, ComicsPage.class);
}
