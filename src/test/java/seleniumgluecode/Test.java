package seleniumgluecode;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Test extends TestBase{

    private int start;
    private int left;

    @Given("^El usuario se encuentra en la pagina Home de imalittletester$")
    public void elUsuarioSeEncuentraEnLaPaginaHomeDeImalittletester() throws Throwable {
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("^Hace click sobre el titulo The little tester comics$")
    public void haceClickSobreElTituloTheLittleTesterComics() throws Throwable {
        homePage.clickOnTitleComics();
}

    @Then("^Se debe redirigir a la pantalla Comics$")
    public void seDebeRedirigirAlaPantallaComics() throws Throwable {
        Assert.assertTrue("No se redirecciono correctamente a la pagina de Comics",comicsPage.isTitleComicsDisplayed());
    }

    @Given("^Hay (\\d+) cervezas$")
    public void hayCervezas(int start){
        this.start = start;
    }

    @When("^Tomo (\\d+) cervezas$")
    public void tomoCervezas(int drink){
        this.left = this.start - drink;
    }

    @Then("^Deberian quedar (\\d+) cervezas$")
    public void deberianQuedarCervezas(int left){
        Assert.assertEquals(left, this.left);
    }

    @Given("^Un blog llamado \"([^\"]*)\" con el siguiente contenido$")
    public void unBlogLlamadoConElSiguienteContenido(String doubleQuotes, String payload){
        System.out.println(doubleQuotes);
        System.out.println(payload);
    }

    @Given("^Los siguientes usuarios existentes:$")
    public void losSiguientesUsuariosExistentes(DataTable table){
        List<List<String>> rows = table.asLists(String.class);
        List<List<String>> rowsWithoutHeading = rows.subList(1,rows.size());

        for (List<String> row : rowsWithoutHeading)
            System.out.println("nombre: " + row.get(0) + " email: " + row.get(1) + " twitter: " + row.get(2));
    }
}
