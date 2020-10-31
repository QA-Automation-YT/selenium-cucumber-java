package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.LogHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@backend"}
)

public class Testrunner {

    private static final Logger LOGGER = LogHelper.getLogger(Testrunner.class);

    @BeforeClass()
    public static void setUp(){
        LOGGER.log(Level.INFO, "Test execution begins...");
    }

    @AfterClass
    public static void teardown(){
        try {
            LOGGER.log(Level.INFO, "Generating report...");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            LOGGER.log(Level.INFO, "Report successfully generated!");
        }catch (Exception ex){
            LOGGER.log(Level.WARNING, "The report could not be generated.");
            ex.printStackTrace();
        }
    }

}
