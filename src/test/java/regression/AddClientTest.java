package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);

        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickBtnLogin();
    }

    @Test
    public void addClientTest()
    {
        Menu menu  = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);





        addClient.setClientName("Purushottam123");
        addClient.setClientSurname("Kumar");
        addClient.setLanguage("Korean");
        addClient.setClientAddress1("xyz");
        addClient.setClientAddress2("abc");
        addClient.setClientCity("pune");
        addClient.setClientState("MH");
        addClient.setClientZip("4434343");
        addClient.setCountry("Libya");
        addClient.setGender("Male");
        addClient.setBirthDate("10/20/1990");
        addClient.setClientPhone("434343");
        addClient.setClientFax("434343");
        addClient.setClientMobile("4343434");
        addClient.setClientEmail("p@gmail.com");
        addClient.setClientWeb("www.purushottam.com");
        addClient.setClientVat("34343434");
        addClient.setClientTax("767676");
        addClient.clickBtnSave();

    }
}
