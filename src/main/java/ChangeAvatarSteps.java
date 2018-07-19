import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeAvatarSteps extends Main {

    /**
     * These are all of the steps required to change your avatar.
     */


    private static boolean staleElement = true;

    public static void changeAvatar() {
        driver.navigate().to("https://discordapp.com/");
        loginScreen();
        enterInformation();
        loginToAccount();
        userSettings();
        editAccount();
        uploadAvatar();
        logoutAccount();
        driver.quit();
    }

    private static void loginScreen() {
        while(staleElement) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.loginOption))).click();
                staleElement = false;
            }
            catch(StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    private static void enterInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.emailTab)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.emailTab))).sendKeys(UserInfo.myEmail);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.passwordTab))).sendKeys(UserInfo.myPassword);
    }

    private static void loginToAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.loginToAccount))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.loginToAccount)));
    }

    private static void userSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.loadingContainer)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.loadingContainer)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.optionsButton))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.optionsButton)));
    }

    private static void editAccount() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.optionsContainer)));
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.editProfile))).click();
        }
        catch (Exception e) {

        }
    }

    private static void uploadAvatar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.saveButton)));
        driver.findElement(By.xpath(DiscordXPath.uploadButton)).sendKeys(PickAvatarModes.avatarName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.saveButton))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.saveButton)));
    }

    private static void logoutAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.logoutButton))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.confirmLogout)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.confirmLogout))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.confirmLogout)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.emailTab)));
    }

}

