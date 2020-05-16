package proxy_decorator;

public class FuncionarioDAODecorator implements FuncionarioDAOInterface {
	private static FuncionarioDAOInterface funcionarioDAO;
	
	private FuncionarioDAOInterface getDAO() {
		if(funcionarioDAO == null)
			funcionarioDAO = new FuncionarioDAOProxy();
		return funcionarioDAO;
	}
	private boolean cpfValido(String cpf) throws FuncionarioException {
		if(cpf == "100"){
			return true;
		}
		return false;
	}
	@Override
	public void addFuncionario(String cpf) throws FuncionarioException {
		if(!cpfValido(cpf))
			throw new FuncionarioException("CPF INVALIDO");
		getDAO().addFuncionario(cpf);
	}

	@Override
	public Funcionario getFuncionario(String cpf) throws FuncionarioException {
		if(!cpfValido(cpf))
			throw new FuncionarioException("CPF INVALIDO");
		Funcionario f = getDAO().getFuncionario(cpf);
		if(f == null)
			throw new FuncionarioException("Usuario N cadastrado");
		return f;
	}
}
