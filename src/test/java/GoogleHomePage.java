import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import javax.naming.directory.DirContext;

public class GoogleHomePage {
    public GoogleHomePage openGoogleHomepage() {
        Selenide.open("https://www.google.com/");
        return this;
    }
    public GoogleSearchResultPage search(String text) {
        Selenide.$x("//input[@name='q']")
                .setValue(text)
                .sendKeys(Keys.ENTER);
        return new GoogleSearchResultPage();
    }
}
