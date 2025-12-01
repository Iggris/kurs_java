package rozgrywka;

public class WymiernaInputException extends Exception {
    public WymiernaInputException(String msg) {
        super(msg);
    }

    public WymiernaInputException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
