import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

//TODO: SearchResultsPage
public class SearchResultsPage {
    //TODO: don't hardcord samsung
    @Step("Verify 10 first links contain Samsung")
    public List<SelenideElement> getListLink() {

        List<SelenideElement>  searchResults = $$x("div[@id='content']/div[@name='page']/div[@class='search']/div[@class='wrap']/div[2]");

        return searchResults;
    }

}
