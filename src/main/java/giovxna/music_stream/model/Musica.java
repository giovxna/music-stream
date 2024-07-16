package giovxna.music_stream.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "musicas")

public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Artista artista;

    public Musica(){}
    public Musica(String nomeMusica) {
        this.titulo = nomeMusica;
    }

    @Override
    public String toString() {
        return "música: " + titulo + '\'' +
                "artista: " + artista.getNome();
    }


}
