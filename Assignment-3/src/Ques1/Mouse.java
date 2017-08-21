package Ques1;
public class Mouse extends Rodent {

    @Override
    public void nibble(){
        System.out.println("Nibble, nibble like a Mouse!");
    }

    @Override
    public void gnaw() {
        System.out.println("Mouse gnaws.");
    }

    public Mouse(){
        System.out.println("Hello, I'm a little mouse.");
    }
}
