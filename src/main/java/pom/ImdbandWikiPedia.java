package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ImdbandWikiPedia {
	@FindBy(xpath = ("//*[@id=\"releaseinfo_content\"]/table[1]/tbody/tr[6]/td[2]"))
	private WebElement imdbreleasedate;

	@FindBy(xpath = ("//*[@id=\"releaseinfo_content\"]/table[1]/tbody/tr[6]/td[1]"))
	private WebElement imdbcountryname;

	@FindBy(xpath = ("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td"))
	private WebElement wikireleasedate;

	@FindBy(xpath = ("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td"))
	private WebElement wikicountryname;

	public ImdbandWikiPedia(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@Test
	public String imdbreleaseDate() {
		return imdbreleasedate.getText();
	}

	public String imdbcountryName() {
		return imdbcountryname.getText();
	}

	public String wikireleaseDate() {
		return wikireleasedate.getText();
	}

	public String wikicountryname() {
		return wikicountryname.getText();
	}
}