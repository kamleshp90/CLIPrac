package WebTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Arrayofproductstocart {

	@Test
	public void productsToCart() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAMLESH\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> itemNameList = driver
				.findElements(By.xpath("//div[@class='product'] //h4[@class='product-name']"));
		String[] veggiNames = { "Brocolli", "Cucumber", "Beetroot" };
		List<String> veggiNamesList = Arrays.asList(veggiNames);

		for (int i = 0; i < itemNameList.size(); i++) {

			String[] vegginame = itemNameList.get(i).getText().split("-");
			String formattedVeggiName = vegginame[0].trim();

			if (veggiNamesList.contains(formattedVeggiName)) {
				driver.findElements(By.xpath("//div[@class='product'] //button[@type='button']")).get(i).click();
			}

		}

	}

}
