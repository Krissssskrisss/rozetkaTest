import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultsPage {
    @Step("Verify 10 first links contain product")
    public List<SelenideElement> getLinksList() {

        List<SelenideElement>  searchResults = $$x("div[@id='content']/div[@name='page']/div[@class='search']/div[@class='wrap']/div[2]");

        return searchResults;
    }

}
