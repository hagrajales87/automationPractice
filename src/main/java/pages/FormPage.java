package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    private By emailField = By.id("email");
    private By orderField = By.id("id_order");
    private By Heading = By.id("id_contact");
    private By userSubjectHeadingSelected =By.cssSelector("#uniform-id_contact span[style*='user-select']");
    private By messageField = By.id( "message");
    private By submitMessageField = By.id( "submitMessage");
    private By successAlertField = By.cssSelector("[class*=alert-success]");

    private WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
    }

    public void sendEmail(String emailAddress){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(emailAddress);
    }

    public String getEmail(){
        return driver.findElement(emailField).getAttribute("value");
    }

    public void clickSubjectHeading(){
        driver.findElement(Heading).click();
    }

    public void selectContact(int value){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='"+value+"']")));
        driver.findElement(By.cssSelector("option[value='"+value+"']")).click();
    }

    public String getSubjectHeading(){
        System.out.println("This is the value: "+ driver.findElement(userSubjectHeadingSelected).getText());
        return driver.findElement(userSubjectHeadingSelected).getText();
    }

    public String getExpectedValue(int value){

        String contact;
        switch(value){
            case 0: contact = "-- Choose --";
                    break;
            case 1: contact = "Webmaster";
                    break;
            case 2: contact = "Customer service";
                    break;
            default: contact= "Invalid Option";
            break;
        }
        return contact;
    }

    public void sendOrderReference(String orderReference){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderField));
        driver.findElement(orderField).sendKeys(orderReference);
    }

    public String getOrderReference(){
        return driver.findElement(orderField).getAttribute("value");
    }

    public void sendMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public String getMessage(){
        return driver.findElement(messageField).getText();
    }

    public void clickOnSendMessageButton(){
        driver.findElement(submitMessageField).click();
    }

    public String getAlertMessage(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertField));
        return driver.findElement(successAlertField).getText();
    }
}
