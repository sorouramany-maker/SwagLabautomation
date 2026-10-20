package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/** Checks the page displayed after a successful login. */
public class InventoryPage {
    private final WebDriver driver;
    private final By cartIcon = By.className("shopping_cart_link");
    private final By products = By.className("inventory_item");
    private final WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isInventoryPage() {
        return wait.until(ExpectedConditions.urlContains("/inventory.html"));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon)).isDisplayed();
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.numberOfElementsToBe(products, 6));
        return driver.findElements(products).size();
    }
}
