package agendarCita;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAgendarCita {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Natali/workspace/LoginAutomation/GeckoDriver/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();	
		driver.get("http://automatizacion.herokuapp.com/nrosero/appointmentScheduling");
		 
	       /* Fecha */
			CharSequence[] date = new String[]{"03/28/2017"};
			WebElement inputDate = driver.findElement(By.id("datepicker"));
			inputDate.sendKeys(date);
			
		   /* Documento paciente */
			CharSequence[] idPaciente = new String[]{"121212"};
			List<WebElement> elements = driver.findElements(By.tagName("input"));
			elements.get(1).sendKeys(idPaciente);
								
			
		   /* DOcumento doctor */
			CharSequence[] idDoctor = new String[]{"123456"};
			elements.get(2).sendKeys(idDoctor);
			
		   /* Observaciones */
			CharSequence[] observaciones = new String[]{"cita agendada"};
			WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
			inputObservaciones.sendKeys(observaciones);
			
			Thread.sleep(5);
			
			WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
			btnGuardar.click();	


	}

}
