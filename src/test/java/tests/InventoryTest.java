package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;
import pages.InventoryPage;
import utils.DataDriven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPageElements() {
        JsonNode data = DataDriven.jsonReader().path("validLogin");
        InventoryPage inventoryPage = loginPage.login(
                data.path("username").asText(),
                data.path("password").asText());

        assertTrue(inventoryPage.isInventoryPage(), "Inventory page did not load");
        assertEquals(inventoryPage.getPageTitle(), "Swag Labs", "Wrong page title");
        assertTrue(inventoryPage.isCartDisplayed(), "Cart icon is not displayed");
        assertEquals(inventoryPage.getProductCount(), 6, "Expected 6 products");
    }
}
