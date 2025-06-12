package WindowHandles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class OpenMultipleTabs {
    public static void main(String args[]){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Use JavaScript to open new tabs
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // URLs to open in different tabs
        String[] urls = {
                "https://www.bing.com",
                "https://www.yahoo.com",
                "https://www.wikipedia.org"
        };

        for (String url : urls) {
            js.executeScript("window.open('" + url + "', '_blank');");
        }

        // Wait to ensure tabs are loaded
       // Thread.sleep(3000);

        // Get all window handles (tabs)
        Set<String> handles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(handles);

        // Switch to each tab and print the title
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            System.out.println("Tab Title: " + driver.getTitle());
        }

        // Close the browser
        driver.quit();

        //driver.quit();

    }
}
