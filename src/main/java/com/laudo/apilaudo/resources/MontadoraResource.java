package com.laudo.apilaudo.resources;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.laudo.apilaudo.models.Montadora;
import com.laudo.apilaudo.repository.MontadoraRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
@Api(value="API REST Montadoras")
@CrossOrigin(origins="*")
public class MontadoraResource {
	
	@Autowired
	MontadoraRepository montadoraRepository;
	
	@GetMapping("/montadoras")
	@ApiOperation(value="Retorna uma lista das montadoras")
	public List<Montadora> listaMontadora() {
		return montadoraRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma lista das montadoras pelo id")
	@GetMapping("/montadoras/{id}")
	public Montadora listaMontadoraById(@PathVariable(value="id") long id) {
		return montadoraRepository.findById(id);
	}
	
	@ApiOperation(value="Salva uma montadora")
	@PostMapping("/montadoras")
	public Montadora salvaMontadora(@RequestBody Montadora montadora) {
		return montadoraRepository.save(montadora);
	}
	
	@ApiOperation(value="Deleta uma montadora")
	@DeleteMapping("/montadoras")
	public void deleteMontadora(@RequestBody Montadora montadora) {
		montadoraRepository.delete(montadora);
	}
	
	@ApiOperation(value="Atualiza uma montadora")
	@PutMapping("/montadoras")
	public Montadora updateMontadora(@RequestBody Montadora montadora) {
		return montadoraRepository.save(montadora);
	}
	
	@GetMapping("/teste")
	@ApiOperation(value="Método teste")
	public void teste() {

		final String uri = "http://gturnquist-quoters.cfapps.io/api/random";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
}
