import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.$$x;
import static org.testng.Assert.assertTrue;

public class SearchSamsungPage {

    public List<SelenideElement> getListLink() {

        ElementsCollection searchResults = $$x("div[@id='content']/div[@name='page']/div[@class='search']/div[@class='wrap']/div[2]");
        List<SelenideElement> linkList = new ArrayList<>();
        int i = 0;
        for (SelenideElement el : searchResults) {
            linkList.add(el);
        }
        return linkList;

    }



}


