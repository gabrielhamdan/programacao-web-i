package br.edu.ifrs.pw1.documentos;

public class Cpf {
	private long numero;
	private int digito;
	
	public Cpf() {}
		
	public Cpf(long numero, int digito) {
		this.numero = numero;
		this.digito = digito;
	}

	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public int getDigito() {
		return digito;
	}
	public void setDigito(int digito) {
		this.digito = digito;
	}
	
	@Override
	public String toString() {
		return "\nCPF: " + numero + "-" + digito;
	}
	
}
