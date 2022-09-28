package test.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hepta.funcionarios.entity.Funcionario;

public class TestUtil {

	public static WebTarget target(String uri, String local) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(UriBuilder.fromUri(uri+local).build());
	}
	
	public static Funcionario ultimoAdicionado(String responseAsString) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		Funcionario[] funcionarios = objectMapper.readValue(responseAsString, Funcionario[].class);

			
		ArrayList<Funcionario> funcionariosLista = new ArrayList<Funcionario>(Arrays.asList(funcionarios));
		
		Funcionario funcionario = new Funcionario();
		long higher = 0;
		
		for(Funcionario f : funcionariosLista) {
			if(f.getId() > higher) {
				higher = f.getId();
			}
		}
		
		for(Funcionario f : funcionariosLista) {
			if(f.getId() == higher) {
				funcionario.setEmail(f.getEmail());
				funcionario.setId(f.getId());
				funcionario.setIdade(f.getIdade());
				funcionario.setNome(f.getNome());
				funcionario.setSetor(f.getSetor());
				funcionario.setSalario(f.getSalario());
			}
		}
		
		return funcionario;
	}
}