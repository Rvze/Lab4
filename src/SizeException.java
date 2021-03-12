public class SizeException extends Exception {
    public SizeException() {
        super("Incorrect size");
    }

    public SizeException(String message) {
        super(message);
    }
}
