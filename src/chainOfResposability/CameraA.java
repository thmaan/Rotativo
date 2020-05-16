package chainOfResposability;

import java.util.HashMap;
import java.util.Map;

public class CameraA extends RecuperarVeiculo {
	private Map<String, Veiculo> listaVeiculos = new HashMap<>();

	public CameraA(RecuperarVeiculo proximo) {
		super(proximo);
		listaVeiculos.put("Celta", new Veiculo("Celta", "01"));
	}

	@Override
	protected Veiculo recuperaVeiculo(String nome) {
		if(listaVeiculos.containsKey(nome))
			return listaVeiculos.get(nome);
		return null;
	}

}
