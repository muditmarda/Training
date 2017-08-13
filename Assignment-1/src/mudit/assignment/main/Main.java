package mudit.assignment.main;

import mudit.assignment.data.Dat;
import mudit.assignment.singleton.Sing;

public class Main {
    public static void main(String[] args) {
        Dat obdat = new Dat();
        obdat.printvar();
        obdat.print2();
        String str = new String();
        Sing obsing = Sing.func(str);
        obsing.printstr();
    }
}

