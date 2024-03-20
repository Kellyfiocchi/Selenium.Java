import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	  WebDriver driver;	
		
		@Before
		public void inicializa() {
			System.setProperty("webdriver.chrome.driver",
					"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://wcaquino.me/selenium/componentes.html");
		}
		
		@After
		public void finaliza() {
			driver.close();
	}
		
	@Test
	public void teste() {
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());
	}

}
