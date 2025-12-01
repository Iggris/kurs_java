package rozgrywka;

public class WymiernaFormatException extends WymiernaInputException {
    public WymiernaFormatException(String msg) {
        super(msg);
    }

    public WymiernaFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
