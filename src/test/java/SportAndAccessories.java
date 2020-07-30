import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SportAndAccessories {

    @Step("Open the Bicycle page")
    public BicyclePage openBicyclePage() {

        $x("//a[contains(text(),'Велосипеды, электровелосипеды и аксессуары')]")
                .click();

        return new BicyclePage();
    }
}


