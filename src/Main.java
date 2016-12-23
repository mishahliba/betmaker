import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by beerman on 18.12.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.parimatch.com/");
        driver.manage().window().maximize();
        //we are about to identify an element with attribute ng-model
        driver.findElement(By.className("login_menu"));
        driver.findElement(By.xpath("//*[@id=\"auth\"]/noindex/a")).click();
        driver.get("https://www.parimatch.com/?login=1");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"z_content\"]/div/div/form/table/tbody/tr[1]/td[1]")).getText());
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("1996324");
        driver.findElement(By.name("passwd")).click();
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("Jdhy32g7");
        System.out.println(driver.findElement(By.name("passwd")).getText());
        driver.findElement(By.xpath("//*[@id=\"z_content\"]/div/div/form/table/tbody/tr[3]/td[3]/button[1]")).click();

        //TODO This shit is not working now
        //driver.findElement(By.name("username")).click();

        driver.findElement(By.linkText("Теннис")).click();
        driver.findElement(By.className("groups"));
        driver.findElement(By.linkText("Мужчины. Australian Open 2017. Итоги турнира")).click();
        driver.get("https://www.parimatch.com/sport/tennis/muzhchiny-australian-open-2017-itogi-turnira");
    }
}
