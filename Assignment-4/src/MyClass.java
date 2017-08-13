public class MyClass {
    public static void checkFirst100NaturalNum (Integer x) throws Exception1, Exception2, Exception3{
        if (x < 0)
            throw new Exception1("x cannot be negative.");
        else if (x == 0)
            throw new Exception2("x cannot be zero.");
        else if (x > 100)
            throw new Exception3("x cannot be greater than 100.");
        else
            System.out.println("All is well!");
    }
}
