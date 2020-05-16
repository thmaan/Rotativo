package chainOfResposability;

public class Veiculo {
	private String nome;
	private String vaga;
	
	public Veiculo(String nome, String vaga) {
		super();
		this.nome = nome;
		this.vaga = vaga;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

}
