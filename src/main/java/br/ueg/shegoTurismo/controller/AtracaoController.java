package br.ueg.shegoTurismo.controller;


import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.shegoTurismo.model.Atracao;
import br.ueg.shegoTurismo.model.ModelEvent;
import br.ueg.shegoTurismo.repository.AtracaoRepository;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/atracoes")
public class AtracaoController {
	
	private AtracaoRepository atracaoRepository;
	
//	Metodo para construir o objeto
	public AtracaoController(AtracaoRepository atracaoRepository) { 
		this.atracaoRepository = atracaoRepository; 
	}
	
//	Trazer todos as atrações
	@GetMapping
	@ApiOperation(value = "Método para listar todas as atrações disponivel na cidade de Shego.")
    public Flux<Atracao> getAllAtracao() {
		return atracaoRepository.findAll();
	}
	
//	Busca por atrações por Id
	@GetMapping("/{id}")
	@ApiOperation(value = "Método para listar as atrações por ID disponivel na cidade de Shego.")
    public Mono<ResponseEntity<Atracao>> getAtracao(@PathVariable String id) {
        return atracaoRepository.findById(id)
                .map(atracao -> ResponseEntity.ok(atracao))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value ="salva um atrações, não possui campo obrigatório.")
    public Mono<Atracao> saveAtracao(@RequestBody Atracao atracao) {
        return atracaoRepository.save(atracao);
    }
	
	@PutMapping("{id}")
	@ApiOperation(value ="Metodo para realizar alteração de atração.")
    public Mono<ResponseEntity<Atracao>> updateAtracao(@PathVariable(value = "id") String id, @RequestBody Atracao atracoes) {
        return atracaoRepository.findById(id)
                .flatMap(existingAtracoes -> {
                	existingAtracoes.setNome(atracoes.getNome());
                	existingAtracoes.setDescricao(atracoes.getDescricao());
                	existingAtracoes.setBairro(atracoes.getBairro());
                	existingAtracoes.setCidade(atracoes.getCidade());                	
                	existingAtracoes.setCategorias(atracoes.getCategorias());
                    return atracaoRepository.save(existingAtracoes);
                })
                .map(updatePokemon -> ResponseEntity.ok(updatePokemon))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }
    @DeleteMapping("{id}")
    @ApiOperation(value ="Metodo para deletar atração por ID.")
    public Mono<ResponseEntity<Void>> deleteAtracao(@PathVariable(value = "id") String id) {
        return atracaoRepository.findById(id)
                .flatMap(existingAtracoes ->
                atracaoRepository.delete(existingAtracoes)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    @ApiOperation(value ="Metodo para deletar todas as atrações cadastrada.")
    public Mono<Void> deleteAllAtracao() {
        return atracaoRepository.deleteAll();
    }
    
    @ApiOperation(value ="Metodo Stream de Eventos.")
    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ModelEvent> getAtracaoEvents() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(val ->
                        new ModelEvent(val, "Programação III")
                );
    }
}
