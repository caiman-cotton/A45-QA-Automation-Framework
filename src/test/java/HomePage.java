import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //locators
   By homeBtn = By.xpath("//nav[@id='sidebar']//a[@class='home']");
    By playNextBtn = By.cssSelector("i[data-testid='play-next-btn']");
    By soundImage = By.cssSelector("div[data-testid='sound-bar-play']");
    By playlistCreationBtn = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistCreation = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By fieldNamePlaylist = By.xpath("//section[@id='playlists']//input[@name='name']");
    By playlistDeleteBtn = By.cssSelector("button[class='del btn-delete-playlist']");
    By songSearch = By.cssSelector("input[type='search']");
    By viewAllBtn = By.cssSelector("div.results section.songs h1 button");
    By firstSongResult = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToBtn = By.cssSelector("button.btn-add-to");
    By ourPlaylist = By.xpath("")

}
