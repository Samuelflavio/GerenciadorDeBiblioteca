package dados;

public class Cliente {
	private String nome, telefone;
	private static int codC1=1;
	private int codigoDoCliente;
	
	public Cliente(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.codigoDoCliente = codC1;
		codC1++;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String setTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getCodigoDoCliente() {
		return codigoDoCliente;
	}

}
