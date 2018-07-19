import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeAvatarSteps extends Main {

    /**
     * These are all of the steps required to change your avatar.
     */


    private static boolean staleElement = true;

    public static void changeAvatar() throws InterruptedException {
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
                WebElement loginButton = driver.findElement(By.xpath(DiscordXPath.loginOption));
                loginButton.click();
                staleElement = false;
            }
            catch(StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    private static void enterInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.emailTab)));
        WebElement email = driver.findElement(By.xpath(DiscordXPath.emailTab));
        email.sendKeys(UserInfo.myEmail);

        WebElement password = driver.findElement(By.xpath(DiscordXPath.passwordTab));
        password.sendKeys(UserInfo.myPassword);
    }

    private static void loginToAccount() {
        WebElement loginToAccount = driver.findElement(By.xpath(DiscordXPath.loginToAccount));
        loginToAccount.click();
    }

    private static void userSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.loadingContainer)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.loadingContainer)));
        WebElement options = driver.findElement(By.xpath(DiscordXPath.optionsButton));
        options.click();
    }

    private static void editAccount() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.optionsContainer)));
        Thread.sleep(1000);
        WebElement edit = driver.findElement(By.xpath(DiscordXPath.editProfile));
        edit.click();
    }

    private static void uploadAvatar() throws InterruptedException {
        driver.findElement(By.xpath(DiscordXPath.uploadButton)).sendKeys(PickAvatarModes.avatarName);
        WebElement save = driver.findElement(By.xpath(DiscordXPath.saveButton));
        save.click();
        Thread.sleep(1000);
    }

    private static void logoutAccount() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.saveButton)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.logoutButton))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.confirmLogout)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DiscordXPath.confirmLogout))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DiscordXPath.confirmLogout)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DiscordXPath.emailTab)));
    }

}

