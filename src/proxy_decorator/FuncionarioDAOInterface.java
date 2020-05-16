package proxy_decorator;

public interface FuncionarioDAOInterface  {
	
	public void addFuncionario(String cpf) throws FuncionarioException;

	public Funcionario getFuncionario(String cpf) throws FuncionarioException;
}
