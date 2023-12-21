package pyah.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    private By elements = By.cssSelector("div[class='card mt-4 top-card']");
    private By forms = By.xpath("//div[@class='card mt-4 top-card'][2]");
//    @FindBy(css = "div[class='card mt-4 top-card']")
//    WebElement elementsTab;

    public ElementsPage clickOnElements() {
        driver.findElement(elements).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new ElementsPage(driver);
    }
//
//    public void clickOnElementsFindBy() {
//        elementsTab.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }

    public FormsPage clickOnForms() {
        driver.findElement(forms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new FormsPage(driver);
    }
}
