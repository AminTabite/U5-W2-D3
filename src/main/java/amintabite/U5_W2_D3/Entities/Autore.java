package amintabite.U5_W2_D3.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Setter
@Getter
@ToString
public class Autore {

    private long idautore;
    private String Nome;
    private String cognome;
    private  String email;
    private String datanascita;
    private String avatar;

    public Autore( String nome, String cognome, String email, String datanascita) {
        Random rnd = new Random();

        this.idautore = rnd.nextInt(1,100);
        Nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datanascita = datanascita;
        this.avatar = "https://www.google.com/url?q=https://ui-avatars.com/api/?name%3DMario%2BRossi&sa=D&source=editors&ust=1760445662767353&usg=AOvVaw1lmHE-H_jNaWzQ8xPb4_X9";
    }
}
