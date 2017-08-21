package mudit.assignment.main;

import mudit.assignment.data.Dat;
import mudit.assignment.singleton.Sing;

public class Main {
    public static void main(String[] args) {
        Dat dat = new Dat();
        dat.printVars();
        dat.print2();
        String str = "Yo";
        Sing sing = Sing.setStr(str);
        sing.printStr();
    }
}

