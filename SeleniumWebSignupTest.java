import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    // import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException{
        //locate the WebDriver
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        //1. open edge browser
        driver = new EdgeDriver();
        //2. input the selenium demo page url (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException{
        //5. enter less than 3 characters username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("wa");
        //6. enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("wande20@mailnator.com");
        //7. enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //8. click on signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException{
        //9. clear the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).clear();
        //10. clear the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).clear();
        //11. clear the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).clear();
        //12. enter username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("wande36");
        //13. enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("wande36@mailnator.com");
        //14. enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        Thread.sleep(5000);

    }
    @Test (priority = 2)
    public void logout() throws InterruptedException{
       //15. click on logout
        driver.close();

    }

    @AfterTest
    public void closebrowser(){
        // Quit the browser
        driver.quit();
    }

}
