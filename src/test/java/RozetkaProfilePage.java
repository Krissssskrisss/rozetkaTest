import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class RozetkaProfilePage {
    @Step("Verify Login to the site")
    public String getUserName() {
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

    @Step("Search for samsung product")
    public SearchResultsPage searchProduct(String searchItem) {
        $x("//input[@name='search']")
                .setValue(searchItem)
                .sendKeys(Keys.ENTER);
        $x(("//div[@id='block_with_search']/div/div[2]/div/div/div"));
        //     .shouldHave(matchesText(searchItem));
        return new SearchResultsPage();

    }

    @Step("Go to the Smartphone tab")
    public SmartPhonePage goToSmartPhonePage() {
        $x("//sidebar-fat-menu//li[2]//a[1]").click();
        $x("//li[2]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[1]//a[1]")
                .click();

        return new SmartPhonePage();

    }
}
