import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class LoginPopup  {

    public RozetkaProfilePage login(String username, String password){

        Selenide.
                $(By.id("auth_email")).setValue(username);
        Selenide.
                $(By.id("auth_pass")).setValue(password);
        Selenide.
                $x("//button[@class='button button_size_large button_color_green auth-modal__submit']").click();
       Selenide.refresh();
        return new RozetkaProfilePage();
    }
}
