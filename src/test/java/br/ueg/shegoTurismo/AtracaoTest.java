package br.ueg.shegoTurismo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class AtracaoTest {
	
//	Teste caso os metodos retorne vazio
	@Test
	public void testeAtracao1() {
		Mono<String> mono = Mono.empty();
		
	}
	
	
//	Retorna uma string com o nome de uma atração
	@Test
	public void testeAtracao2() {
		Mono<String> mono = Mono.just("Atrações");
		mono.subscribe(System.out::println);
		
	}
	
//	Retorna uma integer
	@Test
	public void testeAtracao3() {
		Mono<Integer> mono = Mono.just(10);
		mono.subscribe(System.out::println);
		
	}
	
//	tratando uma exceção
	@Test
	public void testeAtracao4() {
		Mono<String> mono = Mono.error(new RuntimeException("Ocorreu uma exeção "));
		mono.subscribe(System.out::println);
		
	}
}
