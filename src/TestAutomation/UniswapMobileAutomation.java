package TestAutomation;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UniswapMobileAutomation {

    //@SuppressWarnings("deprecation")
	public static void main(String[] args) {
     // Set the path to your ChromeDriver executable file
   //   System.setProperty("webdriver.chrome.driver", "C://Users//Harpreet//Desktop//Chrome//chromedriver.exe");
      
       // Create a new instance of the ChromeDriver
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       System.out.println("Browser Session opens");

        try {
            // Open Uniswap swap page in mobile view
            driver.get("https://app.uniswap.org/swap");
            System.out.println("Swap website opens");
            
            // Navigate to the NFT Marketplace page
            driver.get("https://app.uniswap.org/nfts");
            driver.manage().window().maximize();
            System.out.println("NFT website opens");
            
           // Resize the browser window to simulate mobile view in Landscape mode
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 400));
            Thread.sleep(500);
            
            // Create an instance of JavascriptExecutor for scrolling the mobile view
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("scrollBy(0, 500)", args);
           
            WebElement mobileNavBar = driver.findElement(By.xpath("//div[@class='App__MobileBottomBar-sc-bb49e1a9-1 jVtEOp']"));
            if (mobileNavBar.isDisplayed()) {
                System.out.println("Mobile nav bar component is visible in Portrait mode");
            } else {
                System.out.println("Mobile nav bar component is not visible in landscape mode");
            }

            Thread.sleep(5000);
            
            // Select the 1W view of the Trending NFT collections
            WebElement timeFrameDropdown = driver.findElement(By.xpath("//*[@class='text__TextWrapper-sc-ff9b9e4c-0 Hhsep TrendingCollections__StyledSelectorText-sc-c0c70b1b-5 gtECIt css-p9plib']"));
            timeFrameDropdown.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement oneWeekOption = driver.findElement(By.xpath("//div[text()='1W']"));
            oneWeekOption.click();
            
            Thread.sleep(5000);

          /*// Sort the NFTs in the Trending NFT collections based on highest volume(This code works in Desktop mode)]
            WebElement sortByDropdown = driver.findElement(By.xpath("//span[@class='_1klryar0 rgw6ez2e9']"));
            Thread.sleep(5000);
            sortByDropdown.click(); */
            
             // Create an instance of JavascriptExecutor
        
             js.executeScript("scrollBy(0, 100)", args);
            //WebElement highestVolumeOption = driver.findElement(By.xpath("//div[text()='Highest Volume']"));
            //highestVolumeOption.click();

            // Wait for the sorting to take effect (you may need to handle loading indicators)
            Thread.sleep(10000);

            System.out.println("NFTs in the Trending NFT collections sorted by highest volume."); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
