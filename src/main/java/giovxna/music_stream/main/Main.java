package giovxna.music_stream.main;

import giovxna.music_stream.model.Artista;
import giovxna.music_stream.model.Musica;
import giovxna.music_stream.model.TipoArtista;
import giovxna.music_stream.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Main(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){
        var opcao = -1;

        while (opcao != 6) {
            var menu = """
                    *** MUSIC STREAM ***
                    
                    1. cadastrar artistas
                    2. cadastrar músicas
                    3. listar músicas
                    4. buscar músicas por artistas
                    5. pesquisar dados sobre um artista
                    6. sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("bye byeeee!! :)");
                    break;
                default:
                    System.out.println("opção inválida!");
            }
        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("informe o nome do artista: ");
            var nome = leitura.nextLine();
            System.out.println("informe o tipo desse artista (solo, dupla ou banda): ");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("deseja cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Informe o título da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void pesquisarDadosDoArtista() {

    }


}
