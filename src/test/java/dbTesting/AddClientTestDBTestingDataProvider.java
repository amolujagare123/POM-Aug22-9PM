package dbTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import testutil.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static testutil.Conversion.*;
import static utility.MyData.getMyData;

public class AddClientTestDBTestingDataProvider extends DoLogin  {


    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String birthdate,String phone,
                              String fax,String mobile,String email,
                              String web,String tax,String vat) throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<String> expected = new ArrayList<>();

      /*  String val = "565656.0";
        String str = ""+(int) Double.parseDouble(val); // 565656*/

        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(convertToNumberText(zip));
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(convertToNumberText(phone));
        expected.add(convertToNumberText(fax));
        expected.add(convertToNumberText(mobile));
        expected.add(email);
        expected.add(web);
        expected.add(convertToNumberText(tax));
        expected.add(convertToNumberText(vat));

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
        addClient.setClientZip(convertToNumberText(zip));
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthdate);
        addClient.setClientPhone(convertToNumberText(phone));
        addClient.setClientFax(convertToNumberText(fax));
        addClient.setClientMobile(convertToNumberText(mobile));
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(convertToNumberText(vat));
        addClient.setClientTax(convertToNumberText(tax));
      //  addClient.clickBtnSave();

        ArrayList<String> actual = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ip",
                "root","root");

        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+name+"'";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullFormCountry = convertCountry(shortCountry);
            actual.add(fullFormCountry);


            actual.add(getGender(rs.getString("client_gender")));

            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_tax_code"));
            actual.add(rs.getString("client_vat_id"));
        }


        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"list does not match");

    }

    @DataProvider
    public Object[][]  getData() throws IOException {
        return getMyData("Data/MyData.xlsx","DBTesting");
    }
}
