package customExceptions;

public class WithoutCurrentCompany extends Exception{
    
@SuppressWarnings("Serial")


    public WithoutCurrentCompany(){
        super("Sede inexistente");
    }


}