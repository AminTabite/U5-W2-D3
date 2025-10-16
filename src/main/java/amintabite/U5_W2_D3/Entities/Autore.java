package amintabite.U5_W2_D3.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Random;
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Autore {
@Id
@GeneratedValue
    private long idautore;

    private String nome;
    private String cognome;
    private  String email;
    private String datanascita;
    private String avatar;
    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogposts;


@JsonIgnore

    public Autore( String nome, String cognome, String email, String datanascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datanascita = datanascita;
        this.avatar = "https://www.google.com/url?q=https://ui-avatars.com/api/?name%3DMario%2BRossi&sa=D&source=editors&ust=1760445662767353&usg=AOvVaw1lmHE-H_jNaWzQ8xPb4_X9";
    }
}
