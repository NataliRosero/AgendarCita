package testNG;

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
	@Test				
	public void agendarCitaPacienteyDoctorExitenteDevuelveGuardado() throws InterruptedException {	
		driver.get(url);
		
		CharSequence[] date = new String[]{"03/28/2017"};
		WebElement inputDate = driver.findElement(By.id("datepicker"));
		inputDate.sendKeys(date);
		
		CharSequence[] idPaciente = new String[]{"121212"};
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		elements.get(1).sendKeys(idPaciente);
				
	  	CharSequence[] idDoctor = new String[]{"123456"};
		elements.get(2).sendKeys(idDoctor);
		 
		CharSequence[] observaciones = new String[]{"cita agendada"};
		WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
		inputObservaciones.sendKeys(observaciones);
		
		Thread.sleep(5);
		
		WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
		btnGuardar.click();	
		
		/* Espera para traer nuevos elementos*/
		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel.panel-success")));
        		
		/*Comparar el resultado obtenido*/
		WebElement respuesta= driver.findElement(By.cssSelector("div.panel.panel-success"));
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}	
	
	@Test				
	public void agendarCitaPacienteNoExiteDevuelveError() throws InterruptedException {	
		driver.get(url);
		
		CharSequence[] date = new String[]{"03/28/2017"};
		WebElement inputDate = driver.findElement(By.id("datepicker"));
		inputDate.sendKeys(date);
		
		CharSequence[] idPaciente = new String[]{"134564"};
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		elements.get(1).sendKeys(idPaciente);
				
	  	CharSequence[] idDoctor = new String[]{"123456"};
		elements.get(2).sendKeys(idDoctor);
		 
		CharSequence[] observaciones = new String[]{"solicitud cita"};
		WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
		inputObservaciones.sendKeys(observaciones);
		
		Thread.sleep(5);
		
		WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
		btnGuardar.click();	
		
		///Espera para traer nuevos elementos
		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel.panel-danger")));
        		
	//	Comparar el resultado obtenido
		WebElement respuesta= driver.findElement(By.cssSelector("div.panel.panel-danger"));
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaDoctorNOExiteDevuelveError() throws InterruptedException {	
		driver.get(url);
		
		CharSequence[] date = new String[]{"03/28/2017"};
		WebElement inputDate = driver.findElement(By.id("datepicker"));
		inputDate.sendKeys(date);
		
		CharSequence[] idPaciente = new String[]{"121212"};
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		elements.get(1).sendKeys(idPaciente);
				
	  	CharSequence[] idDoctor = new String[]{"898989"};
		elements.get(2).sendKeys(idDoctor);
		 
		CharSequence[] observaciones = new String[]{"solicitud nueva cita"};
		WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
		inputObservaciones.sendKeys(observaciones);
		
		Thread.sleep(5);
		
		WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
		btnGuardar.click();	
		
		///Espera para traer nuevos elementos
		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel.panel-danger")));
        		
	//	Comparar el resultado obtenido
		WebElement respuesta= driver.findElement(By.cssSelector("div.panel.panel-danger"));
		Assert.assertTrue(respuesta.isDisplayed()); 		
	}
	
	@Test				
	public void agendarCitaDoctoryPacienteNOExiteDevuelveError() throws InterruptedException {	
		driver.get(url);
		
		CharSequence[] date = new String[]{"03/28/2017"};
		WebElement inputDate = driver.findElement(By.id("datepicker"));
		inputDate.sendKeys(date);
		
		CharSequence[] idPaciente = new String[]{"565656"};
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		elements.get(1).sendKeys(idPaciente);
				
	  	CharSequence[] idDoctor = new String[]{"898989"};
		elements.get(2).sendKeys(idDoctor);
		 
		CharSequence[] observaciones = new String[]{"solicitud nueva cita"};
		WebElement inputObservaciones = driver.findElement(By.tagName("textarea"));
		inputObservaciones.sendKeys(observaciones);
		
		Thread.sleep(5);
		
		WebElement btnGuardar = driver.findElement(By.className("btn-primary"));
		btnGuardar.click();	
		
		///Espera para traer nuevos elementos
		WebElement myDynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel.panel-danger")));
        		
	//	Comparar el resultado obtenido
		WebElement respuesta= driver.findElement(By.cssSelector("div.panel.panel-danger"));
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
		driver.quit();			
	}

}
