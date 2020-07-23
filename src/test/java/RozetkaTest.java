import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RozetkaTest extends TestRunner {
    private String expectedUserName = "Khrystyna Vasyliv";
    private RozetkaProfilePage profilePage;

    @BeforeMethod
    @Description("Login test")
    void login() {
        profilePage = new RozetkaHomePage()
                .open()
                .openLoginPopup()
                .login("vasyliv1309@gmail.com", "Hrustik2509!");
    }

    @Test
    @Description("Successful login to the Rozetka site")
    void verifySuccessfulLogIn() {
        String loggedInUserName = profilePage.verifyUserName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    @Description("Verify logout from  the Rozetka site")
    void verifySuccessfulLogOut() {

        profilePage.logOut();
        String loggedOutUserName = profilePage.verifyUserName();
        assertEquals(loggedOutUserName, expectedUserName);
    }

    @Test
    @Description("Verify Search for samsung containing text in 10 first links")
    void verifyProductSearch() {
        String productItem = "Samsung";
        List<SelenideElement> searchResultList = profilePage.searchProduct(productItem).getLinksList();

        for (SelenideElement product : searchResultList) {
            assertTrue(product.text().contains(productItem), "Text isn't correct");
        }
    }

    @Test
    void verifySmartPhonePage() {
        String priceMinRange = "3000";
        String priceMaxRange = "6000";

        List<String> priceSearchResultList = profilePage
                .openSmartphonePage().setPriceRange("3000", "6000").verifyPriceRangeOnThePage();


        for (String price : priceSearchResultList) {
//                assertTrue(price > priceMinRange, "Price is too low");
//                assertTrue(price < priceMaxRange, "Price is too high");

        }
    }

}
