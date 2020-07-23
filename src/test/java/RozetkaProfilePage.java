import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class RozetkaProfilePage {

    @Step("Verify Login Username on the site")
    public String verifyUserName() {
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
        $x("//li[2]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[1]//a[1]")
                .click();

        return new SmartPhonePage();

    }
}
