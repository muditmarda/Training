package Ques3;

// Create three interfaces, each with two methods.
// Inherit a new interface that combines the three, adding a new method.
// Create a class by implementing the new interface and also
// inheriting from a concrete class.
// Now write four methods, each of which takes one of the four interfaces as an argument.
// In main( ), create an object of your class and pass it to each of the methods.


public class Main {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        myClass.methodA(myClass);
        myClass.methodB(myClass);
        myClass.methodC(myClass);
        myClass.methodD(myClass);
    }
}
