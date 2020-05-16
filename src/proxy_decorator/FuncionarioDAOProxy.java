package proxy_decorator;

import java.util.HashMap;
import java.util.Map;

public class FuncionarioDAOProxy implements FuncionarioDAOInterface {
	private Map<String,Funcionario> funcionarios;
	
	public FuncionarioDAOProxy() {
		super();
		this.funcionarios = new HashMap<>();
	}

	@Override
	public void addFuncionario(String cpf) throws FuncionarioException {
		this.funcionarios.put(cpf,new Funcionario(cpf));
		
	}

	@Override
	public Funcionario getFuncionario(String cpf) throws FuncionarioException {
		return funcionarios.get(cpf);
	}

}
