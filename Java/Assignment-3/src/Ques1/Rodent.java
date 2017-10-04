package Ques1;

// Base class

public abstract class Rodent {

    // This method is common to all Rodents
    public void nibble(){
        System.out.println("Nibble, nibble!");
    }

    // Abstract method
    public abstract void gnaw();

    // Default constructor that prints a message about the class
    public Rodent(){
        System.out.println("Hello, I'm a little rodent.");
    }

    public static void main(String[] args){
        Rodent[] RodentArr = new Rodent[5];
        RodentArr[0] = new Mouse();
        RodentArr[1] = new Hamster();
        RodentArr[2] = new Mouse();
        RodentArr[3] = new Gerbil();
        RodentArr[4] = new Rat();
        for (int i = 0; i < 5; i++){
            RodentArr[i].nibble();
            RodentArr[i].gnaw();
        }
    }
}