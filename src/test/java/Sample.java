import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.Login;

public class Sample {

    @Test
    public void myTest()
    {
        WebDriverManager.chromedriver().setup();


       // driver.get("http://facebook.com");
    }
}
