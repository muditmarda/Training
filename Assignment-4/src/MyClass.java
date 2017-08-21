// checkNaturalNum method of MyClass takes a double as input and
// checks if it is a Natural number or not.

public class MyClass {
    public String checkNaturalNum(double x) throws Exception1, Exception2, Exception3{
        if (x < 0)
            throw new Exception1();
        else if (x == 0)
            throw new Exception2("x cannot be zero.");
        else if (x != (int)x)
            throw new Exception3("x cannot have a decimal value.");
        else
            return ("All is well!");
    }
}
