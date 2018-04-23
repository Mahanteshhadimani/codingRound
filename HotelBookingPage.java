package objectRepo;
import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HotelBookingPage {

    WebDriver driver;
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    public HotelBookingPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
  //Click on login button

    public void clickHotelLink(){

     	hotelLink.click();

    }

    public void setPlaceName(String strPlaceName){

     	localityTextBox.sendKeys(strPlaceName);
     	//List<WebElement> originOptions = driver.findElement(By.id("ui-id-0")).findElements(By.tagName("option"));
        //originOptions.get(0).click();
     	WebDriverWait wait = new WebDriverWait(driver, 20);
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Indiranagar, Bangalore')]")));
     	       driver.findElement(By.xpath("//*[contains(text(),'Indiranagar, Bangalore')]")).click();
      // driver.findElement(By.xpath("//input[@title='Check-in date']")).click();
       driver.findElement(By.xpath("//div[@class='monthBlock last']//tbody/tr[2]/td[6]/a")).click();
       // driver.findElement(By.xpath("//input[@title='Check-out date']")).click();
       
      // WebDriverWait wait = new WebDriverWait(driver, 20);
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='monthBlock first']//tbody/tr[3]/td[7]/a")));
    	     //  driver.findElement(By.xpath("//*[contains(text(),'Indiranagar, Bangalore')]")).click();
        driver.findElement(By.xpath("//div[@class='monthBlock first']//tbody/tr[3]/td[7]/a")).click();
        

    }
    
    
    public void selectTravellers(String traveller){

    	new Select(travellerSelection).selectByVisibleText(traveller);
        searchButton.click();

        

    }
}
