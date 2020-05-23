package customExceptions;


@SuppressWarnings("serial")
public class WithoutCurrentCompanyException extends Exception{
    
    public WithoutCurrentCompanyException(){
        super("Sede inexistente");
    }


}