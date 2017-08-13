package Ques2;

public class Main {
    public static void main(String[] args){
        Unicycle u = new Unicycle();
        Bicycle b = new Bicycle();
        Tricycle t = new Tricycle();
        Cycle[] cycles = new Cycle[3];
        cycles[0] = (Cycle) u;  //upcasting
        cycles[1] = (Cycle) b;  //upcasting
        cycles[2] = (Cycle) t;  //upcasting
        for (int i = 0; i < 3; i++){
            cycles[i].balance();
            // balance won't work unless it is prededined in the cycle class
        }
        Cycle c1 = new Unicycle();
        Cycle c2 = new Bicycle();
        Cycle c3 = new Tricycle();
        Unicycle unicycle = (Unicycle) c1;  //downcasting
        Bicycle bicycle = (Bicycle) c2;     //downcasting
        Tricycle tricycle = (Tricycle) c3;  //downcasting
        unicycle.balance();
        bicycle.balance();
        tricycle.balance();  // balance won't work unless it is prededined in the cycle class
    }
}
