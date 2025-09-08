package diettelException;

public class ExceptionMain {
    public static void main(String[] args) throws ExceptionB {
        try{
            throw new ExceptionA(" For exception A");
        }
        catch (ExceptionA exception){
            System.out.println("Caught exception A: " + exception.getMessage());
        }
        try{
            throw new ExceptionB("For exception B");
        }
        catch ( ExceptionA exception){
            System.out.println("Caught exceptionB as ExceptionA: "+ exception.getMessage());
        }
        try{
            throw new ExceptionC("For exceptionC");
        }
        catch (ExceptionA exception){
            System.out.println("Caught ExceptionC as ExceptionA: " + exception.getMessage());
        }
    }
}
