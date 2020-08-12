import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PriceRangeSearchResultsPage {

    @Step("Check the list of products results are in the correct price rang")
    public List<Integer> resultsOfPriceRangeOnThePage() {
        List<Integer> result = new ArrayList<>();
        $$x("//section[@class='content js_content content_type_catalog']").texts();

        return  result;

    }
}
