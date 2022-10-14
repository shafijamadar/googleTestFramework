package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePageObjectMethods;

public class GoogleHomePage extends BasePageObjectMethods {

   public GoogleHomePage(WebDriver driver){
        super(driver);
    }


    public void clickOnSignInButton(){
       getElementSafely(Element.signIN.locator).click();
    }

    public void enteremailId(String username){
       getElementSafely(Element.emailID.locator).clear();
        getElementSafely(Element.emailID.locator).sendKeys(username);
    }

    public void enterPassword(String password){
        getElementSafely(Element.password.locator).clear();
        getElementSafely(Element.password.locator).sendKeys(password);
    }

    public boolean isEnterPasswordPageDisplayed(){
       return getElementSafely(Element.password.locator).isDisplayed();
    }

    public void clickOnEmailNextButton(){
        getElementSafely(Element.emailnextButton.locator).click();
    }

    public void clickOnPasswordNextButton(){
        getElementSafely(Element.passwordNextButton.locator).click();
    }


    private enum Element{

        signIN(By.xpath("//div[@id='gbwa']/../following-sibling::a")),
        emailID(By.id("identifierId")),
        password(By.xpath("//input[@type='password']")),
        emailnextButton(By.id("identifierNext")),
        passwordNextButton(By.id("passwordNext")),


       ;

       private final By locator;

        Element(By locator) {
            this.locator = locator;
        }
    }

}
