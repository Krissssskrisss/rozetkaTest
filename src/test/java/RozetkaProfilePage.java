import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;

public class RozetkaProfilePage {

    public String getUserName() {
        String text = Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .getText();
        return text;
    }

    public RozetkaProfilePage logOut() {

        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .click();
        Selenide
                .$x("//div[@class='header-topline']//li[14]//a[1]")
                .click();
        Selenide.
                $x("//a[@class='header-topline__user-link link-dashed']")
                .shouldHave(text("войдите в личный кабинет"));


        return this;
    }


    public SearchSamsungPage searchSamsung(){
        Selenide
                .$x("//input[@placeholder='Я ищу...']")
                .setValue("Samsung")
                .sendKeys(Keys.ENTER);

        Selenide
                .$(By.className("catalog-list"))
                .shouldHave(text("Samsung"));

        return new SearchSamsungPage();

    }
}
