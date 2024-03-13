package br.edu.ifrs.pw1.tests;

import java.util.ArrayList;

import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.clientes.*;

public class Teste1 {
	public static void main(String[] args) {
		Endereco end1 = new Endereco();
		System.out.println(end1.toString());
		
		Endereco end2 = new Endereco("Rua X", "Casa 20", 91876540);
		System.out.println(end2.toString());
		
		ArrayList<Endereco> enderecos = new ArrayList<>();
		enderecos.add(end1);
		enderecos.add(end2);
		enderecos.add(new Endereco());
		enderecos.add(null);
		
		Cliente cliente = new Cliente("12142423", enderecos);
		System.out.println(cliente);
		
	}
}
