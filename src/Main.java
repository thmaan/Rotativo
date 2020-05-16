import chainOfResposability.CameraA;
import chainOfResposability.CameraB;
import chainOfResposability.CameraC;
import chainOfResposability.RecuperarVeiculo;
import chainOfResposability.Veiculo;
import composite.VagaComposta;
import composite.VagaSimples;
import composite.VagasPorSetor;
import proxy_decorator.Funcionario;
import proxy_decorator.FuncionarioDAODecorator;
import proxy_decorator.FuncionarioDAOInterface;
import proxy_decorator.FuncionarioException;
import static_factory_singleton.Parquimetro;

public class Main {

	public static void main(String[] args) {
		
		String veiculo = "Qualquer Veiculo";
		
		//composite pattern: O estacionamento troca seu veiculo de vaga, cobra uma taxa por isso. 
		VagasPorSetor simplesA = new VagaSimples(veiculo, "01", "01", 50);
		VagasPorSetor simplesB = new VagaSimples(veiculo, "02", "02", 100);
		VagasPorSetor simplesC = new VagaSimples(veiculo, "03", "03", 500);
		VagasPorSetor simplesD = new VagaSimples(veiculo, "04", "04", 500);
		
		VagaComposta compostoA = new VagaComposta(simplesA, simplesB, 10);
		VagaComposta compostoB = new VagaComposta(compostoA, simplesC, 10);
		VagaComposta compostoC = new VagaComposta(compostoB, simplesD, 10);
		
		System.out.println(veiculo);
		System.out.println(compostoC);
		System.out.println("Preco: "+ compostoC.getPreco());
		
		//chain of respo: Queremos encontrar o veiculo atraves da cameraA, camera B e cameraC. Usamos cameras diferentes devido ao campo de visao de cada uma. 
		try {
			RecuperarVeiculo veiculos = new CameraA(new CameraB(new CameraC(null)));
			Veiculo celta  = veiculos.recuperar("Celta");
			Veiculo onix  = veiculos.recuperar("Onix");
			Veiculo monza = veiculos.recuperar("Monza");
			
			System.out.println(celta.getNome() + " na vaga: " + celta.getVaga());
			System.out.println(onix.getNome() + " na vaga: " + onix.getVaga());
			System.out.println(monza.getNome() + " na vaga: " + monza.getVaga());
		}catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
		//proxy and decorator: O decorator adiciona uma verificacao de cpf no funcionario. O proxy retorna o funcionario cadastrado
		
		FuncionarioDAOInterface funcionarioDAO = new FuncionarioDAODecorator(); 
		
		try {
			funcionarioDAO.addFuncionario("100");
		}catch (FuncionarioException ex) {
			System.err.println(ex.getMessage());
		}
		try {
			Funcionario f = funcionarioDAO.getFuncionario("100");
			System.out.println("CPF DO FUNCIONARIO: "+ f.getCpf());
		}catch (FuncionarioException ex) {
			System.err.println(ex.getMessage());
		}
		try {
			funcionarioDAO.addFuncionario("");
		}catch (FuncionarioException ex) {
			System.err.println(ex.getMessage());
		}
		//single fabric methods: criar um objeto de uma forma diferente, fazendo a validação de dados no construtor(privado) através de methods publicos estaticos
		//singleton: parquimetro != null se existir atualiza, se nao cria
		System.out.println(Parquimetro.criaNumero("1").toString());
		System.out.println(Parquimetro.criaNumeroResponsavel("2", "Thomas").toString());
		System.out.println(Parquimetro.criaNumeroSeguradora("3","sEGUROS").toString());
	}
}
