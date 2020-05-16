package chainOfResposability;

import java.util.HashMap;
import java.util.Map;

public class CameraC extends RecuperarVeiculo {
	private Map<String, Veiculo> listaVeiculos = new HashMap<>();

	public CameraC(RecuperarVeiculo proximo) {
		super(proximo);
		listaVeiculos.put("Onix", new Veiculo("Onix", "101"));
		listaVeiculos.put("Monza", new Veiculo("Monza", "200"));
	}

	@Override
	protected Veiculo recuperaVeiculo(String nome) {
		if(listaVeiculos.containsKey(nome))
			return listaVeiculos.get(nome);
		return null;
	}

}
