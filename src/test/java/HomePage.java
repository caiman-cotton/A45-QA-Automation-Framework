import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators
   By homeBtn = By.xpath("//nav[@id='sidebar']//a[@class='home']");
    By playNextBtn = By.cssSelector("i[data-testid='play-next-btn']");
    By playBtn = By.cssSelector("span[data-testid='play-btn']");
    By soundImage = By.cssSelector("div[data-testid='sound-bar-play']");
    By playlistCreationBtn = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistCreation = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By fieldNamePlaylist = By.xpath("//section[@id='playlists']//input[@name='name']");
    By playlistDeleteBtn = By.cssSelector("button[class='del btn-delete-playlist']");
    By songSearch = By.cssSelector("input[type='search']");
    By viewAllBtn = By.cssSelector("div.results section.songs h1 button");
    By firstSongResult = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToBtn = By.cssSelector("button.btn-add-to");
    By ourPlaylist = By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]");
    By notification = By.cssSelector("div.success.show");
    By playlistNameInputField = By.cssSelector("[name='name']");

    public void searchSongTitle(String songTitle) {
        findElement(songSearch).click();
        findElement(songSearch).sendKeys(songTitle);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
    }
    public void clickViewAllBtn() {
        findElement(viewAllBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
    }
    public void selectFirstSongBySearch() {
       findElement(firstSongResult).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.btn-add-to")));
    }
    public void clickAddToBtn() {
        findElement(addToBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'playlist')]")));
    }
    public void addToPlaylist() {
      findElement(ourPlaylist).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public String getNotificationText() {
        return findElement(notification).getText();
    }
    public void playASong() {
        findElement(playNextBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        findElement(playBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
    }
    public boolean isSongPlaying() {
        return findElement(soundImage).isDisplayed();
    }
    public void createPlaylist(String nameOfPlaylist) {
        findElement(playlistCreationBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        findElement(newPlaylistCreation).click();
        findElement(fieldNamePlaylist).click();
        findElement(fieldNamePlaylist).sendKeys(nameOfPlaylist);
        findElement(fieldNamePlaylist).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickPlaylistName(String nameOfPlaylist) {
        findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + nameOfPlaylist + "')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
    }
    public void deleteThePlaylist() {
        findElement(playlistDeleteBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
    public void clickHome() {
        findElement(homeBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='home active']")));
    }
    public void renameThePlaylistWithDoubleClick(String playlistName, String renamedPlaylist) {
        actions.doubleClick(findElement(By.xpath("//section[@id='playlists']//a[contains(text(), '" + playlistName + "')]"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        findElement(playlistNameInputField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameInputField).sendKeys(renamedPlaylist);
        findElement(playlistNameInputField).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    }
}

