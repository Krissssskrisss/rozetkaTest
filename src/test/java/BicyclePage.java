import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class BicyclePage {
    @Step("Add two products to compare")
    public ComparisonPage addTwoProductsForComparison(List<Bicycle> products) { //TODO: rename method or re-do
        for (Bicycle product : products) {
            $x("//li[" + product.id + "]//app-compare-button[1]//button[1]").setValue(product.name); //TODO: work with relative locators
        }
        $x("//a[@class='comparison-modal__link']").click();

        return new ComparisonPage();
    }
}
