package chainOfResposability;

public abstract class RecuperarVeiculo{
	private RecuperarVeiculo proximo;

	public RecuperarVeiculo(RecuperarVeiculo proximo) {
		super();
		this.proximo = proximo;
	}
	public Veiculo recuperar(String nome) {
		Veiculo v = recuperaVeiculo(nome);
		if(v == null)
			return chamarProximo(nome);
		else
			return v;
	}
	private Veiculo chamarProximo(String nome) {
		if(proximo == null)
			throw new RuntimeException("Nao encontramos o veiculo " + nome);
		return proximo.recuperar(nome);
	}
	protected abstract Veiculo recuperaVeiculo(String nome);
}
