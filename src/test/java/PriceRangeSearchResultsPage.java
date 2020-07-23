import io.qameta.allure.Step;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class PriceRangeSearchResultsPage {

    @Step("Verify  product are in the correct price rang")
    //TODO: rename
    //TODO: use Selenide $$x().texts();
    public List<String> verifyPriceRangeOnThePage() {
        return Collections.singletonList($x("//section[@class='content js_content content_type_catalog']").getText());

    }
}
