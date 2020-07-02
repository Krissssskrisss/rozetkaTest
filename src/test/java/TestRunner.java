import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestRunner {
    //TODO: @replace BeforeClass
    @BeforeMethod
    public void configBrowser() {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        //TODO: add more timeout
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
