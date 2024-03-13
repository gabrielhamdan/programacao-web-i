package br.edu.ifrs.pw1.tests;

import java.util.ArrayList;

import br.edu.ifrs.pw1.clientes.ClientePessoaFisica;
import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.documentos.Cpf;

public class Teste2 {
	public static void main(String[] args) {
		ClientePessoaFisica cli1 = new ClientePessoaFisica();
		System.out.println(cli1.toString());
		
		Endereco end1 = new Endereco();
		System.out.println(end1.toString());
		
		Endereco end2 = new Endereco("Rua X", "Casa 20", 91876540);
		System.out.println(end2.toString());
		
		ArrayList<Endereco> enderecos = new ArrayList<>();
		enderecos.add(end1);
		enderecos.add(end2);
		enderecos.add(new Endereco());
		enderecos.add(null);
		ClientePessoaFisica cli2 = new ClientePessoaFisica(
				"21232423423", enderecos, "Fulano", null);
		System.out.println(cli2.toString());
		
		Cpf cpf = new Cpf(123456789, 99);
		ClientePessoaFisica cli3 = new ClientePessoaFisica(
				"21232423423", enderecos, "Fulano", cpf);
		System.out.println(cli3.toString());
		
	}
}
