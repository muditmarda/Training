// Using TextFile and a Map<Character,Integer>, create a program that takes the file name
// as a command line argument and counts the occurrence of all the different characters.
// Save the results in a text file.


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CountChars {

    public static void main(String args[]){
        String fileName = args[0];
        char c;
        int temp;

        BufferedReader reader = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }

        Map<Character, Integer> m = new TreeMap<Character, Integer>();
        try {
            assert reader != null;
            while ((temp = reader.read()) != -1){
                c = Character.toLowerCase((char) temp);
                m.put(c, 0);
            }
        } catch (IOException i) {
            i.printStackTrace();
        }

        reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert reader != null;
            while ((temp = reader.read()) != -1){
                c = Character.toLowerCase((char) temp);
                m.put(c, m.get(c) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            for (char key : m.keySet()) {
                int count = m.get(key);
                writer.write("\"" + key + "\"" + "  :  " + m.get(key) + "\n");
            }
            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (writer != null)
                    writer.close();


            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
}
