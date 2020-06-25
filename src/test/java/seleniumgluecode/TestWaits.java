package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class TestWaits extends TestBase{

    @Given("^El usuario se encuentra en la pagina Home$")
    public void elUsuarioseEncuentraEnLaPaginaHome(){
        driver.navigate().to("http://localhost:3000/");
    }

    @When("^Hace click en el boton Start$")
    public void haceClickEnElBotonStart(){
        WebElement start = driver.findElement(By.id("btn-start"));
        start.click();
    }

    @Then("^Visualiza la pagina de Badges$")
    public void visualizaLaPaginaDeBadges(){

        /* ************************************************************************************************

                              -> Espera Explícita <-
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement newBadge = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-new-badge")));

        ************************************************************************************************* */

        /* ************************************************************************************************

                              -> Espera Fluída <-
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement newBadge = fwait.until(driver -> driver.findElement(By.id("btn-new-badge")));

        ************************************************************************************************* */

        WebElement newBadge = driver.findElement(By.id("btn-new-badge"));
        assert newBadge.isDisplayed();
    }

}
