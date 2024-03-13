package br.edu.ifrs.pw1.menu;

public enum OpcaoCodigo {
	CADASTRA_CLIENTE(0),
	PESQUISA_CLIENTE_NOME(1),
	PESQUISA_CLIENTE_CPF(2),
	PESQUISA_CLIENTE_ENDERECO(3),
	LISTA_ALUNOS(4),
	ENCERRA_EXECUCAO(5),
	DEFAULT(6);

	private int codigo;
	
	OpcaoCodigo(int codigo) {
		this.codigo = codigo;
	}
}
