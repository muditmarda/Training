//Create a class with two (overloaded) constructors.
// Using this, call the second constructor inside the first one.


public class Ques2 {
    private int x;

    //this constructor calls the other constructor
    public Ques2(){
        this(1);
    }

    public Ques2(int i){
        this.x = i;
        System.out.println(x);
    }
    public static void main(String[] args) {
        Ques2 obj = new Ques2();
    }
}