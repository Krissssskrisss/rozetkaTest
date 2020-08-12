import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.$x;
public class ComparisonPage {
    @Step("Check the products containing the correct name")
    public List<SelenideElement> actualResultsForItemNames(List<Bicycle> itemsWeAreLookingFor) { //TODO: rename, pass in parameters
        ArrayList<SelenideElement> actualResults = new ArrayList<SelenideElement>();
        for (Bicycle item: itemsWeAreLookingFor) {
            actualResults.add($x("//a[contains(text(),'" + item.name + "')]").waitUntil(matchesText(item.name), 8000));
        }
        return actualResults;

    }

}
