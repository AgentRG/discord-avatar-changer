import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.Random;

public class Main {

    /**
     * This project uses Selenium to upload random avatars from a specified folder to VoIP software Discord from the web.
     * If the project is built into a jar, crontab can be used to launch the jar at a specified interval.
     */

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, 10);
    static Random rand = new Random();
    static File[] avatarArray = new File(changeAvatarStrings.pathToAvatars).listFiles();
    static File avatarName = avatarArray[rand.nextInt(avatarArray.length)];
    static String pickAvatar = avatarName.toString();

    public static void main (String[] args) throws InterruptedException {

        changeAvatar();

    }

    public static void changeAvatar() throws InterruptedException {

        driver.navigate().to("https://discordapp.com/");

        changeAvatarSteps.loginScreen();
        changeAvatarSteps.enterInformation();
        changeAvatarSteps.loginToAccount();
        changeAvatarSteps.userSettings();
        changeAvatarSteps.editAccount();
        changeAvatarSteps.changeAvatar();

        driver.quit();

    }

}

