import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    /**
     * This project uses Selenium to upload random avatars from a specified folder to VoIP software Discord from the web.
     *
     * The project has two modes.
     * 1. Randomly pick a picture from the folder and upload it.
     * 2. Incrementally upload a picture from the folder.
     *
     * Uncomment whichever mode you want to use and fill in the required information in UserInfo.
     */

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, 30);

    public static void main (String[] args) {
        try {
            //PickAvatarModes.randomChoice();
            //PickAvatarModes.incrementalChoice();
        }
        catch (Exception e){
            e.printStackTrace();
            driver.quit();
        }
    }
}

