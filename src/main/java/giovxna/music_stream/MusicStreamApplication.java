package giovxna.music_stream;

import giovxna.music_stream.main.Main;
import giovxna.music_stream.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicStreamApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(MusicStreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repositorio);
		main.exibeMenu();
	}
}
