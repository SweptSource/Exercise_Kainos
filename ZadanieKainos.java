package Zadanie_Kainos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;



public class ZadanieKainos {

private WebDriver driver; //tworzy zmienna driver typu (klasy)WebDriver 
	
	@BeforeClass
    private void setUp() {
        driver = new FirefoxDriver();      
    }
	
	
	
	@BeforeMethod
    public void openHomePage(){
		driver.manage().window().maximize();
        driver.get("http://allegro.pl/");
    }

	
	@Test
    public void ifAllegroMostExpensiveSmartWatchisLowerThen1000(){
	//	for (int i= 0; i<5; i++){
	//		driver.get("http://allegro.pl/");
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		//pozostalo calosc uporzadkowac - przeniesc wszystko do czesci deklarowanych zmiennych
		driver.findElement(By.xpath(".//*[@id='main-search-text']"))
        .sendKeys("smartwatch");
		
		driver.findElement(By.xpath(".//*[@id='main-search']/input")).click();
		
		driver.findElement(By.xpath(".//*[@id='listing']/div[1]/div[3]/div[1]/span"))
		.click();
		//czasem moze sie nie udac przez czas ladowania strony - wypada uzyc WebDriverWait
		driver.findElement(By.xpath(".//*[@id='listing']/div[1]/div[3]/div[2]/dl/dd[2]/a/span"))
		.click();
		
				
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='item-4908940307']/div/div[3]/header/h2/a/span")));
		myDynamicElement.click();
		
		String cena = driver.findElement(By.xpath(".//*[@id='priceValue']")).getText();
		
		//j = cena.length;
		for (int i =0; i < cena.length(); i ++)
		System.out.println(cena.charAt(i));
		System.out.print(" ");
		//potrzebujemy zapisac ta wartosc bez z³ i najlepiej bez sapcji
		// nastepnie skonertowac do liczby
		int wyj = cena.length()-3;
		System.out.println(cena.length());
		System.out.println("wyj = " + wyj);
		
		// format allegro jest znany - na poczatek wytnijmy 3 ostatnie znaki
		
		//char cenaDoPorownania[];
		//for (int i =0; i < wyj; i ++)
		//cenaDoPorownania[i] = cena.chartAt(i);
		//System.out.println(cenaDoPorownania[i]);
		
		
	//	for (int i =0; i < (cena.length()-3); i ++){
	//		cenaDoPorownania[i] = cena.chartAt(i);
			
		//}
		
		
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
			
	}
	
	@AfterClass
	private void tearDown() {
	    driver.quit();
	}
}
