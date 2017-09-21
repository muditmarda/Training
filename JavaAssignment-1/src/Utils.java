public class Utils {
    public static boolean shouldExit(String input){
        if(input == null){
            return false;
        }
        input = input.toLowerCase();
        return input.equals("exit");
    }
}
