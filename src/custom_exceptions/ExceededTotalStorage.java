package src.custom_exceptions;

public class ExceededTotalStorage extends Exception{

    public ExceededTotalStorage(String message) {
        super(message);
    }


}
