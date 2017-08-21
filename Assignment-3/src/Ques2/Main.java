package Ques2;

// Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
// Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle.
// Create instances of all three types and upcast them to an array of Cycle.
// Try to call balance( ) on each element of the array and observe the results.
// Downcast and call balance( ) and observe what happens.


public class Main {
    public static void main(String[] args) {
        Unicycle u = new Unicycle();
        Bicycle b = new Bicycle();
        Tricycle t = new Tricycle();
        Cycle[] cycles = new Cycle[3];
        cycles[0] = (Cycle) u;  //upcasting
        cycles[1] = (Cycle) b;  //upcasting
        cycles[2] = (Cycle) t;  //upcasting
        for (int i = 0; i < 3; i++) {
            // cycles[i].balance();
            // balance won't work for cycle[2], the tricycle
            // unless it is predefined in the cycle class
        }
        Cycle c1 = new Unicycle();
        Cycle c2 = new Bicycle();
        Cycle c3 = new Tricycle();
        Unicycle unicycle = (Unicycle) c1;  //downcasting
        Bicycle bicycle = (Bicycle) c2;     //downcasting
        Tricycle tricycle = (Tricycle) c3;  //downcasting
        unicycle.balance();
        bicycle.balance();
        // tricycle.balance();
        // balance won't work for tricycle
        // unless it is predefined in the cycle class
    }
}
