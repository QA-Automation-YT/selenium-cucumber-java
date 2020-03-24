package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el boton " + element);
        }
    }

    public void click(WebElement element) throws Exception {
        try {
            element.click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el boton " + element);
        }
    }

    public boolean isDisplayed(By element) throws Exception {
        try {
            return driver.findElement(element).isDisplayed();
        }catch (Exception e){
            throw new Exception("El elemento " + element + " no es visible en el DOM");
        }
    }

    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        }catch (Exception e){
            throw new Exception("El elemento " + element + " no es visible en el DOM");
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }

    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }
    }

    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el titulo de la pestaña");
        }

    }


}
