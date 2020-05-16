package chainOfResposability;

import java.util.HashMap;
import java.util.Map;

public class CameraB extends RecuperarVeiculo {
	private Map<String, Veiculo> listaVeiculos = new HashMap<>();

	public CameraB(RecuperarVeiculo proximo) {
		super(proximo);
		listaVeiculos.put("Celta", new Veiculo("Celta", "01"));
		listaVeiculos.put("Onix", new Veiculo("Onix", "101"));
	}

	@Override
	protected Veiculo recuperaVeiculo(String nome) {
		if(listaVeiculos.containsKey(nome))
			return listaVeiculos.get(nome);
		return null;
	}

}
