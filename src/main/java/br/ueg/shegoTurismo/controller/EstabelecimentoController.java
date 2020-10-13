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

import br.ueg.shegoTurismo.model.Estabelecimento;
import br.ueg.shegoTurismo.model.ModelEvent;
import br.ueg.shegoTurismo.repository.EstabelecimentoRepository;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
	
	private EstabelecimentoRepository estabelecimentoRepository;
	
//	Metodo para construir o objeto
	public EstabelecimentoController(EstabelecimentoRepository estabelecimentoRepository) { 
		this.estabelecimentoRepository = estabelecimentoRepository; 
	}
	
//	Trazer todos as Estabelecimento
	@GetMapping
	@ApiOperation(value = "Método para listar todos os estabelecimentos disponivel na cidade de Shego.")
    public Flux<Estabelecimento> getAllEstabelecimento() {
		return estabelecimentoRepository.findAll();
	}
	
//	Busca por Estabelecimento por Id
	@GetMapping("/{id}")
	@ApiOperation(value = "Método para listar estabelecimentos por ID disponivel na cidade de Shego.")
    public Mono<ResponseEntity<Estabelecimento>> getEstabelecimento(@PathVariable String id) {
        return estabelecimentoRepository.findById(id)
                .map(estabelecimento -> ResponseEntity.ok(estabelecimento))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value ="salva um estabelecimentos, não possui campo obrigatório.")
    public Mono<Estabelecimento> saveEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }
	
	@PutMapping("{id}")
	@ApiOperation(value ="Metodo para realizar alteração de estabelecimentos.")
    public Mono<ResponseEntity<Estabelecimento>> updateEstabelecimento(@PathVariable(value = "id") String id, @RequestBody Estabelecimento estabelecimento) {
        return estabelecimentoRepository.findById(id)
                .flatMap(existingestabelecimento -> {
                	existingestabelecimento.setNome(estabelecimento.getNome());
                	existingestabelecimento.setRua(estabelecimento.getRua());
                	existingestabelecimento.setNumero(estabelecimento.getNumero());
                	existingestabelecimento.setCep(estabelecimento.getCep());
                	existingestabelecimento.setCidade(estabelecimento.getCidade());
                	existingestabelecimento.setTelefone(estabelecimento.getTelefone());
                	existingestabelecimento.setEmail(estabelecimento.getEmail());
                	existingestabelecimento.setSite(estabelecimento.getSite());            	
                	existingestabelecimento.setCategorias(estabelecimento.getCategorias());
                    return estabelecimentoRepository.save(existingestabelecimento);
                })
                .map(updateEstabelecimento -> ResponseEntity.ok(updateEstabelecimento))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }
    @DeleteMapping("{id}")
    @ApiOperation(value ="Metodo para deletar estabelecimentos por ID.")
    public Mono<ResponseEntity<Void>> deleteEstabelecimento(@PathVariable(value = "id") String id) {
        return estabelecimentoRepository.findById(id)
                .flatMap(existingestabelecimento ->
                estabelecimentoRepository.delete(existingestabelecimento)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    @ApiOperation(value ="Metodo para deletar todas as estabelecimentos cadastrada.")
    public Mono<Void> deleteAllEstabelecimento() {
        return estabelecimentoRepository.deleteAll();
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ApiOperation(value ="Metodo Stream de Eventos.")
    public Flux<ModelEvent> getAtracaoEvents() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(val ->
                        new ModelEvent(val, "Product Event")
                );
    }
}
