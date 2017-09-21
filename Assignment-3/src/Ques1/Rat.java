package Ques1;
public class Rat extends Rodent {

    @Override
    public void nibble(){
        System.out.println("Nibble, nibble like a Rat!");
    }

    @Override
    public void gnaw() {
        System.out.println("Rat gnaws.");
    }

    public Rat() {
        System.out.println("Hello, I'm a little rat.");
    }
}