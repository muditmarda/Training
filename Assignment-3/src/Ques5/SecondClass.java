package Ques5;

public class SecondClass extends OuterClass{
    public class InnerClass2 extends OuterClass.InnerClass{

//        Since there is an overloaded constructor in OuterClass.InnerClass,
//        the default constructor is not created by the compiler.
//        Thus there needs to be defined a constructor taking the same arguments.

        public InnerClass2(int i) {
            super(i);
        }
    }
}
