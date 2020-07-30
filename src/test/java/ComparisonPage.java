import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.$x;

public class ComparisonPage {
    @Step("Check the first product contain correct name")
    public SelenideElement verifyFirstProductToCompare() {

        SelenideElement product1 = $x("//a[contains(text(),'Ardis Santana 24\" 15\" 2019')]").waitUntil(matchesText("Ardis Santana"), 8000);
        return product1;
    }

    @Step("Check the second product contain correct name")
    public SelenideElement verifySecondProductToCompare() {
        SelenideElement product2 = $x("//a[contains(text(),'Formula Blade 14G DD 14\" 26\" AL 2020')]").waitUntil(matchesText("Formula Blade"), 8000);
        return product2;
    }
}
