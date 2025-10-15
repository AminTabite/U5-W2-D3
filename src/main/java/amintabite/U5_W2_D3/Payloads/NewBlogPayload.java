package amintabite.U5_W2_D3.Payloads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class NewBlogPayload {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempolettura;
    private String autoreid;


    public NewBlogPayload(String categoria, String titolo, String contenuto, int tempolettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempolettura = tempolettura;
        this.autoreid = autoreid;
    }

}
