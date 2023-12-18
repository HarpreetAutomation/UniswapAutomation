package TestAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UniswapWalletAutomation {
	
public static void main(String[] args) {
	 // Set the path to your ChromeDriver executable 
    System.setProperty("webdriver.chrome.driver", "C://Users//Harpreet//Desktop//Chrome//chromedriver.exe");
    	
    // Configure ChromeOptions with the user data directory to run the code in the existing open chrome browser
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("debuggerAddress", "localhost:9298");
    WebDriver driver = new ChromeDriver(options);
    System.out.println("Chrome opens");  
 
    // This code can be added if we want to add Metamast extension in New session of chrome
    // options.addExtensions(new File("C:\\Users\\Harpreet\\eclipse-workspace\\HarpreetTestProject\\src\\TestAutomation\\Extensions\\Metamask.crx"));
       
    
    try 
        {
           // Open Uniswap swap page on the Polygon Mumbai testnet
            driver.get("https://app.uniswap.org/swap");
            Thread.sleep(5000);
            System.out.println("Uniswap Website opens");
        
             WebElement connectPolygonMumbaiLov =driver.findElement(By.xpath("(//*[@data-testid='chain-selector'])[2]"));
             //Performing the mouse hover action on the target element.
             connectPolygonMumbaiLov.click();
             Thread.sleep(5000); 
            
              // Switch to the Polygon Mumbai testnet 
           /*  WebElement connectPolygonMumbai =driver.findElement(By.xpath("//div[text()='Polygon']"));
             connectPolygonMumbai.click();
             Thread.sleep(5000); */
            
            // Connect MetaMask
            WebElement connectWalletButton = driver.findElement(By.xpath("//*[@data-testid='navbar-connect-wallet']"));
            connectWalletButton.click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[text()='MetaMask']")).click();
            Thread.sleep(10000);
            
            //This below code can be used if required to connect to Mumbai TestNet inside extension
           //WebElement extensionElement = driver.findElement(By.id("//*[@class='mm-box mm-text mm-text--body-md mm-text--ellipsis mm-box--color-text-default mm-box--background-color-transparent' and contains(text(),'Mumbai Testnet')]"));
           //extensionElement.click();
            
            //Select button click
           driver.findElement(By.xpath("//*[@class='sc-aXZVg bbWEFp Button__BaseButton-sc-983e32f-1 Button__ButtonGray-sc-983e32f-5 SwapCurrencyInputPanel__CurrencySelect-sc-d5f18f1c-3 beCsXP gFvBpt DHGiY open-currency-select-button']")).click();
            
           //USDC Click
           driver.findElement(By.xpath("//*[text()='USDC']")).click();
           
           //Enter the amount to swap
           WebElement numberInput = driver.findElement(By.xpath("(//*[@id='swap-currency-input'])[2]"));
           numberInput.click();
           numberInput.sendKeys("0.001");
           Thread.sleep(5000);
           
          //Swap and confirm the swap
          driver.findElement(By.xpath("//*[@class='css-1cmsyys' and contains(text(),'Swap')]")).click();
          driver.findElement(By.xpath("//*[@class='css-1cmsyys' and contains(text(),'Confirm swap')]")).click();
          
          // Perform actions in the new window
          WebElement ConfirmButtonMetamask = driver.findElement(By.xpath("//button[@data-testid='page-container-footer-next' and contains(text(),'Confirm')]"));
          ConfirmButtonMetamask.click();
          System.out.println("Confirm button is clicked");
       
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[text()='View on Explorer']")).click();
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[text()='Success']")).click();
           System.out.println("Transaction successful!");
     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
}  
    
}
        

