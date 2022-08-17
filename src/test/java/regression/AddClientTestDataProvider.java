package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utility.MyData.getMyData;

public class AddClientTestDataProvider {
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

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String birthdate,String phone,
                              String fax,String mobile,String email,
                              String web,String tax,String vat)
    {
        Menu menu  = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAddress1(address1);
        addClient.setClientAddress2(address2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthdate);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(vat);
        addClient.setClientTax(tax);
        addClient.clickBtnSave();

    }

    @DataProvider
    public Object[][]  getData() throws IOException {
        return getMyData("Data/MyData.xlsx","Add Client");
    }
}
