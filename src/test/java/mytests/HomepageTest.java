package mytests;

import ConfigReader.ConfigPropertyReader;
import Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.Properties;

public class HomepageTest {

    DriverFactory df;
    ConfigPropertyReader cp;
    Properties prop;
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() throws IOException {
        cp = new ConfigPropertyReader();
        prop = cp.initLangProp();
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        homePage = new HomePage(driver);
    }

    @Test
    public void headerTest() {
        Assert.assertTrue(homePage.isHeaderExist(prop.getProperty("header")));
    }

    @Test
    public void contactFooterTest() {
        Assert.assertTrue(homePage.isContactExist(prop.getProperty("contact")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
