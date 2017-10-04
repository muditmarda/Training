//Create a class with a constructor that takes a String argument.
// During construction, print the argument.
// Create an array of object references to this class,
// but don’t actually create objects to assign into the array.
// When you run the program, notice whether the initialization messages
// from the constructor calls are printed.


public class Ques3 {
    public Ques3(String str){
        System.out.println((str));
        System.out.println("Hello!");
    }
    public static void main(String[] args){
        Ques3[] arr;
    }
}

//Initialization calls aren't printed.