import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RozetkaTest {

    @Test
    void verifySuccessfulLogIn() {

        String expectedUserName = "Khrystyna Vasyliv";
        RozetkaUserPage resultPage = new GoogleHomePage()
                .openGoogleHomepage()
                .search("rozetka")
                .navigateToRozetkapage()
                .navigateToLoginForm()
                .loginToTheSite();

        String loggedInUserName = resultPage.getLoginUSerName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    void verifySuccessfulLogOut() {
        RozetkaUserPage resultPage = new GoogleHomePage()
                .openGoogleHomepage()
                .search("rozetka")
                .navigateToRozetkapage()
                .navigateToLoginForm()
                .loginToTheSite()
                .logOutFromTheSite();
    }


}
