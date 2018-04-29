import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class changeAvatarSteps extends Main {

    private static boolean staleElement = true;

    public static void changeAvatar() throws InterruptedException {
        driver.navigate().to("https://discordapp.com/");
        loginScreen();
        enterInformation();
        loginToAccount();
        userSettings();
        editAccount();
        uploadAvatar();
        driver.quit();
    }

    private static void loginScreen() {
        while(staleElement) {
            try {
                WebElement loginButton = driver.findElement(By.xpath(changeAvatarStrings.loginOption));
                loginButton.click();
                staleElement = false;
            }
            catch(StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    private static void enterInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.emailTab)));
        WebElement email = driver.findElement(By.xpath(changeAvatarStrings.emailTab));
        email.sendKeys(changeAvatarStrings.myEmail);

        WebElement password = driver.findElement(By.xpath(changeAvatarStrings.passwordTab));
        password.sendKeys(changeAvatarStrings.myPassword);
    }

    private static void loginToAccount() {
        WebElement loginToAccount = driver.findElement(By.xpath(changeAvatarStrings.loginToAccount));
        loginToAccount.click();
    }

    private static void userSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.loadingContainer)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(changeAvatarStrings.loadingContainer)));
        WebElement options = driver.findElement(By.xpath(changeAvatarStrings.optionsButton));
        options.click();
    }

    private static void editAccount() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.optionsContainer)));
        Thread.sleep(1000);
        WebElement edit = driver.findElement(By.xpath(changeAvatarStrings.editProfile));
        edit.click();
    }

    private static void uploadAvatar() throws InterruptedException {
        driver.findElement(By.xpath(changeAvatarStrings.uploadButton)).sendKeys(changeAvatarModes.avatarName);
        WebElement save = driver.findElement(By.xpath(changeAvatarStrings.saveButton));
        save.click();
        Thread.sleep(1000);
    }
}

