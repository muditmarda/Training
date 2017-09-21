package mudit.assignment.singleton;

public class Sing {
    private String str;
    public static Sing setStr(String str){
    	Sing obj  = new Sing();
        obj.str = str;
    	return obj;
    }
    public void printStr(){
        System.out.println(str);
    }   
}
