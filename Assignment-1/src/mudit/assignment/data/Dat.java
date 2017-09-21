package mudit.assignment.data;

public class Dat {
    private int a;
    private char c;

    public void printVars() {
        System.out.println(a);
        System.out.println(c);
    }

    public void print2() {
        int a;
        int b;
        /*
        System.out.println(a);
        System.out.println(b);
        */
        // The local variables a and b haven't been initialised and hence can't be used.
    }
}
