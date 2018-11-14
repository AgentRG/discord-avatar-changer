public class DiscordXPath extends Main {

    /**
     * These are the xpaths required to change the avatar.
     */

    static String loginOption = "//a[text()='Login']";
    static String emailTab = "//*[@type='email']";
    static String passwordTab = "//*[@type='password']";
    static String loginToAccount = "//*[@type='submit']";
    static String loadingContainer = "//*[@class='container-16j22k fixClipping-3qAKRb']";
    static String optionsButton = "//button[@type='button' and contains(@class, 'button-2b6hmh')]";
    static String optionsContainer = "//*[@class='layers-3iHuyZ flex-vertical flex-spacer']";
    static String editProfile = "//button[contains(@class, 'userInfoViewingButton')]";
    static String uploadButton = "//input[@class='file-input']";
    static String saveButton = "//button[contains(@class, 'Green')]";
    static String logoutButton = "//div[@class='itemDefault-3Jdr52 item-PXvHYJ notSelected-1N1G5p' and .='Log Out']";
    static String confirmLogout = "//button[@type='submit' and .='Log Out']";

}
