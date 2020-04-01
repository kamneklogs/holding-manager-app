package customExceptions;

@SuppressWarnings("Serial")
public class NotFundBrandOfficeException extends Exception{

    public NotFundBrandOfficeException(){
        super("Sede inexistente");
    }

}