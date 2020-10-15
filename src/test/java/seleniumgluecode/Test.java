package seleniumgluecode;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import db.MongoDBHelper;
import org.bson.Document;
import org.junit.Assert;
import utils.LogHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test extends TestBase{

    private int start;
    private int left;
    MongoDatabase mongoDataBase = null;
    Document mipcgamer = null;
    private static final Logger LOGGER = LogHelper.getLogger(Test.class);

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

    @Given("^Me he conectado a la base de datos mipcgamer$")
    public void meHeConectadoALaBaseDeDatosMipcgamer() {
        mongoDataBase = MongoDBHelper.getDataBase("mipcgamer");
    }

    @When("^Obtengo la PC de QA Automation$")
    public void obtengoLaPCDeQAAutomation() {
        MongoCollection<Document> collection = MongoDBHelper.getCollectionFromDb(mongoDataBase, "components");
        mipcgamer = MongoDBHelper.getDocumentBykeyValue(collection, "pc", "PC de QA Automation");
    }

    @Then("^Debo obtener los siguientes componentes \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void deboObtenerLosSiguientesComponentes(String mother, String cpu, String firstSlot, String secondSlot){
        String motherDb = (String)MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "mother");
        LOGGER.log(Level.INFO, "Mother: " + motherDb);
        Assert.assertEquals(mother, motherDb);

        String cpuDb = (String)MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "cpu");
        LOGGER.log(Level.INFO, "Cpu: " + cpuDb);
        Assert.assertEquals(cpu, cpuDb);

        Document rams = (Document)MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "memory");
        String firstSlotDb = (String)MongoDBHelper.getElementByKeyFromDocument(rams, "slot1");
        String secondSlotDb = (String)MongoDBHelper.getElementByKeyFromDocument(rams, "slot2");
        LOGGER.log(Level.INFO, "Primer slot: " + firstSlotDb);
        LOGGER.log(Level.INFO, "Segundo slot: " + secondSlotDb);
        Assert.assertEquals(firstSlot, firstSlotDb);
        Assert.assertEquals(secondSlot, secondSlotDb);

    }
}
