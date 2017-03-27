package testNG;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;

public class TestNG {

	private WebDriver driver;	
	private String url;
	
	private WebElement parametrizarCasosPrueba(String fecha, String paciente, String doctor, String obs, String selector) throws InterruptedException {
		
		driver.get(url);
		
		CharSequence[] date = new String[]{fecha};
		WebElement inputDate = driver.findElement(By.id("datepicker"));
		inputDate.sendKeys(date);
		
		CharSequence[] idPaciente = new String[]{paciente};
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		elements.get(1).sendKeys(idPaciente);
				
	  	CharSequence[] idDoctor = new String[]{doctor};
		elements.get(2).sendKeys(idDoctor);
		 
		CharSequence[] observaciones = new String[]{obs};
		WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
		inputObservaciones.sendKeys(observaciones);
		
		Thread.sleep(5);
		
		WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
		btnGuardar.click();	
		
		/* Espera para traer nuevos elementos*/
		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
        		
		/*Comparar el resultado obtenido*/
		WebElement respuesta= driver.findElement(By.cssSelector(selector));
		
		return respuesta;
	
	}
	
	@Test				
	public void agendarCitaPacienteyDoctorExitenteDevuelveGuardado() throws InterruptedException {	
				
		/*Comparar el resultado obtenido*/
		WebElement respuesta= parametrizarCasosPrueba("03/28/2017","121212","123456","cita agendada","div.panel.panel-success");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}	
	
	@Test				
	public void agendarCitaPacienteNoExiteDevuelveError() throws InterruptedException {	
				
	//	Comparar el resultado obtenido
		WebElement respuesta= parametrizarCasosPrueba("03/28/2017","134564","123456","solicitud cita","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaDoctorNOExiteDevuelveError() throws InterruptedException {	
		//	Comparar el resultado obtenido
		WebElement respuesta= parametrizarCasosPrueba("03/28/2017","121212","898989","solicitud nueva cita","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaDoctoryPacienteNOExiteDevuelveError() throws InterruptedException {	
			
	//	Comparar el resultado obtenido
		WebElement respuesta= parametrizarCasosPrueba("03/28/2017","565656","898989","solicitud nueva cita","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaFechaMenorDevuelveError() throws InterruptedException {	
			
		/*Comparar el resultado obtenido*/
		WebElement respuesta= parametrizarCasosPrueba("03/20/2017","121212","123456","cita agendada","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}	
	
	@Test				
	public void agendarCitaFechaIgualDevuelveError() throws InterruptedException {	
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date fecha = new Date();
				        		
		/*Comparar el resultado obtenido*/
		WebElement respuesta= parametrizarCasosPrueba(dateFormat.format(fecha),"121212","123456","cita agendada","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaCamposVaciosDevuelveError() throws InterruptedException {	
				
		/*Comparar el resultado obtenido*/
		WebElement respuesta= parametrizarCasosPrueba("","","","","div.panel.panel-danger");
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@BeforeTest
	public void beforeTest() {	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/GeckoDriver/geckodriver.exe");
	    driver = new FirefoxDriver();   
	    url = "http://automatizacion.herokuapp.com/nrosero/appointmentScheduling";
	}	
	
	@AfterTest
	public void afterTest() {
		driver.close();			
	}

}
