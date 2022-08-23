package UITesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest {

    // create inheritance
    Login login;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

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

}
