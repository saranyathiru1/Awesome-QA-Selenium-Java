package testBase;

import com.github.javafaker.Faker;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;


public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String emailId = firstName + lastName + "@gmail.com";
    public String address1 = faker.address().streetAddress();
    public String country = faker.address().country();
    public String state = faker.address().state();
    public String city = faker.address().city();
    public String postalCode = faker.address().zipCode();


    public String password = faker.internet().password(6, 10, true, true, true);
    ;
    public String phoneNumber = faker.phoneNumber().cellPhone();
    public Properties properties;

    @BeforeTest(groups = {"Sanity", "Regression", "Smoke"})
    @Parameters({"operatingSystem", "browser"})
    public void setUp(String operatingSystem, String browser) throws IOException, ParseException {

        if (loadConfigFile().getProperty("executionEnv").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (operatingSystem.toLowerCase(Locale.ROOT)) {
                case ("windows"):
                    capabilities.setPlatform(Platform.WIN10);
                    break;
                case ("mac"):
                    capabilities.setPlatform(Platform.MAC);
                    break;
                case ("linux"):
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                default:
                    System.out.println("No matching os");
                    return;

            }

            //browser
            switch (browser.toLowerCase(Locale.ROOT)) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    capabilities.merge(chromeOptions);
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    capabilities.merge(edgeOptions);
                    break;
                case "firefox":
                    capabilities.setBrowserName("Firefox");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    capabilities.merge(firefoxOptions);
                    break;
                default:
                    System.out.println("No matching browser");
                    return;
            }

            driver.set(new RemoteWebDriver(new URL(loadConfigFile().getProperty("gridUrl")), capabilities));

        }


        if (loadConfigFile().getProperty("executionEnv").equalsIgnoreCase("local")) {
            switch (browser.toLowerCase(Locale.ROOT)) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("No matching browser..");
                    return;
            }
        }


        driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().get(loadConfigFile().getProperty("baseUrl"));
        driver.get().manage().window().maximize();

    }

    @AfterTest(groups = {"Sanity", "Regression", "Smoke"})
    public void tearDown() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public Properties loadConfigFile() throws IOException {
        File file = new File("./src/test/resources/config.properties");
        FileReader fileReader = new FileReader(file);
        properties = new Properties();
        properties.load(fileReader);
        return properties;
    }

    public void writeJsonData() throws IOException {
        File file = new File("./testData/users.json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("emailId", emailId);
        jsonObject.put("password", password);
        jsonObject.put("phoneNumber", phoneNumber);
        jsonObject.put("address1", address1);
        jsonObject.put("country", country);
        jsonObject.put("state", state);
        jsonObject.put("city", city);
        jsonObject.put("postalCode", postalCode);
        Files.write(Paths.get(file.toString()), jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8));

    }

    public JSONObject readJsonData() throws IOException, ParseException {
        File file = new File("./testData/users.json");
        JSONParser jsonParser = new JSONParser();

        Object object = jsonParser.parse(new FileReader(file));
        JSONObject jsonObject = (JSONObject) object;
        return jsonObject;
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}
