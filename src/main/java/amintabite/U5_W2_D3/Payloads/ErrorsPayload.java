package amintabite.U5_W2_D3.Payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayload {
    private String messaggio;
    private LocalDateTime oraevento;
}
