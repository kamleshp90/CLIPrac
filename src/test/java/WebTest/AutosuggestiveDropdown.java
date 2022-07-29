package WebTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutosuggestiveDropdown {

	@Test
	public void autoSuugestiveDD() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAMLESH\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		WebElement countrySelect = driver.findElement(By.xpath("//input[@id='autosuggest']"));

		countrySelect.sendKeys("ind");

		Thread.sleep(3000);
		List<WebElement> countryListSelects = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

		for (WebElement countryListSelect : countryListSelects) {
			if (countryListSelect.getText().equalsIgnoreCase("India")) {
				countryListSelect.click();
			}
		}

	}
	
	@Test
	public void ddTestA() {
		System.out.println("DDtestA11");
		System.out.println("DDtestA12");
		System.out.println("DDtestA13");
	}

	@Test
	public void ddTestB() {
		System.out.println("DDtestB1");
		System.out.println("DDtestB2");
		System.out.println("DDtestB3");
	}

}
