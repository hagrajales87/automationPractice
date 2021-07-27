package contactForm;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormPage;

import static org.testng.Assert.assertEquals;

@Test
public class InsertDataTest extends BaseTest {

    SoftAssert softassert = new SoftAssert();

    @Parameters({"emailAddress", "orderReference", "subHeading", "message"})
    public void testForm(String emailAddress, String orderReference, int subHeading, String message){

        var formPage = homePage.clickContactUs();
        formPage.sendEmail(emailAddress);
        softassert.assertEquals(emailAddress,formPage.getEmail());

        formPage.clickSubjectHeading();
        formPage.selectContact(subHeading);
        softassert.assertEquals(formPage.getExpectedValue(2),formPage.getSubjectHeading());

        formPage.sendOrderReference(orderReference);
        softassert.assertEquals(orderReference,formPage.getOrderReference());

        formPage.sendMessage(message);
        softassert.assertEquals(message, formPage.getMessage());

        formPage.clickOnSendMessageButton();
        softassert.assertEquals(formPage.getAlertMessage(), "Your message has been successfully sent to our team.");
    }

}
