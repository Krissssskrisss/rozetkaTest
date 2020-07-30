import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BicyclePage {
    @Step("Add two products to compare")
    public ComparisonPage addTwoProductsForComparison() {

        $x("//li[1]//app-compare-button[1]//button[1]").click();
        $x("//li[5]//app-compare-button[1]//button[1]").click();
        $x("//a[@class='comparison-modal__link']").click();

        return new ComparisonPage();
    }
}
