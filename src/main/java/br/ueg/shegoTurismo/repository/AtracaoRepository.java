package br.ueg.shegoTurismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.ueg.shegoTurismo.model.Atracao;

public interface AtracaoRepository extends ReactiveMongoRepository <Atracao, String>{

}
