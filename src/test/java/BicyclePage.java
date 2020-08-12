import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class BicyclePage {
    @Step("Add two products to compare")
    public ComparisonPage addProductsForComparison(List<Bicycle> products) {
        for(Bicycle product : products) {
            $x("//li["+product.id+"]//app-compare-button[1]//button[1]").setValue(product.name);
        }
        $x("//a[@class='comparison-modal__link']").click();

        return new ComparisonPage();
    }
}
