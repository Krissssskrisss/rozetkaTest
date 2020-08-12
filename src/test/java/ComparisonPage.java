import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Collection;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.$x;
public class ComparisonPage {
    @Step("Check the products containing the correct name")
    public SelenideElement expectedResults() { //TODO: rename, pass in parameters
        ArrayList<SelenideElement> expectedResults = new ArrayList<SelenideElement>();
        SelenideElement product1 = $x("//a[contains(text(),'Ardis Santana 24\" 15\" 2019')]").waitUntil(matchesText("Ardis Santana"), 8000);
        SelenideElement product2 = $x("//a[contains(text(),'Formula Blade 14G DD 14\" 26\" AL 2020')]").waitUntil(matchesText("Formula Blade"), 8000);

        expectedResults.add(product1);
        expectedResults.add(product2);

        return (SelenideElement) expectedResults;

    }

}
