package amintabite.U5_W2_D3.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationErrPayload {
    private String messaggio;
    private LocalDateTime oraevento;
    private List<String> errorivalidazioni;
}
