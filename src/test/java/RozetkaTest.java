import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RozetkaTest extends TestRunner {
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

        String expectedUserName = "Khrystyna Vasyliv";
        String loggedInUserName = profilePage.getUserName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    @Step("Verify logout from Rozetka site")
    void verifySuccessfulLogOut() {
        profilePage.logOut();

    }

    @Test
    @Step("Verify Search for samsung containing text in 10 first links")
    void verifyProductSearch() {
        List<ElementsCollection> searchResultList = profilePage.searchProduct("Samsung").getListLink();

        assertTrue(searchResultList.toString().contains("Samsung"), "Text isn't correct");
        assertTrue(searchResultList.size() >= 10, "Not correct search result");
    }

}
