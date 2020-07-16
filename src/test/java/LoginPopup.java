import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPopup {
    @Step("login to the site")
    public RozetkaProfilePage login(String username, String password) {

        //TODO: static import
        Selenide.
                $(By.id("auth_email")).setValue(username);
        Selenide.
                $(By.id("auth_pass")).setValue(password);

        $x("//button[@class='button button_size_large button_color_green auth-modal__submit']").click();
        Selenide.refresh();
        return new RozetkaProfilePage();
    }
}
