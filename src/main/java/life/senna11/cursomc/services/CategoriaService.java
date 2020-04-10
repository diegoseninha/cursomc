package life.senna11.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import life.senna11.cursomc.domain.Categoria;
import life.senna11.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria busca(Integer id){
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new life.senna11.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id +
				", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
