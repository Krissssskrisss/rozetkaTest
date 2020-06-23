import com.codeborne.selenide.Selenide;

public class RozetkaUserPage  {

    public String getLoginUSerName(){
      String text = "Khrystyna Vasyliv";
        Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']")
                .getText();
        return text;

    }

    public RozetkaUserPage logOutFromTheSite() {
     Selenide
                .$x("//a[@class='header-topline__user-link link-dashed']").click();
        Selenide
                .$x("//div[@class='header-topline']//li[14]//a[1]").click();

        return this;
    }
}
