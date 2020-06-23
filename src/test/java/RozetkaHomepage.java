import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RozetkaHomepage {
    public RozetkaHomepage navigateToLoginForm() {

        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .sendKeys(Keys.ENTER);
        return this;
    }

    public RozetkaUserPage loginToTheSite() {

        Selenide.
                $(By.id("auth_email")).setValue("vasyliv1309@gmail.com");
        Selenide.
                $(By.id("auth_pass")).setValue("Hrustik2509!");
        Selenide.
                $x("//button[@class='button button_size_large button_color_green auth-modal__submit']").click();

        return new RozetkaUserPage();
    }
}


