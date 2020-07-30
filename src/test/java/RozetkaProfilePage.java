import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class RozetkaProfilePage {
    @Step("Verify Login Username on the site")
    public String getUsername() {
        return $x("//a[@class='header-topline__user-link link-dashed']")
                .getText();
    }

    @Step("Log out from rozetka site")
    public RozetkaProfilePage logOut() {

        $x("//a[@class='header-topline__user-link link-dashed']")
                .click();
        $x("//div[@class='header-topline']//li[14]//a[1]")
                .click();
        return this;
    }

    @Step("Search for Samsung product")
    public SearchResultsPage searchProduct(String searchItem) {
        $x("//input[@name='search']")
                .setValue(searchItem)
                .sendKeys(Keys.ENTER);
        $x(("//div[@name='search_list']"));

        return new SearchResultsPage();

    }

    @Step("Open the Smartphone Page")
    public SmartPhonePage openSmartphonePage() {
        $x("//sidebar-fat-menu//li[2]//a[1]").click();
        $x("//a[contains(@href, 'https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/')]")
                .click();

        return new SmartPhonePage();
    }

    public SportAndAccessories openSportAndAccessories(){

        $x("//sidebar-fat-menu//li[8]/a[1]")
                .waitUntil(Condition.appears, 8000)
                .click();

        return  new SportAndAccessories();
    }


}
