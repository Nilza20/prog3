package br.ueg.shegoTurismo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class AtracaoFlux {
	
	@Test
	void atracaoFlux1() {
		Flux.empty();
	}
	
	@Test
	void atracaoFlux2() {
		Flux<String> flux = Flux.just("Atrações");
		flux.subscribe(System.out::println);
	}
	
	@Test
	void atracaoFlux3() {
		Flux<String> flux = Flux.just("Pista de Caminhada", "Lago do Centro da cidade");
		flux.subscribe(System.out::println);
	}
}
