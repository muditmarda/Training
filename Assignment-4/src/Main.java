public class Main {
    public static void main(String[] args){
        Integer x = null;
        try {
            MyClass.checkFirst100NaturalNum(x);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
        finally {
            System.out.println("Finally is always executed!");
        }
    }
}
