package Ques1;
public class Gerbil extends Rodent {
    @Override
    public void nibble(){
        System.out.println("Nibble, nibble like a Gerbil!");

    }

    public void gnaw(){
        System.out.println("Gerbil gnaws.");
    }

    public Gerbil(){
        System.out.println("Hello, I'm a little gerbil.");
    }
}
