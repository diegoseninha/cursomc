package life.senna11.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import life.senna11.cursomc.domain.Cliente;
import life.senna11.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new life.senna11.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id +
				", Tipo: " + Cliente.class.getName()));
	}

}
