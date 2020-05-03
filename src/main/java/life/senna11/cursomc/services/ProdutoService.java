package life.senna11.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import life.senna11.cursomc.domain.Categoria;
import life.senna11.cursomc.domain.Produto;
import life.senna11.cursomc.repositories.CategoriaRepository;
import life.senna11.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id){
		Optional<Produto> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new life.senna11.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id +
				", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linePerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}
