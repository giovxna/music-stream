package giovxna.music_stream;

import giovxna.music_stream.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicStreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MusicStreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.exibeMenu();
	}
}
