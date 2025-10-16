package amintabite.U5_W2_D3.Payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class NewBlogPayload {
@NotBlank

    private String categoria;
    @NotBlank
    @Size(min = 3, max = 20, message = "il titolo deve avere almeno 3 caratteri e max 20")
    private String titolo;
    @NotBlank
    @Size(min = 100, max = 500, message = "nome e cognome devono avere almeno 3 caratteri e max 20")
    private String contenuto;
    @NotBlank
    private int tempolettura;

    private long autoreid;


    public NewBlogPayload(String categoria, String titolo, String contenuto, int tempolettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempolettura = tempolettura;
        this.autoreid = autoreid;
    }

}
