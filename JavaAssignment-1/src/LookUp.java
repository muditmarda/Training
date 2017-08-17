// Create an java program to search through the home directory and
// look for files that match a regular expression.
// The program should be able to take inputs repeatedly and
// should print out full absolute path of the matching files found.


import com.sun.istack.internal.NotNull;

import java.io.File;
//import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookUp {

    private void method(File dir, Pattern p) {
        try {
            File[] files = dir.listFiles();
            if(files == null){
                return;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    method(file, p); // Calls same method again.
                } else {
                    Matcher m = p.matcher(file.getName());
                    if (m.matches()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){
        String currentUsersHomeDir = System.getProperty("user.home");
        File dir = new File(currentUsersHomeDir);
        System.out.println("Enter the regular expression to match with the filenames: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!Utils.shouldExit(input)) {
            Pattern p = Pattern.compile(input);
            LookUp lookUp = new LookUp();
            lookUp.method(dir, p);
            System.out.println("\nEnter the regular expression to match with the filenames: ");
            input = scanner.nextLine();
        }
    }
}
