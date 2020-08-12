import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SportAndAccessories {

    @Step("Open the Bicycle page")
    public BicyclePage openBicyclePage() {
        $x("//a[contains(@href, 'https://rozetka.com.ua/velosipedy-i-aksessuary/c83882/')]")
                .click();

        return new BicyclePage();
    }
}


