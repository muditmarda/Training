import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class KYC {
    static String strRes = "\nThe range for KYC Form dates are as follows: \n";

    private static boolean isDateValid(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of inputs to be passed: ");
        int n = sc.nextInt();
        System.out.print("Enter the signup and current dates in the format \"dd-mm-yyyy dd-mm-yyyy\" : \n");

        String[] inputArr = new String[n];
        for (int i = 0; i < n; i++) {
            sc = new Scanner(System.in);
            inputArr[i] = sc.nextLine();
        }

        Calendar signupDate = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();

        for (int i = 0; i < n; i++) {
            try {
                if (!isDateValid(inputArr[i].split(" ")[0]) || !isDateValid(inputArr[i].split(" ")[1]))
                    throw new Exception("Date is invalid.");
                else {
                    signupDate.set(Calendar.DATE, Integer.parseInt(inputArr[i].substring(0, 2)));
                    signupDate.set(Calendar.MONTH, Integer.parseInt(inputArr[i].substring(3, 5)) - 1);
                    signupDate.set(Calendar.YEAR, Integer.parseInt(inputArr[i].substring(6, 10)));

                    currentDate.set(Calendar.DATE, Integer.parseInt(inputArr[i].substring(11, 13)));
                    currentDate.set(Calendar.MONTH, Integer.parseInt(inputArr[i].substring(14, 16)) - 1);
                    currentDate.set(Calendar.YEAR, Integer.parseInt(inputArr[i].substring(17, 21)));

                    getRange(signupDate, currentDate);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(strRes);
    }

    private static void getRange(Calendar signupDate, Calendar currentDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar anniversaryDate = signupDate;


        if (signupDate.compareTo(currentDate) > 0) {
            strRes += "No range\n";
            return;
        }

        while (anniversaryDate.compareTo(currentDate) < 0) {
            anniversaryDate.add(Calendar.YEAR, 1);
        }
        if (anniversaryDate.get(Calendar.YEAR) > currentDate.get(Calendar.YEAR)) {
            anniversaryDate.add(Calendar.YEAR, -1);
        }
        anniversaryDate.add(Calendar.DATE, -30);
        strRes += (dateFormat.format(anniversaryDate.getTime()) + " ");

        anniversaryDate.add(Calendar.DATE, 60);
        if (anniversaryDate.compareTo(currentDate) > 0) {
            strRes += (dateFormat.format(currentDate.getTime()) + "\n");
        } else {
            strRes += (dateFormat.format(anniversaryDate.getTime()) + "\n");
        }
    }
}
