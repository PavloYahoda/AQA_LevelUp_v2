package pyah.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormsPage {

    WebDriver driver;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }


    public FormsPage callForm(){
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
        return this;
    }
    public FormsPage fillForm() throws InterruptedException {

        By firstName = By.cssSelector("#firstName");
        By lastName = By.cssSelector("#lastName");
        By email = By.cssSelector("#userEmail");
        By gender = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
        By mobilePhone = By.cssSelector("#userNumber");
        By dobField = By.cssSelector("#dateOfBirthInput");
        By dobDay = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]");
//        By subjects = By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']");
        By sportsHobby = By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline'][1]");
        By musicHobby = By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline'][3]");
        By address = By.cssSelector("#currentAddress");
        By selectFile = By.cssSelector("#uploadPicture");
//        By submitButton = By.xpath("//button[@id='submit']");

        driver.findElement(firstName).sendKeys("Jack");
        driver.findElement(lastName).sendKeys("Black");
        driver.findElement(email).sendKeys("jack.black@gm.com");
        driver.findElement(gender).click();
        driver.findElement(mobilePhone).sendKeys("+987654321");
        driver.findElement(dobField).click();
        Select objSelectYear = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        objSelectYear.selectByValue("1990");
        Select objSelectMonth = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        objSelectMonth.selectByValue("4");
        driver.findElement(dobDay).click();

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
//        driver.findElement(subjects).sendKeys("www");
        driver.findElement(sportsHobby).click();
        driver.findElement(musicHobby).click();
        driver.findElement(address).sendKeys("New York City, 56 Street");
        driver.findElement(selectFile).sendKeys("/Users/pyah/Documents/JAVA/AQA_LevelUp_v2/src/sources/1.jpg");
        Thread.sleep(5000);
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("document.body.style.zoom='67%'");
        Thread.sleep(5000);
//        driver.findElement(submitButton).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement submit = (WebElement) js.executeScript("return jQuery.find('#submit');");
        submit.click();
//        Thread.sleep(5000);
        return this;
    }

}
