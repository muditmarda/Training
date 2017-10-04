public class Main {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        myClass.setStr("Dhjbhjb...hk");
        if(myClass.matchornot(myClass.getStr()))
            System.out.println("Matched");
        else
            System.out.println("oops");
    }
}
