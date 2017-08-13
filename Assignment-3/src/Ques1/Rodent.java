package Ques1;
public class Rodent {
    public void nibble(){
        System.out.println("Nibble, nibble!");
    }
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
        }
    }
}