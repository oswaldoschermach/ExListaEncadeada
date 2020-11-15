package entities;

public class Funcionario {
	private String nome;
	private Integer id;
	private Double salario;
	
	@Override
	public String toString() {
		return "\nFuncionario \nnome: " + nome + "\nid: " + id + "\nsalario: " + salario;
	}

	public Funcionario() {
		
	}
	
	public Funcionario(String nome, Integer id, Double salario) {
		super();
		this.nome = nome;
		this.id = id;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSalario() {
		return salario;
	}
	
	public void aumentaSalario(Double porcentagem) {
		salario += salario * (porcentagem / 100);
	}
	
}
