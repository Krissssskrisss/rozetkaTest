import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SportAndAccessories {

    @Step("Open the Bicycle page")
    public BicyclePage openBicyclePage() {
        $x("//a[contains(@href, 'https://rozetka.com.ua/velosipedy-i-aksessuary/c83882/')]")
                .click();

        return new BicyclePage();

    }
    @Step("Add Items to ShoppingCart ")
        public ShoppingCart  addItemsToCart(){

            $(By.id("244388593")).click();
            $(By.id("goods_id=\"244312099\"")).click();
            $(By.id("goods_id=\"244265359\"")).click();
            $(By.id("goods_id=\"244252309\"")).click();

            $x("//div[@class='js-rz-cart']//div[@class='header-actions__button-wrapper']").click();

            return new ShoppingCart();
        }


}


