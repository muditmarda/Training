// Create three new types of exceptions.
// Write a class with a method that throws all three.
// In main( ), call the method but only use a single catch clause that will
// catch all three types of exceptions.
// Add a finally clause and verify that your finally clause is executed,
// even if a NullPointerException is thrown.

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Enter the number to check: ");
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        MyClass myClass = new MyClass();
        try {
            String s = myClass.checkNaturalNum(x);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
        finally {
            System.out.println("Finally is always executed!");
        }
    }
}
