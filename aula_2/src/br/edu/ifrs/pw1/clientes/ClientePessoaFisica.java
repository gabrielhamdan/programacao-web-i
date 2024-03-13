package br.edu.ifrs.pw1.clientes;

import java.util.List;

import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.documentos.Cpf;

public class ClientePessoaFisica extends Cliente {
	private String nome;
	private Cpf cpf;
	
	public ClientePessoaFisica() {}

	public ClientePessoaFisica(String telefone, 
			List<Endereco> enderecos,
			String nome, Cpf cpf) {
		super(telefone, enderecos);
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nNome: " + nome + 
				(cpf != null ? cpf.toString() : "\nCPF inválido."); 
	}
	
}
