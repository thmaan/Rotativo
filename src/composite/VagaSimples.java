package composite;



public class VagaSimples implements VagasPorSetor {
	private String veiculo;
	private String vagaInicial;
	private String vagaFinal;
	private double preco;
	
	

	public VagaSimples(String veiculo, String vagaInicial, String vagaFinal, double preco) {
		super();
		this.veiculo = veiculo;
		this.vagaInicial = vagaInicial;
		this.vagaFinal = vagaFinal;
		this.preco = preco;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public String getVagaInicial() {
		return vagaInicial;
	}
	public String getVagaFinal() {
		return vagaFinal;
	}
	public double getPreco() {
		return preco;
	}
	@Override
	public String toString() {
		return "Vaga Inicial: " + vagaInicial + " Vaga Final: " + vagaFinal;
	}
}
