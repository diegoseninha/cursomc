package life.senna11.cursomc.domain.enums;

import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa física"),
	PESSOAJURIDICA(2, "Pessoa jurídica");
	
	private int cod;
	private String descrição;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descrição = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descrição;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x: TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" + cod);
	}

}
