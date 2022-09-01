package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ImdbandWikiPedia;

public class Execution {

	String imdbreleaseDate;
	String imdbcountryName;
	String wikireleaseDate;
	String wikicountryname;
	WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		driver = ChromeBrowser.openBrowser();

	}

	@Test
	public void getReleaseDateandCountryName() throws InterruptedException {
		driver.get("https://www.imdb.com/title/tt9389998/releaseinfo?ref_=tt_dt_rdat");
		ImdbandWikiPedia imdbandwikipedia = new ImdbandWikiPedia(driver);
		imdbreleaseDate = imdbandwikipedia.imdbreleaseDate();
		imdbcountryName = imdbandwikipedia.imdbcountryName();
		System.out.println("Release date is " + imdbreleaseDate + " and country is " + imdbcountryName);
		Thread.sleep(3000);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		wikireleaseDate = imdbandwikipedia.wikireleaseDate();
		wikicountryname = imdbandwikipedia.wikicountryname();
		System.out.println("Release date is " + wikireleaseDate + " and country is " + wikicountryname);
		Assert.assertEquals(imdbreleaseDate, wikireleaseDate);
		Assert.assertEquals(imdbcountryName, wikicountryname);
	}
	
	@AfterTest
	public void closeTest() {
		driver.quit();
	}

}