package br.edu.ifrs.pw1.menu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.ifrs.pw1.clientes.ClientePessoaFisica;
import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.documentos.Cpf;

public class Menu {

	private static ArrayList<ClientePessoaFisica> clientes = new ArrayList<ClientePessoaFisica>();
	
	public static void main(String[] args) {
		exibeMenu();
	}

	public static void exibeMenu() {
		while (true) {
			switch(montaMenu()) {
				case CADASTRA_CLIENTE:
					cadastraCliente();
					break;
				case PESQUISA_CLIENTE_NOME:
					pesquisaClienteNome();
					break;
				case PESQUISA_CLIENTE_CPF:
					pesquisaClienteCpf();
					break;
				case PESQUISA_CLIENTE_ENDERECO:
					pesquisaClienteEndereco();
					break;
				case LISTA_ALUNOS:
					listaClientes();
					break;
				case ENCERRA_EXECUCAO:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
	
	private static OpcaoCodigo montaMenu() {
		String menu =
			"1. Cadastrar Cliente Pessoa Física\n" +
			"2. Pesquisar Cliente Pessoa Física pelo nome\n" +
			"3. Pesquisar Cliente Pessoa Física pelo CPF\n" +
			"4. Pesquisar Cliente Pessoa Física pelo endereço\n" +
			"5. Listar todos os clientes\n" +
			"6. Sair\n";
		
		String jOption = JOptionPane.showInputDialog(menu);
		int option = Integer.parseInt(jOption.equals("") ? "-1" : jOption);
		OpcaoCodigo opcaoCodigo = option > 0 && option < 7 ? OpcaoCodigo.values()[option - 1] : OpcaoCodigo.DEFAULT;
		return opcaoCodigo;
	}

	private static void cadastraCliente() {
		String nome = JOptionPane.showInputDialog("Informe o nome: ");
		long numCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF: "));
		int digCpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o dígito do CPF: "));
		Cpf cpf = new Cpf(numCpf, digCpf);
		String telefone = JOptionPane.showInputDialog("Informe o telefone: ");
		ArrayList<Endereco> enderecos = cadastraEndereco();
		clientes.add(new ClientePessoaFisica(telefone, enderecos, nome, cpf));
	}
	
	private static ArrayList<Endereco> cadastraEndereco() {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		while(true) {
			String logradouro = JOptionPane.showInputDialog("Informe o logradouro: ");
			String complemento = JOptionPane.showInputDialog("Informe o complemento: ");
			long cep = Long.parseLong(JOptionPane.showInputDialog("Informe o CEP: "));
			Endereco endereco = new Endereco(logradouro, complemento, cep);
			enderecos.add(endereco);
			
			if(!JOptionPane.showInputDialog("Adicionar outro endereço [S/n]: ").toLowerCase().equals("s"))
				break;			
		}
		
		return enderecos;
	}

	private static void pesquisaClienteNome() {
		String nome = JOptionPane.showInputDialog("Informe o nome: ");
		ClientePessoaFisica clientePesquisado = null;
		
		for(ClientePessoaFisica cliente : clientes)
			if(cliente.getNome().equals(nome)) {
				clientePesquisado = cliente;
				break;
			}
		
		String msg = clientePesquisado == null ? "Cliente não encontrado!" : clientePesquisado.toString();
		JOptionPane.showMessageDialog(null, msg);
	}

	private static void pesquisaClienteCpf() {
		long numCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF: "));
		int digCpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o dígito do CPF: "));
		ClientePessoaFisica clientePesquisado = null;
		
		for(ClientePessoaFisica cliente : clientes)
			if(cliente.getCpf() != null && cliente.getCpf().getNumero() == numCpf && cliente.getCpf().getDigito() == digCpf) {
				clientePesquisado = cliente;
				break;
			}
		
		String msg = clientePesquisado == null ? "Cliente não encontrado!" : clientePesquisado.toString();
		JOptionPane.showMessageDialog(null, msg);
	}

	private static void pesquisaClienteEndereco() {
		String enderecoPesquisado = JOptionPane.showInputDialog("Informe o endereço: ");
		ArrayList<ClientePessoaFisica> clientesEndereco = new ArrayList<ClientePessoaFisica>();
		
		for(ClientePessoaFisica cliente : clientes)
			for(Endereco endereco : cliente.getEnderecos())
				if(enderecoPesquisado.equals(endereco.getLogradouro()))
					clientesEndereco.add(cliente);
				
		for(ClientePessoaFisica cliente : clientesEndereco)
			JOptionPane.showMessageDialog(null, cliente.toString());
	}

	private static void listaClientes() {
		for(ClientePessoaFisica cliente : clientes)
			JOptionPane.showMessageDialog(null, cliente.toString());
	}

}
