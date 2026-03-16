package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
public class UiTest extends UiBase{



    @Test
    public void LoginTest() {

        LoginPage lp = new LoginPage(driver);


        lp.enterName(ConfigReader.getProperty("username"));
        lp.enterPass(ConfigReader.getProperty("password"));

        test=extent.createTest("LoginTest");

        test.pass("user logged in successfully");


    }
}