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
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<Character, Integer> m = new TreeMap<Character, Integer>();
        try {
            while ((temp = reader.read()) != -1){
                c = Character.toLowerCase((char) temp);
                m.put(c, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
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
