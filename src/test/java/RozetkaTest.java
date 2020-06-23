import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RozetkaTest {

    @Test
    void verifySuccessfulLogIn() {

        String expectedUserName = "Khrystyna Vasyliv";
        RozetkaUserPage resultPage = new GoogleHomePage()
                .openGoogleHomepage()
                .search("rozetka")
                .navigateToRozetkaPage()
                .navigateToLoginForm()
                .loginToTheSite();

        String loggedInUserName = resultPage.getUserName();
        assertEquals(loggedInUserName, expectedUserName);

    }

    @Test
    void verifySuccessfulLogOut() {

        String expectedUserName = "войдите в личный кабинет";
        RozetkaUserPage resultPage = new GoogleHomePage()
                .openGoogleHomepage()
                .search("rozetka")
                .navigateToRozetkaPage()
                .navigateToLoginForm()
                .loginToTheSite()
                .logOutFromTheSite();

        String loggedOutUserName = resultPage.getUserName();
        assertEquals(loggedOutUserName, expectedUserName);
    }


}
