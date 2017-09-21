package Ques5;

// Following is the second class with an inner class that inherits from the first inner class.

public class SecondClass extends OuterClass{
    public class InnerClass2 extends OuterClass.InnerClass{

//        Since there is an overloaded constructor in OuterClass.InnerClass,
//        the default constructor is not created by the compiler.
//        Thus there needs to be defined a constructor for InnerClass2 by
//        taking the same parameters.

        public InnerClass2(int i) {
            super(i);
        }
    }
}
