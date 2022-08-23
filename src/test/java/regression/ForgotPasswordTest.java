package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import testutil.OpenUrl;

public class ForgotPasswordTest extends OpenUrl {

    @Test
    public void forgotPassTest()
    {

        Login login = new Login(driver);
        login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickBtnReset();
    }

}
