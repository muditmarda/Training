//Create a class with a constructor that takes a String argument.
// During construction, print the argument.
// Create an array of object references to this class,
// and create objects to assign into the array.
// When you run the program, notice whether the initialization messages
// from the constructor calls are printed.


public class Ques4 {
    public Ques4(String str){
        System.out.println((str));
    }
    public static void main(String[] args){
        Ques4[] Ques4arr = new Ques4[2];
        Ques4arr[0] = new Ques4("Why do we fall, Bruce?");
        Ques4arr[1] = new Ques4("So we can learn to pick ourselves up.");
    }
}

//Initialization messages are now printed.