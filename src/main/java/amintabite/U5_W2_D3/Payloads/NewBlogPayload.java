package amintabite.U5_W2_D3.Payloads;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString

public class NewBlogPayload {

    private String categoria;
    private  String titolo;
    private String contenuto;
    private int tempolettura;


    public NewBlogPayload(String categoria, String titolo, String contenuto, int tempolettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempolettura = tempolettura;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getTempolettura() {
        return tempolettura;
    }
}
