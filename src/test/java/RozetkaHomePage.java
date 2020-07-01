import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RozetkaHomePage {

    public RozetkaHomePage open() {
        Selenide.open("https://rozetka.com.ua/");

        return this;
    }
    public LoginPopup openLoginPopup() {

        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .sendKeys(Keys.ENTER);
        return new LoginPopup();
    }


}
