public class ProportionException extends RuntimeException{
    public ProportionException() {
        super("Incorrect proportion");
    }

    public ProportionException(String message) {
        super(message);
    }

}
