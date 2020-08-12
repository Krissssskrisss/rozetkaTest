import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BicyclePage {
    @Step("Add two products to compare")
    public ComparisonPage addTwoProductsForComparison(String product1, String product2) {

      $x("//li[1]//app-compare-button[1]//button[1]").setValue(product1);
        $x("//li[5]//app-compare-button[1]//button[1]").setValue(product2);
        $x("//a[@class='comparison-modal__link']").click();

        return new ComparisonPage();
    }
}
