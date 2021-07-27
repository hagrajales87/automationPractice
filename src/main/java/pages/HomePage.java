package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By ContactUs = By.id("contact-link");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public FormPage clickContactUs(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUs));
        driver.findElement(ContactUs).click();
        return new FormPage(driver);
    }

}
