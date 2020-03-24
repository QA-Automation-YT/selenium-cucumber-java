package runner.browser_manager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type){

        DriverManager driverManager = null;

        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
                default:
                    System.out.println("Invalid browser selected");
                    break;
        }

        return driverManager;

    }

}
