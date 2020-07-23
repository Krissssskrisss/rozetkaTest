import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class priceRangeSearchResultsPage {

    @Step("Verify  product are in the correct price rang")
    public List<SelenideElement> verifyPriceRangeOnThePage(){

        List<SelenideElement>  priceRangeSearchResults = $$x("//section[@class='content js_content content_type_catalog']");

        return priceRangeSearchResults;
    }
}
