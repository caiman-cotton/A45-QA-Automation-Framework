import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver;
    public static String link;
    WebDriverWait wait;
    Actions actions;
    ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        link = BaseURL;
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        getDriver().get(link);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
        actions = new Actions(getDriver());
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public static WebDriver pickBrowser(String browser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.14:4444";
        switch (browser) {
            case "MicrosoftEdge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            }
            case "grid-edge" -> {
                caps.setCapability("browserName", "MicrosoftEdge");
                try {
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            }
            case "grid-firefox" -> {
                caps.setCapability("browserName", "firefox");
                try {
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                try {
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "cloud" -> {
                return lambdaTest();
            }
         
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
            }
        }
    }
    public static WebDriver lambdaTest() {
        String username = "caiman.cotton";
        String accessToken = "yvq5sloHr2M8GO9rojpOdzEj4Wjt2rgJYSrWqzeqtpM60pkVTE";
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessToken);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            return new RemoteWebDriver(new URL(hubURL), browserOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void endTest() {
        getDriver().quit();
        threadDriver.remove();
    }
    
}