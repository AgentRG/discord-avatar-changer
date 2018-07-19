import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class PickAvatarModes extends Main {

    /**
     * These are the two modes are available for changing your avatar.
     * 1. randomChoice will pick a random picture that it will find in the directory you provided.
     * 2. incrementalChoice will create a text file in the the directory you provided, and edit the text every time the jar is launched.
     *    The first line in the text file will be the picture it picks as the avatar. Accepts only jpg, jpeg, and png.
     */

    static String avatarName;
    private static File[] avatarArray = new File(UserInfo.pathToAvatars).listFiles();
    private static String previousName;
    private static String currentLine;

    public static void randomChoice() throws InterruptedException {
        Random rand = new Random();
        File avatarInteger = avatarArray[rand.nextInt(avatarArray.length)];
        avatarName = avatarInteger.toString();

        ChangeAvatarSteps.changeAvatar();
    }

    public static void incrementalChoice() throws IOException, InterruptedException {
        File f = new File(UserInfo.pathToAvatars+"avatar_list.txt");
        File tmp = new File(UserInfo.pathToAvatars+"tmp.txt");
        if (!f.exists()) {
            FileWriter fileWriter;
            fileWriter = new FileWriter(UserInfo.pathToAvatars+"avatar_list.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < avatarArray.length; i++)
                if (!avatarArray[i].isHidden()) {
                    avatarName = avatarArray[i].getName();
                    if(avatarName.contains(".png") || avatarName.contains(".jpg") || avatarName.contains(".jpeg")) {
                        printWriter.println(avatarName);
                    }
                }
            printWriter.close();
        }
        Scanner scan = new Scanner(f);
        String result;
        if (scan.hasNextLine()) {
            result = scan.nextLine();
            avatarName = result;
            previousName = avatarName;
            avatarName = UserInfo.pathToAvatars + avatarName;
        }
        ChangeAvatarSteps.changeAvatar();

        BufferedReader reader = new BufferedReader(new FileReader(UserInfo.pathToAvatars+"avatar_list.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmp));

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(previousName))
                continue;
            writer.write(currentLine + "\n");
        }

        writer.write(previousName);

        reader.close();
        writer.close();

        tmp.renameTo(f);
    }
}
