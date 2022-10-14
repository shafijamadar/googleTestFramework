import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyKeys;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    Properties properties;
    InputStream is;
    String propertiesFilename = "selenium.properties";


    @BeforeClass
    public void beforeClass() throws IOException {
        is = getClass().getClassLoader().getResourceAsStream(propertiesFilename);
        properties = new Properties();
        properties.load(is);
    }

    @BeforeMethod
    public void beforeMethod() {
        getWebdriver(properties.getProperty(PropertyKeys.BROWSER_TYPE));
        driver.get(properties.getProperty(PropertyKeys.URL));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty(PropertyKeys.IMPLICIT_WAIT))));
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        driver.quit();
    }



    public WebDriver getWebdriver(){
        EdgeOptions chrome_options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(chrome_options);
        return driver;
    }

    private WebDriver getWebdriver(String browserType) {
        if(browserType==null || browserType.equalsIgnoreCase("edge")){
           return getWebdriver();
        }
        else if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }

}
