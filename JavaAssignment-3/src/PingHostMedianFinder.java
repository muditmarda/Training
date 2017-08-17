//Write a java function that will ping any host ( given as input ) and
// computes the median of the time taken to ping using the system ping utility,
// and not any deprecated methods.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class PingHostMedianFinder {

    public static void runSystemCommand(String ip, int num) {

        try {
            String command = "ping " + ip;
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            float[] arr = new float[num];
            int i = 0, numtemp = num;
            String s = inputStream.readLine();
            System.out.println(s);
            while (numtemp > 0){
                s = inputStream.readLine();
                System.out.println(s);
                String[] parts = s.split("time=");
                String[] parts2 = parts[1].split(" ms");
                arr[i] = Float.valueOf(parts2[0]);
                numtemp--;
                i++;
            }
            Arrays.sort(arr);
            System.out.println("\nMedian of the time taken to ping is ");
            if(num % 2 != 0){
                System.out.println(arr[num / 2]+ " ms");
            }
            else {
                System.out.println((arr[num/2 - 1] + arr[num/2]) / 2 + " ms");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the IP to ping: ");
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        System.out.println("Enter the number of times needed to ping: ");
        int num = scanner.nextInt();
        runSystemCommand(ip, num);
    }
}
