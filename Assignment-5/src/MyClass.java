//write and test a regular expression that checks a sentence to see
// that it begins with a capital letter and ends with a period.


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MyClass {
    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public boolean matchornot(String str) {
        Pattern p = Pattern.compile("[A-Z].*\\.");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }
}
