package pyah.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage {
    WebDriver driver;

    //For Text Box
//    @FindBy(how = How.XPATH, using = "//div[@class='card mt-4 top-card'][1]")
//    private WebElement tileElements;
//    @FindBy(how = How.ID, using = "item-0")
//    private WebElement textBox;
//    @FindBy(how = How.ID, using = "userName")
//    private WebElement fullName;
//    @FindBy(how = How.ID, using = "userEmail")
//    private WebElement email;
//    @FindBy(how = How.ID, using = "currentAddress")
//    private WebElement currentAddress;
//    @FindBy(how = How.ID, using = "permanentAddress")
//    private WebElement permanentAddress;
//    @FindBy(how = How.ID, using = "submit")
//    private WebElement submitButton;

    //For Check Box
    @FindBy(how = How.XPATH, using = "//div[@class='card mt-4 top-card'][1]")
    private WebElement tileElements;
    @FindBy(how = How.ID, using = "item-1")
    private WebElement checkBox;
    @FindBy(how = How.CLASS_NAME, using = "rct-option-expand-all")
    private WebElement expandAll;
    @FindBy(how = How.XPATH, using = "//span[text()='Documents']")
    private WebElement chDocuments;
    @FindBy(how = How.XPATH, using = "//span[text()='General']")
    private WebElement chGeneral;
    @FindBy(how = How.XPATH, using = "//span[text()='Excel File.doc']")
    private WebElement chExcelFile;

    private static String filledName;
    private static String filledEmail;
    private static String filledCurAddress;
    private static String filledPerAddress;
    private static boolean markedItems = false;


    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ElementsPage clickAndFill(String fullNameValue, String emailValue, String currentAddressValue, String permanentAddressValue) throws InterruptedException {

        //For Text Box form
        By textBox = By.id("item-0");
        By fullName = By.id("userName");
        By email = By.id("userEmail");
        By currentAddress = By.id("currentAddress");
        By permanentAddress = By.id("permanentAddress");
        By submitButton = By.id("submit");

        driver.findElement(textBox).click();
        driver.findElement(fullName).sendKeys(fullNameValue);
        driver.findElement(email).sendKeys(emailValue);
        driver.findElement(currentAddress).sendKeys(currentAddressValue);
        driver.findElement(permanentAddress).sendKeys(permanentAddressValue);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        //assertEquals
        By outputNameBy = By.xpath("//p[@id='name']");
        By outputEmailBy = By.xpath("//p[@id='email']");
        By outputCurAddressBy = By.xpath("//p[@id='currentAddress']");
        By outputPerAddressBy = By.xpath("//p[@id='permanentAddress']");

        filledName = driver.findElement(outputNameBy).getText();
        filledName = filledName.substring(5);
        filledEmail = driver.findElement(outputEmailBy).getText();
        filledEmail = filledEmail.substring(6);
        filledCurAddress = driver.findElement(outputCurAddressBy).getText();
        filledCurAddress = filledCurAddress.substring(17);
        filledPerAddress = driver.findElement(outputPerAddressBy).getText();
        filledPerAddress = filledPerAddress.substring(20);
        return this;
    }

    public ElementsPage workWithCheckboxes() throws InterruptedException {
        tileElements.click();
        checkBox.click();
        expandAll.click();
        chDocuments.click();

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        chExcelFile.click();
        chGeneral.click();
        Thread.sleep(2000);
        List<WebElement> selectedItems = driver.findElements(By.xpath("//div[@id='result']//span[@class='text-success']"));

        if (selectedItems.size() == 8) {
            markedItems = true;
        }
        return this;
    }

    public static String getFilledName() {
        return filledName;
    }

    public static String getFilledEmail() {
        return filledEmail;
    }

    public static String getFilledCurAddress() {
        return filledCurAddress;
    }

    public static String getFilledPerAddress() {
        return filledPerAddress;
    }

    public static boolean isMarkedItems() {
        return markedItems;
    }
}

