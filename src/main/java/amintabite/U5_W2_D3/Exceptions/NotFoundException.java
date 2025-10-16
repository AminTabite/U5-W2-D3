package amintabite.U5_W2_D3.Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super("Il record  non è stato trovato!");
    }
}
