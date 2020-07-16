import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class RozetkaProfilePage {
    //TODO: fix step
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

    //TODO: fix step
    @Step("Search for samsung product")
    public SearchResultsPage searchProduct(String searchItem) {
        $x("//input[@name='search']")
                .setValue(searchItem)
                .sendKeys(Keys.ENTER);
        //TODO: use relative locator
        $x(("//div[@id='block_with_search']/div/div[2]/div/div/div"));
        //TODO: add comment or remove
        //     .shouldHave(matchesText(searchItem));
        return new SearchResultsPage();

    }
    //TODO: openSmartphonePage(), fix step
    @Step("Go to the Smartphone tab")
    public SmartPhonePage goToSmartPhonePage() {
        $x("//sidebar-fat-menu//li[2]//a[1]").click();
        //TODO: use relative locator
        $x("//li[2]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[1]//a[1]")
                .click();

        return new SmartPhonePage();

    }
}
