import com.codeborne.selenide.Selenide;

public class RozetkaUserPage {

    public String getUserName() {
        String text = Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .getText();
        return text;
    }

    public RozetkaUserPage logOutFromTheSite() {

        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']").click();
        Selenide
                .$x("//div[@class='header-topline']//li[14]//a[1]").click();
        Selenide.refresh();
        return this;
    }
}
