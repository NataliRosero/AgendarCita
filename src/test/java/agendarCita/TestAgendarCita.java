package agendarCita;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAgendarCita {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Natali/workspace/LoginAutomation/GeckoDriver/geckodriver.exe");
		
		WebDriver driver  = new FirefoxDriver();
		driver.navigate().to("http://google.com");
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		driver.quit();


	}

}
