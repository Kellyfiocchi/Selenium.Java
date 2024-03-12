
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	@Test
	public void testeTextField() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.close();
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
      Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
      driver.close();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        driver.close();
			
	}
	@Test
	public void deveInteragirComCheckbox() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.close();
	}
	
	@Test
	public void deveInteragirComCombo() {
        System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        //combo.selectByIndex(3);
        //combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        
       driver.close();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
        System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
           List<WebElement> options = combo.getOptions();
           Assert.assertEquals(8, options.size());
           boolean encontrou = false;
			for (WebElement option : options) {
				if (option.getText().equals("Mestrado")) {
					encontrou = true;
					break;
				}
			}
			Assert.assertTrue(encontrou);
        

	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
        System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");
        
        
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());
        
        combo.deselectByVisibleText("Corrida");
        
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());
        
        driver.close();
        }
	
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("buttonSimple")).click();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.close();
		}
	
	@Test
	//@Ignore
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		//Assert.fail();
		 driver.close();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://wcaquino.me/selenium/componentes.html");
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
        //driver.close();
	   }
		
	}