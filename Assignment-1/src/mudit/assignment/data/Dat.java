package mudit.assignment.data;

public class Dat {
    int abc;
    char def;

    public void printvar() {
        System.out.println(abc);
        System.out.println(def);
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
