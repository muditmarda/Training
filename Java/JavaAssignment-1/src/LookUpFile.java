// Create an java program to search through the home directory and
// look for files that match a regular expression.
// The program should be able to take inputs repeatedly and
// should print out full absolute path of the matching files found.


import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class LookUpFile {

    private void printAbsolutePath(File dir, Pattern p) {
        File[] files = dir.listFiles();
        if(files == null){
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                printAbsolutePath(file, p); // Calls same method again.
            } else {
                Matcher m = p.matcher(file.getName());
                if (m.matches()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }


    public static void main(String args[]){
        String currentUsersHomeDir = System.getProperty("user.home");
        File dir = new File(currentUsersHomeDir);
        System.out.println("Enter the regular expression to match with the filenames: ");
        Scanner scanner = new Scanner(System.in);
        try{
            String input = scanner.nextLine();
            while(!Utils.shouldExit(input)) {
                Pattern p = Pattern.compile(input);
                LookUpFile lookUpFile = new LookUpFile();
                lookUpFile.printAbsolutePath(dir, p);
                System.out.println("\nEnter the regular expression to match with the filenames: ");
                input = scanner.nextLine();
            }
        } catch (PatternSyntaxException e){
            System.out.println(e);
        }
    }
}
