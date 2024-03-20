import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
	
	
	
	  WebDriver driver;	
	  DSL dsl;
		
		@Before
		public void inicializa() {
			System.setProperty("webdriver.chrome.driver",
					"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://wcaquino.me/selenium/componentes.html");
			dsl = new DSL(driver);
		}
		
		@After
		public void finaliza() {
			driver.close();
		}
	
 @Test
 	public void deveInteragirComAlertSimples() {
	dsl.clicarBotao("alert");
	String texto = dsl.alertaObterTextoEAceita();
	Assert.assertEquals("Alert Simples", texto);
	
	dsl.escreve("elementosForm:nome", texto);
		
 }
 
 @Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
		
				
	}
 
   @Test
       public void deveInteragirComAlertPrompt() {
	      dsl.clicarBotao("prompt");
	        Assert.assertEquals("Digite um numero", dsl.alertaObterTexo());
	      dsl.alertaEscrever("12");
	      Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
	      Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	   	
   }
 
}	
