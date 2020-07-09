import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class RozetkaHomePage {
    @Step("Open rozetka site")
    public RozetkaHomePage open() {
        Selenide.open("https://rozetka.com.ua/");

        return this;
    }

    @Step("Open Login window")
    public LoginPopup openLoginPopup() {
        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .sendKeys(Keys.ENTER);
        return new LoginPopup();
    }


}
