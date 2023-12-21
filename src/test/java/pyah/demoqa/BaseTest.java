package pyah.demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public static final String URL = "https://demoqa.com/";
    public static WebDriver driver;

    @BeforeAll
    public void setup(){
        WebDriverManager.edgedriver().setup();
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new EdgeDriver();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @BeforeEach
    public void start(){
        driver.get(URL);
    }

    @AfterAll
    public void shutDown(){
        driver.close();
        driver.quit();
    }

    public ElementsPage getElementsPage() {
        return new ElementsPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public FormsPage getFormsPage(){
        return new FormsPage(driver);
    }
}
