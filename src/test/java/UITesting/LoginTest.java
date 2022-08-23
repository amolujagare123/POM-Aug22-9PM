package UITesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import testutil.OpenUrl;

public class LoginTest extends OpenUrl {

    // create inheritance
    Login login;

    @BeforeClass
    public void initLogin() {

        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibility()
    {
        boolean expected = true;
        boolean actual=false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {
         //   actual = false;
        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,"username text box is not displayed");
    }

    @Test
    public void txtUsernameEnability()
    {
        boolean expected = true;
        boolean actual=false;
        try {
            actual = login.txtUsername.isEnabled();
        }
        catch (Exception e)
        {
            //   actual = false;
        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,"username text box is not enabled");
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected ="Email";
        String actual ="";

        try{
         actual = login.lblEmail.getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect spelling");
    }

    @Test
    public void txtPasswordPlaceHolderCheck()
    {
        String expected = "Password";
        String actual ="";

        try{
             actual = login.txtPassword.getAttribute("placeholder");
        }
            catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect placeholder value");
    }


    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";

        String actual = "";
        try{
              actual = login.lblPassword.getCssValue("font-size");
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect font size");

    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";

        String actual = "";
        try{
            String rgbColor = login.btnLogin.getCssValue("background-color");
            System.out.println(rgbColor);
            actual =  Color.fromString(rgbColor).asHex().toUpperCase();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect color");

    }

}
