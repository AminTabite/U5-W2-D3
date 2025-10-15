package amintabite.U5_W2_D3.Payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewAutorePayload {

    private String Nome;
    private String cognome;
    private  String email;
    private String datanascita;

}
