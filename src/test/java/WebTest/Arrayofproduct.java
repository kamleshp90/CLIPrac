package WebTest;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Arrayofproduct {

	@Test
	public static void arrayOfProduct() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAMLESH\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(
				"https://www.amazon.in/s?k=hair+oil+for+men&crid=1HNS18TIFC55B&sprefix=hair+oil%2Caps%2C5514&ref=nb_sb_ss_ts-doa-p_2_8");

		List<WebElement> oilLists = driver.findElements(By.xpath(
				"//div[@data-component-type='s-search-result'] //span[@class='a-size-base-plus a-color-base a-text-normal']"));
		List<WebElement> oilPriceLists = driver.findElements(
				By.xpath("//div[@data-component-type='s-search-result'] //span[@aria-hidden='true']/span[2]"));
		LinkedHashMap<String, String> oilDescriptionAndPrice = new LinkedHashMap<String, String>();
		System.out.println(oilPriceLists.size());
		for (int i = 0; i < oilLists.size(); i++) {
			System.out.println(oilPriceLists.get(i).getText());

			if (oilLists.get(i).getText().contains("Ayurvedic")) {
				oilDescriptionAndPrice.put(oilLists.get(i).getText(), oilPriceLists.get(i).getText());
			}
		}
		for (String s : oilDescriptionAndPrice.keySet()) {
			System.out.println(s + "-->" + oilDescriptionAndPrice.get(s));
		}

	}

}
