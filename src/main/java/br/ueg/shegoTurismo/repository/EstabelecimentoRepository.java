package br.ueg.shegoTurismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.ueg.shegoTurismo.model.Estabelecimento;

public interface EstabelecimentoRepository extends ReactiveMongoRepository <Estabelecimento, String>{

}
