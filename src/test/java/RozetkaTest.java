import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    private RozetkaProfilePage profilePage;


    @BeforeMethod
    void login(){
        profilePage = new RozetkaHomePage()
                .open()
                .openLoginPopup()
                .login("vasyliv1309@gmail.com", "Hrustik2509!");

    }

    @Test
    void verifySuccessfulLogIn() {

        String expectedUserName = "Khrystyna Vasyliv";
        String loggedInUserName = profilePage.getUserName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    void verifySuccessfulLogOut() {
                profilePage.logOut();

    }

    @Test
    void verifySamsungSearch(){

        String searchItem = "Samsung";
        List<SelenideElement>  searchResultList =  profilePage.searchSamsung().getListLink();

        List<SelenideElement> tenLinksElements = searchResultList;

        assertTrue(tenLinksElements.size() >= 10, "Not correct search result");
        assertTrue(tenLinksElements.contains(searchItem), "Text isn't correct");

    }

}
