package testutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String countryShort)
    {
        String countryFullForm="";

        switch (countryShort)
        {
            case "IN" : countryFullForm="India" ; break;
            case "CN" : countryFullForm="China" ; break;
            case "AO" : countryFullForm="Angola" ; break;
            case "AU" : countryFullForm="Australia" ; break;
            case "BH" : countryFullForm="Bahrain" ; break;
            case "BR" : countryFullForm="Brazil" ; break;
        }


        return countryFullForm;
    }


    public static String getGender(String genderId)
    {
        String gender="";

        switch (genderId)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }

        return  gender;
    }


    /*
    Expected :11/02/1989  --> MM/dd/yyyy
     Actual   :1989-11-02 --> yyyy-MM-dd
     */

    public static String convertDate(String dbDate) throws ParseException // yyyy-MM-dd
    {
       Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

       return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }


    public static String convertToNumberText(String number)
    {
         String value = "";
        try {
            value = "" + (int) Double.parseDouble(number);
       }
        catch (Exception e)
        {
            value = number;
        }

        return value;
    }
}
