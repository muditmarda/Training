import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Vampirenum {
    public static int count = 0, num = 155;

    // num is the number of both 4 and 6 vampire numbers that will be generated and later sorted
    // using a SortedMap. num = 155 = 7 (4-digit) + 148 (6-digit) vampire numbers.
    // It prints the same result for num = 156, since 125460 has two sets of fang pairs
    // 125460 = 204 · 615 = 246 · 510
    // It is the only 6-digit Vampire number with this property.

    public static SortedMap<Integer, Integer> m = new TreeMap<>();

    public static void printVampire(){
        int count = 0;
        for (SortedMap.Entry<Integer, Integer> entry : m.entrySet()) {
            count++;
            if (count == 101)
                break;
            System.out.println((count + ". " + entry.getKey()  + " = " + entry.getValue() + " * " + entry.getKey()/entry.getValue()));
        }
    }

    public static void checkVampire4 (int x, int y){
        if (x % 10 == 0 && y % 10 == 0)
            return;
        int[] arr1 = new int[4]; // will hold the digits of x and y
        int[] arr2 = new int[4]; // will hold the digits of the product of x and y
        // The two arrays will be sorted and compared to check for Vampire number conditions= new int[4];
        arr1[0] = x / 10;
        arr1[1] = x % 10;
        arr1[2] = y / 10;
        arr1[3] = y % 10;
        Arrays.sort(arr1);
        int v = x * y, vtemp = v;
        int i;
        for (i = 0; i < 4; i++){
            arr2[i] = vtemp % 10;
            vtemp /= 10;
        }
        Arrays.sort(arr2);
        for (i = 0; i < 4; i++) {
            if (arr1[i] != arr2[i])
                return;
        }
        if (i == 4) {
            count++;
            m.put(v, x);
        }
    }

    public static void checkVampire6 (int x, int y){
        if (x%10 == 0 && y % 10 == 0){
            return;
        }
        int[] arr1 = new int[6]; // will hold the digits of x and y
        int[] arr2 = new int[6]; // will hold the digits of the product of x and y
        // The two arrays will be sorted and compared to check for Vampire number conditions
        int xtemp = x, ytemp = y;
        for (int i = 0; i < 3; i++){
            arr1[i] = xtemp % 10;
            xtemp /= 10;
        }
        for (int i = 3; i < 6; i++){
            arr1[i] = ytemp % 10;
            ytemp /= 10;
        }
        Arrays.sort(arr1);
        int v = x * y, vtemp = v, i;
        for (i = 0; i < 6; i++){
            arr2[i] = vtemp % 10;
            vtemp /= 10;
            if (i == 4 && vtemp == 0) { // to remove 5 digit numbers from appearing.
                return;
            }
        }
        Arrays.sort(arr2);
        for (i = 0; i < 6; i++) {
            if (arr1[i] != arr2[i])
                return;
        }
        if (i == 6) {
            count++;
            m.put(v, x);
        }
    }

    public static void main (String[] args){

//        I have used a theoretical result found by Pete Hartley:
//        If x·y is a vampire number then x·y == x+y (mod 9)
//        This reduces the complexity of the problem a lot as
//        the cases required to be checked decrease significantly.
//        Thus, the solutions to the congruence are
//        (x mod 9, y mod 9) in {(0,0), (2,2), (3,6), (5,8), (6,3), (8,5)}
//        which I have checked for both 4 digit and 6 digit numbers separately.

        for(int i=18; i<100; i=i+9){  // 18 is the first 2-digit number whose modulo with 9 is 0
            for(int j=i; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }

        for(int i=11; i<100; i=i+9){  // 11 is the first 2-digit number whose modulo with 9 is 2
            for(int j=i; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }

        for(int i=12; i<100; i=i+9){
            for(int j=i+3; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }

        for(int i=14; i<100; i=i+9){
            for(int j=i+3; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=15; i<100; i=i+9){
            for(int j=i-3; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }

        for(int i=17; i<100; i=i+9){
            for(int j=i-3; j<100; j=j+9){
                checkVampire4(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=108; i<1000; i=i+9){
            for(int j=i; j<1000; j=j+9){
                checkVampire6(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=101; i<1000; i=i+9) {
            for (int j = i; j < 1000; j = j + 9) {
                checkVampire6(i, j);
                if (count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=102; i<1000; i=i+9){
            for(int j=i+3; j<1000; j=j+9){
                checkVampire6(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=104; i<1000; i=i+9){
            for(int j=i+3; j<1000; j=j+9){
                checkVampire6(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=105; i<1000; i=i+9){
            for(int j=i-3; j<1000; j=j+9){
                checkVampire6(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
        for(int i=107; i<1000; i=i+9){
            for(int j=i-3; j<1000; j=j+9){
                checkVampire6(i,j);
                if(count == num) {
                    printVampire();
                    return;
                }
            }
        }
    }
}

