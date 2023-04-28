public class Homework18 extends BaseTest{
    @Test
    public void playASongTest() throws InterruptedException {
        launchChrome();
        goToPage();
        inputEmail("caiman.cotton@testpro.io");
        inputPassword("te$t$tudent");
        clickSubmit();
        playSong();

    }
}
