package mudit.assignment.singleton;

public class Sing {
    String str;
    public static Sing func(String str){
    	Sing obj  = new Sing();
	obj.str = str;
    	return obj;
    }
    public void printstr(){
        System.out.println(str);
    }   
}
