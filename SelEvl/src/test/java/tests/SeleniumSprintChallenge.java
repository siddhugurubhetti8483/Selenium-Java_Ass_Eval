package tests;

import java.security.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSprintChallenge {
    WebDriver driver;
    // WebDriverWait wait;
    final String baseURL = "https://demoqa.com/";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
    }

    @Test(priority = 1)
    public void form_Element(){
        
        //!------- Task 1 -------

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.id("userName")).sendKeys("John Snow");
        driver.findElement(By.id("userEmail")).sendKeys("johnsnow@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("101 Indira Society Delhi");
        driver.findElement(By.id("permanentAddress")).sendKeys("509 Gandhi Society Pune");
        driver.findElement(By.id("submit")).click();

        String output = driver.findElement(By.id("name")).getText();

        Assert.assertTrue(output.contains("John Snow"),
            "Name not submitted");

        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

        WebElement impressive = driver.findElement(By.xpath("//label[text()='Impressive']"));
        impressive.click();

        String ImpText = driver.findElement(By.className("text-success")).getText();
        Assert.assertTrue(ImpText.equalsIgnoreCase("Impressive"),
            "Radio not select");

    }

    public void Dynamic_Widgets(){
        //!------- Task 2 -------

        driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
        driver.findElement((By.xpath("//span[text()='Select Menu']"))).click();

        // WebElement val = driver.findElement(By.xpath("//div[text()='Select Option']"));

        // Select selVal = new Select(val);
        // selVal.selectByVisibleText("Purple");

        WebElement std = driver.findElement(By.id("oldSelectMenu"));

        Select sel = new Select(std);
        sel.selectByVisibleText("Purple");

        WebElement react =  driver.findElement(By.cssSelector("div[id='react-select-3']input"));

        react.sendKeys("Group 1, option 1");
        react.sendKeys(Keys.ENTER);
        


    }



    // public void tearDown(ITest result){
    //     if(ITest.F)
    // }
}
