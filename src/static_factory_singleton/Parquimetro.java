package static_factory_singleton;

public class Parquimetro {
	private String numero;
	private String responsavel;
	private String seguradora;
	private static Parquimetro parquimetro;
	
	private Parquimetro(String numero) {
		this.numero = numero;
		this.responsavel = "";
		this.seguradora = "";
	}
	private Parquimetro(String numero, String responsavel) {
		this.numero = numero;
		this.responsavel = responsavel;
		this.seguradora = "";
	}
	private Parquimetro(String numero, String responsavel, String seguradora) {
		super();
		this.numero = numero;
		this.responsavel = responsavel;
		this.seguradora = seguradora;
	}

	public static Parquimetro criaNumero(String numero) {
		if(parquimetro != null) {
			parquimetro.setNumero(numero);
			return parquimetro;
		}
		if(!valida(numero))
			return null;
		return new Parquimetro(numero);
	}
	public static Parquimetro criaNumeroResponsavel(String numero, String responsavel) {
		if(parquimetro != null) {
			parquimetro.setNumero(numero);
			parquimetro.setResponsavel(responsavel);
			return parquimetro;
		}
		if(!valida(numero))
			return null;
		if (!valida(responsavel))
			return null;
		return new Parquimetro(numero,responsavel);
		
	}
	public static Parquimetro criaNumeroSeguradora(String numero, String seguradora) {
		if(parquimetro != null) {
			parquimetro.setNumero(numero);
			parquimetro.setSeguradora(seguradora);
			return parquimetro;
		}
		if(!valida(numero))
			return null;
		if (!valida(seguradora))
			return null;
		return new Parquimetro(numero,seguradora);
		
	}
	public static Parquimetro cria(String numero, String responsavel, String seguradora) {
		if(parquimetro != null) {
			parquimetro.setNumero(numero);
			parquimetro.setResponsavel(responsavel);
			parquimetro.setSeguradora(seguradora);
			return parquimetro;
		}
		if(!valida(numero))
			return null;
		if (!valida(responsavel))
			return null;
		if (!valida(seguradora))
			return null;
		return new Parquimetro(numero,responsavel, seguradora);
	}
	private static boolean valida(String texto) {
		if(texto.contains(" ")) 
			return false;
		return true;
	}
	public void setNumero(String numero) {
		if(!valida(numero))
			return;
		this.numero = numero;
	}
	public void setResponsavel(String responsavel) {
		if(!valida(responsavel))
			return;
		this.responsavel = responsavel;
	}
	public void setSeguradora(String seguradora) {
		if(!valida(seguradora))
			return;
		this.seguradora = seguradora;
	}

	public static void setParquimetro(Parquimetro parquimetro) {
		Parquimetro.parquimetro = parquimetro;
	}
	@Override
	public String toString() {
		return numero + " " + responsavel + " " + seguradora;
	}
}
