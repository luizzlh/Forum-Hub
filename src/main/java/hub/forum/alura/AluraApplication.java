package hub.forum.alura;

import hub.forum.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraApplication {
	@Autowired
	private TopicoRepository topicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AluraApplication.class, args);
	}

}
