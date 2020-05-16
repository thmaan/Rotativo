package composite;


public class VagaComposta implements VagasPorSetor{
	
	private VagasPorSetor primeiraVaga;
	private VagasPorSetor segundaVaga;
	private double taxaMudanca;


	public VagaComposta (VagasPorSetor primeiraVaga, VagasPorSetor segundaVaga, double taxaMudanca) {
		super();

		this.primeiraVaga = primeiraVaga;
		this.segundaVaga = segundaVaga;
		this.taxaMudanca = taxaMudanca;
		if(primeiraVaga.getVagaFinal().contentEquals(segundaVaga.getVagaInicial())) 
			throw new RuntimeException("O veiculo nao ocupou diferentes vagas");	
	}

	@Override
	public String getVagaInicial() {
		return primeiraVaga.getVagaInicial();
	}

	@Override
	public String getVagaFinal() {
		return segundaVaga.getVagaFinal();
	}

	@Override
	public double getPreco() {
		return primeiraVaga.getPreco() + segundaVaga.getPreco() + taxaMudanca;
	}
	@Override
	public String toString() {
		return primeiraVaga.toString() + "\n" + segundaVaga.toString() ;
	}
}
