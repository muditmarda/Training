package Ques3;

public class MyClass extends ParentClass implements Interface4 {
    MyClass(){
        System.out.println("Hello! This is My Class.");
    }
    public void method1(){
        System.out.println("This is method 1.");
    };
    public void method2(){
        System.out.println("This is method 2.");
    };
    public void method3(){
        System.out.println("This is method 3.");
    };
    public void methodA(Interface1 interface1){
        System.out.println("This is method A.");
    };
    public void methodB(Interface2 interface2){
        System.out.println("This is method B.");
    };
    public void methodC(Interface3 interface3){
        System.out.println("This is method C.");
    };
    public void methodD(Interface4 interface4) { System.out.println("This is method D."); };
}
