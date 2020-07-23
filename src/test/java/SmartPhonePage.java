import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class SmartPhonePage {
    @Step("Enter price range to the product")
    public PriceRangeSearchResultsPage setPriceRange(String priceMin, String priceMax) {

        $x("//ctg-filter-slider[@class='filter_layout_sidebar']//input[1]")
                .setValue(priceMin);
        $x("//body//input[2]").setValue(priceMax);
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']")
                .click();

        return new PriceRangeSearchResultsPage();
    }
}
