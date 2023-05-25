package FactoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators
    @FindBy(xpath="//nav[@id='sidebar']//a[@class='home']")
    private WebElement homeBtn;
    @FindBy(css="i[data-testid='play-next-btn']")
    private WebElement playNextBtn;
    @FindBy(css="span[data-testid='play-btn']")
    private WebElement playBtn;
    @FindBy(css="i[data-testid='sidebar-create-playlist-btn']")
    private WebElement playlistCreationBtn;
    @FindBy(css="li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistCreation;
    @FindBy(xpath="//section[@id='playlists']//input[@name='name']")
    private WebElement fieldNamePlaylist;
    @FindBy(css="button[class='del btn-delete-playlist']")
    private WebElement playlistDeleteBtn;
    @FindBy(css="input[type='search']")
    private WebElement songSearch;
    @FindBy(css="div.results section.songs h1 button")
    private WebElement viewAllBtn;
    @FindBy(css="section#songResultsWrapper tr.song-item td.title")
    private WebElement firstSongResult;
    @FindBy(css="button.btn-add-to")
    private WebElement addToBtn;
    @FindBy(xpath="//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]")
    private WebElement ourPlaylist;
    @FindBy(css="[name='name']")
    private WebElement playlistNameInputField;
    @FindBy(css="div[data-testid='sound-bar-play']")
    private WebElement soundImage;
    @FindBy(css="div.success.show")
    private WebElement notification;
    @FindBy(css="a.logout.control")
    private WebElement logOutBtn;

    public HomePage searchSongTitle(String songTitle) {
        songSearch.click();
        songSearch.sendKeys(songTitle);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
        return this;
    }
    public HomePage clickViewAllBtn() {
        viewAllBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        return this;
    }
    public HomePage selectFirstSongBySearch() {
        firstSongResult.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.btn-add-to")));
        return this;
    }
    public HomePage clickAddToBtn() {
        addToBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]")));
        return this;
    }
    public HomePage addToPlaylist() {
        ourPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return this;
    }
    public HomePage playASong() {
        playNextBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        playBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
        return this;
    }
    public HomePage createPlaylist(String nameOfPlaylist) {
        playlistCreationBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistCreation.click();
        fieldNamePlaylist.click();
        fieldNamePlaylist.sendKeys(nameOfPlaylist);
        fieldNamePlaylist.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
        return this;
    }
    public HomePage clickPlaylistName(String nameOfPlaylist) {
        findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + nameOfPlaylist + "')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        return this;
    }
    public HomePage deleteThePlaylist() {
        playlistDeleteBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return this;
    }
    public HomePage clickHome() {
        homeBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='home active']")));
        return this;
    }
    public HomePage renameThePlaylistWithDoubleClick(String playlistName, String renamedPlaylist) {
        actions.doubleClick(findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + playlistName + "')]"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameInputField.sendKeys(renamedPlaylist);
        playlistNameInputField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return this;
    }
    public boolean isSongPlaying() {
        return soundImage.isDisplayed();
    }
    public String getNotificationText() {
        return notification.getText();
    }
    public HomePage clickLogOutBtn() {
        logOutBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[data-testid='login-form']")));
        return this;
    }
}
