package amintabite.U5_W2_D3.Payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewAutorePayload {

    @NotBlank
    @Size(min = 3, max = 20, message = "nome e cognome devono avere almeno 3 caratteri e max 20")
    private String nome;
    @NotBlank
    @Size(min = 3, max = 20, message = "nome e cognome devono avere almeno 3 caratteri e max 20")
    private String cognome;
    @NotBlank
    @Email(message = "L'indirizzo email inserito non è nel formato corretto!")
    private  String email;
    @NotBlank

    private String datanascita;

}
