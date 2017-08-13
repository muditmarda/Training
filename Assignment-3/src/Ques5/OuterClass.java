package Ques5;

public class OuterClass {
    public class InnerClass {
        private int i;
        public InnerClass (int i){
            this.i = i;
            System.out.println("i = " + i + ". \n That's all, folks!");
        }
    }
}
