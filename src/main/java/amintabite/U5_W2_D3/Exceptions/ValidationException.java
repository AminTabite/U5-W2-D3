package amintabite.U5_W2_D3.Exceptions;
import lombok.Getter;
import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
    private List<String> errorsMessages;

    public ValidationException(List<String> errorsMessages) {
        super("errore di validazione");
        this.errorsMessages = errorsMessages;
    }
}