package life.senna11.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import life.senna11.cursomc.domain.Pedido;
import life.senna11.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido busca(Integer id){
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new life.senna11.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id +
				", Tipo: " + Pedido.class.getName()));
	}

}
