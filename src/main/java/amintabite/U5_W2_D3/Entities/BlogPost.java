package amintabite.U5_W2_D3.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class BlogPost {

    @Id
    @GeneratedValue
    private long blogid;
    private String categoria;
    private  String titolo;
    private String cover;
    private String contenuto;
    private int tempolettura;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private  Autore autore;


    public BlogPost(String categoria, String titolo, String cover, int tempolettura) {

        Random rnd = new Random();
        this.blogid = rnd.nextInt(1,1000);
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://fastly.picsum.photos/id/591/200/300.jpg?hmac=GBnqheK8f8NgGoZ-JQIGl0uYMejcmT4gvw4PsBmUWPY";
        this.contenuto = contenuto;
        this.tempolettura = tempolettura;
    }
}
