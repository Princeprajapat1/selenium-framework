package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import utils.ConfigReader;

public class UiBase {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter reporter;// shared across all tests
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {



        extent = new ExtentReports(); // initialize ExtentReports
        reporter= new ExtentSparkReporter("UiTestReport.html");

                extent.attachReporter(reporter);


    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush(); // write the report after all tests
        }
        }
    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));



    }
}