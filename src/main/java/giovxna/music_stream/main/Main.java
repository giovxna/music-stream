package giovxna.music_stream.main;

import java.util.Scanner;

public class Main {

    private Scanner leitura = new Scanner(System.in);

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

    }

    private void cadastrarMusicas() {

    }

    private void listarMusicas() {

    }

    private void buscarMusicasPorArtista() {
        
    }

    private void pesquisarDadosDoArtista() {
    }

}
