import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

public class GoogleSearchResultPage {

    public RozetkaHomepage navigateToRozetkaPage() {
        Selenide
                .$x("//body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw']/div[@id='rcnt']/div[@class='col']/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='rso']/div[@class='g']/div/div[@class='rc']/div[@class='r']/a[1]")
                .shouldHave(Condition.text("rozetka"))
                .sendKeys(Keys.ENTER);
        return new RozetkaHomepage();
    }
}
