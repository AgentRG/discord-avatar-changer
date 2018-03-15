import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class changeAvatarSteps extends Main {

    public static void loginScreen() {
        WebElement loginButton = driver.findElement(By.xpath(changeAvatarStrings.loginOption));
        loginButton.click();
    }

    public static void enterInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.emailTab)));
        WebElement email = driver.findElement(By.xpath(changeAvatarStrings.emailTab));
        email.sendKeys(changeAvatarStrings.myEmail);

        WebElement password = driver.findElement(By.xpath(changeAvatarStrings.passwordTab));
        password.sendKeys(changeAvatarStrings.myPassword);
    }

    public static void loginToAccount() {
        WebElement loginToAccount = driver.findElement(By.xpath(changeAvatarStrings.loginToAccount));
        loginToAccount.click();
    }

    public static void userSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.loadingContainer)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(changeAvatarStrings.loadingContainer)));
        WebElement options = driver.findElement(By.xpath(changeAvatarStrings.optionsButton));
        options.click();
    }

    public static void editAccount() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeAvatarStrings.optionsContainer)));
        Thread.sleep(1000);
        WebElement edit = driver.findElement(By.xpath(changeAvatarStrings.editProfile));
        edit.click();
    }

    public static void changeAvatar() throws InterruptedException {
        driver.findElement(By.xpath(changeAvatarStrings.uploadButton)).sendKeys(
                pickAvatar);
        WebElement save = driver.findElement(By.xpath(changeAvatarStrings.saveButton));
        save.click();
        Thread.sleep(1000);
    }
}

