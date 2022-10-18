package services.exceptions;

public class DataBaseException extends RuntimeException{
    private static final long serialVersionUid = 1L;

    public DataBaseException(String msg) {
        super(msg);
    }

}