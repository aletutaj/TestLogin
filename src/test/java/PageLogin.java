import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PageLogin {

    private WebDriver wd;
    private String url;
    private String email;
    private String userPass;

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        url = "https://boeing.wd1.myworkdayjobs.com/en-US/EXTERNAL_CAREERS/login";
        email = "user@email.com";
        userPass = "";
    }

    @Test
    public void loginNegative () {
        wd.get(url);
        WebElement loginName = wd.findElement(By.className("gwt-TextBox WG-M"));
        loginName.clear();
        loginName.sendKeys(email);

        WebElement loginPass = wd.findElement(By.className(("gwt-PasswordTextBox WG-M")));
        loginPass.clear();
        loginPass.sendKeys(userPass);

        wd.findElement(By.xpath("//input[@id='click_filter']")).click();

        Assert.assertTrue(wd.getPageSource().contains("ERROR: Please enter a valid email"));
    }
    @AfterMethod
    public void tearDown () {
        wd.quit();
    }
}
