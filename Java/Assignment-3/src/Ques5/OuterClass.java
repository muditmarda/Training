package Ques5;

// Following is the class with an inner class that has a non-default constructor.

public class OuterClass {
    public class InnerClass {
        private int i;
        public InnerClass (int i){
            this.i = i;
            System.out.println("i = " + i + ". \n That's all, folks!");
        }
    }
}
