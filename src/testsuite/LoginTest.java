package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find the element of sign in click on sign in
        clickOnElement(By.linkText("Sign In"));
        //this os form requirement
        String expectedLogInText = "Welcome Back!";
        //find the welcome text element and get the text
        String actualLogInText = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        //Verify the text error message with assert
        verifyTextMessage(expectedLogInText,actualLogInText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find the element of sign in click on sign in
        clickOnElement(By.linkText("Sign In"));
        //find the element of username and send the username key
        sendTextToElement(By.id("user[email]"),"megha");
        //find the element of password and send the password key
        sendTextToElement(By.name("user[password]"),"megha1234");
        //click on loging button using elements
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        //this os form requirement
        String expectedErrorMessage = "Invalid email or password.";
        //find the welcome text element and get the text
        String actualErrorMessage = getTextFromElement(By.cssSelector(".form-error__list-item"));
        //Verify the text error message with assert
        verifyTextMessage(expectedErrorMessage,actualErrorMessage);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }


}
