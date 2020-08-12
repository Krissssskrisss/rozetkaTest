import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
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
        String loggedInUserName = profilePage.getUsername();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    @Description("Verify logout from  the Rozetka site")
    void verifySuccessfulLogOut() {

        profilePage.logOut();
        String loggedOutUserName = profilePage.getUsername();
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
        int priceMinRange = 3000;
        int priceMaxRange = 6000;

        List<Integer> priceSearchResultList = profilePage
                .openSmartphonePage().setPriceRange("3000", "6000").resultsOfPriceRangeOnThePage();


        for (Integer price : priceSearchResultList) {
            assertTrue(price >= priceMinRange, "Price is too low");
            assertTrue(price <= priceMaxRange, "Price is too high");

        }
    }



    @Test //TODO: redo
    void verifyComparingTwoProducts() {

        ArrayList<Bicycle> itemsWeAreLookingFor = new ArrayList<>();
        itemsWeAreLookingFor.add(new Bicycle(1, "Ardis Santana"));
        itemsWeAreLookingFor.add(new Bicycle(5, "Formula Blade"));

        //I don't know if you already use lambdas
        List<String> expectedItemNames = itemsWeAreLookingFor.stream()
                .map(Bicycle::getName)
                .collect(Collectors.toList());


        List<SelenideElement> actualProductsInComparison =
                profilePage
                        .openSportAndAccessories()
                        .openBicyclePage()
                        .addProductsForComparison(itemsWeAreLookingFor)
                        .actualResultsForItemNames(itemsWeAreLookingFor);



        List<String> actualProductTexts = new ArrayList<>();
        for (SelenideElement product: actualProductsInComparison) {
            actualProductTexts.add(product.getText().trim());
        }
//        List<String> actualProductTexts = actualProductsInComparison.stream()
//                .map(SelenideElement::getText)
//                .collect(Collectors.toList());
        assertThat(actualProductTexts,  containsInAnyOrder(expectedItemNames));
    }

}
