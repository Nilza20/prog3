package br.ueg.shegoTurismo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import br.ueg.shegoTurismo.model.Atracao;
import br.ueg.shegoTurismo.model.Estabelecimento;
import br.ueg.shegoTurismo.repository.AtracaoRepository;
import br.ueg.shegoTurismo.repository.EstabelecimentoRepository;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Prog3Application {

	public static void main(String[] args) {SpringApplication.run(Prog3Application.class, args);}
	
//	Metodo que inicia todas as vezes que o projeto subir
	@Bean
	CommandLineRunner init (ReactiveMongoOperations operations, AtracaoRepository repository) {
		return args -> {
			Flux<Atracao> atracaoFlux = Flux.just(
					new Atracao(null, "Pista de Caminhada", "Pista de Caminhada perto da UEG", "Centro",  "Santa Helena de Goiás", "Lazer"))
					.flatMap(repository::save);

			atracaoFlux
					.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
	
	
	@Bean
	CommandLineRunner inicializa (ReactiveMongoOperations operations, EstabelecimentoRepository repository) {
		return args -> {
			Flux<Estabelecimento> estabelecimentoFlux = Flux.just(
					new Estabelecimento(null, "Pizzaria Ideal", "pista de caminhada - R. Pau Brasil", 0, "186",  "75920-000", "Santa Helena de Goiás - GO", "(64) 99287-0535", 
							"pizzariaideal@gmail.com", "www.pizzariaideal.com.br"))
					.flatMap(repository::save);

			estabelecimentoFlux
					.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
	
}
