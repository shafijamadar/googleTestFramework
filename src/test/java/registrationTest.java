import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.GoogleHomePage;
import utils.ExcelReader;;

public class registrationTest extends BaseTest{


    @Test(dataProviderClass=ExcelReader.class, dataProvider = "excelData")
    public void registrationTest(String userName, String password) {

        GoogleHomePage googleHomePage = new GoogleHomePage(BaseTest.driver);

        googleHomePage.clickOnSignInButton();
        googleHomePage.enteremailId(userName);
        googleHomePage.clickOnEmailNextButton();
        Assert.assertTrue(googleHomePage.isEnterPasswordPageDisplayed(), "Enter Password page is restricted due to google restication ");
        googleHomePage.enterPassword(password);
        googleHomePage.clickOnPasswordNextButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox", "Applicant is logged in successfully into the gmail account");
    }
}
