import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCart {


    @Step("Check Items in ShoppingCart ")

    public ArrayList<SelenideElement> checkShoppingCart() {

        ArrayList<SelenideElement> items = new ArrayList<>();
        items.add(1,$(By.id("244252309")));
        items.add(2,$(By.id("goods_id=\"244312099\"")));
        items.add(3,$(By.id("goods_id=\"244265359\"")));
        items.add(4,$(By.id("goods_id=\"244252309\"")));

        return items;

    }
    @Step("Remove Items from ShoppingCart ")
    public SelenideElement deleteItemsFromCart(ArrayList<SelenideElement> items) {

        for (SelenideElement item : items) {
            $x(item + "//li[@class='cart-list__item']//li[1]//button[1]").click();
        }
        return null;
    }

}
