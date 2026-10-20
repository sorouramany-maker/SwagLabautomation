package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import utils.DataDriven;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "validLogin")
    public Object[][] validLogin() {
        JsonNode data = DataDriven.jsonReader().path("validLogin");
        return new Object[][] {{ data.path("username").asText(), data.path("password").asText() }};
    }

    @DataProvider(name = "invalidLogin")
    public Object[][] invalidLogin() {
        JsonNode data = DataDriven.jsonReader().path("invalidLogin");
        return new Object[][] {{ data.path("username").asText(), data.path("password").asText() }};
    }

    @DataProvider(name = "withoutPassword")
    public Object[][] withoutPassword() {
        JsonNode data = DataDriven.jsonReader().path("withoutPassword");
        return new Object[][] {{ data.path("username").asText(), data.path("password").asText() }};
    }

    @Test(dataProvider = "validLogin")
    public void successfulLogin(String username, String password) {
        InventoryPage inventoryPage = loginPage.login(username, password);
        assertTrue(inventoryPage.isInventoryPage(), "User did not reach the inventory URL");
    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLogin(String username, String password) {
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected invalid-credentials error was not displayed");
    }

    @Test(dataProvider = "withoutPassword")
    public void loginWithoutPassword(String username, String password) {
        loginPage.login(username, password);
        assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Expected missing-password error was not displayed");
    }
}
