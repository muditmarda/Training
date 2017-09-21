package Ques1;
public class Hamster extends Rodent {

    @Override
    public void nibble(){
        System.out.println("Nibble, nibble like a Hamster!");
    }

    @Override
    public void gnaw() {
        System.out.println("Hamster gnaws.");
    }

    public Hamster() {
        System.out.println("Hello, I'm a little hamster.");
    }
}

