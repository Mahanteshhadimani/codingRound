package tests;
import com.sun.javafx.PlatformUtil;

import objectRepo.HotelBookingPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver; 
    HotelBookingPage hotel;
   
    @BeforeTest

    public void setup(){
      	setDriverPath();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.cleartrip.com/");

    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        
    	   hotel = new HotelBookingPage(driver);
       // driver.get("https://www.cleartrip.com/");
        hotel.clickHotelLink();
        hotel.setPlaceName("Indiranagar, Bangalore");
        waitFor(3000);
        
       
       hotel.selectTravellers("2 rooms, 4 adults");
      // hotel.clickSearchHotelButton();
       waitFor(3000);
       driver.quit();
        

    }
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
