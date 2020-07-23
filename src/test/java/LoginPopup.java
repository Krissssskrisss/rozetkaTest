import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPopup {
    @Step("Login to the site")
    public RozetkaProfilePage login(String username, String password) {

        $(By.id("auth_email")).setValue(username);
        $(By.id("auth_pass")).setValue(password);

        $x("//button[@class='button button_size_large button_color_green auth-modal__submit']")
                .waitUntil(Condition.appears, 8000)
                .click();

        return new RozetkaProfilePage();
    }
}
