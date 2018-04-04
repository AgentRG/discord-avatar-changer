import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class changeAvatarModes extends Main {

    static String avatarName;
    private static File[] avatarArray = new File(changeAvatarStrings.pathToAvatars).listFiles();
    private static String previousName;
    private static String currentLine;

    public static void randomChoice() throws InterruptedException {
        Random rand = new Random();
        File avatarInteger = avatarArray[rand.nextInt(avatarArray.length)];
        avatarName = avatarInteger.toString();

        changeAvatarSteps.changeAvatar();
    }

    public static void incrementalChoice() throws IOException, InterruptedException {
        File f = new File(changeAvatarStrings.pathToAvatars+"avatar_list.txt");
        File tmp = new File(changeAvatarStrings.pathToAvatars+"tmp.txt");
        if (!f.exists()) {
            FileWriter fileWriter;
            fileWriter = new FileWriter(changeAvatarStrings.pathToAvatars+"avatar_list.txt");
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
            avatarName = changeAvatarStrings.pathToAvatars + avatarName;
        }
        changeAvatarSteps.changeAvatar();

        BufferedReader reader = new BufferedReader(new FileReader(changeAvatarStrings.pathToAvatars+"avatar_list.txt"));
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
