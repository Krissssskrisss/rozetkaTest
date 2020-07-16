import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RozetkaTest extends TestRunner {
    //TODO: add access modifiers
    String expectedUserName = "Khrystyna Vasyliv";
    private RozetkaProfilePage profilePage;

    @BeforeMethod
    @Step("Login test")
    void login() {
        profilePage = new RozetkaHomePage()
                .open()
                .openLoginPopup()
                .login("vasyliv1309@gmail.com", "Hrustik2509!");
    }

    @Test
    @Step("Successful login to the Rozetka site")
    void verifySuccessfulLogIn() {
        String loggedInUserName = profilePage.getUserName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    //TODO: use @Description instead of @Step for test methods
    @Step("Verify logout from Rozetka site")
    void verifySuccessfulLogOut() {
        //TODO: rename, fix test
        String loggedOutUser = profilePage.getUserName();

        profilePage.logOut();
        assertEquals(loggedOutUser, expectedUserName);
    }

    @Test
    @Step("Verify Search for samsung containing text in 10 first links")
    void verifyProductSearch() {
        String productItem = "Samsung";
        //TODO: getLinksList()
        List<SelenideElement> searchResultList = profilePage.searchProduct(productItem).getListLink();

        for (SelenideElement product : searchResultList) {
            assertTrue(product.text().contains(productItem), "Text isn't correct");
            //TODO: move out of loop
            assertTrue(searchResultList.size() >= 10, "Not correct count of results");
        }
    }

    @Test
    void verifySmartPhonePage() {
        String priceMinRange = "3000";
        String priceMaxRange = "6000";
        // profilePage
        //    .openSmartphonePage()
        //    .setPriceRange(3000, 6000);
        
        // List<String> pricesList = profilePage.getProductsPrices();
        // assert price > 3000 && price < 6000
        List<SelenideElement> priceSearchResultList = profilePage
                .goToSmartPhonePage().verifyPriceRange("3000", "6000").verifyPriceRangeOnThePage();

        for (SelenideElement product : priceSearchResultList) {
            assertTrue(product.text().contains(priceMaxRange), "Price isn't correct");
        }
    }


}
