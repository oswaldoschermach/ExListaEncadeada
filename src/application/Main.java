package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<Funcionario>();

		System.out.print("Insira o numero de funcionarios a ser registrado: ");
		Integer n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.print("Funcionario " + (i + 1) + "\n");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.println("Id já existe! Tente de novo: ");
				id = sc.nextInt();
			}

			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();

			Funcionario funcionario = new Funcionario(nome, id, salario);
			list.add(funcionario);
		}

		System.out.print("Insira o ID do funcionário que tera o salario alterado: ");
		Integer findId = sc.nextInt();

		Funcionario funcionario = list.stream().filter(x -> x.getId() == findId).findFirst().orElse(null);

		if (funcionario != null) {
			System.out.print("Entre com a porcentagem: ");
			Double porcentagem = sc.nextDouble();
			funcionario.aumentaSalario(porcentagem);
		} else
			System.out.println("\nO funcionario não existe\n");

		System.out.println("\nLista de funcionarios");

		for (Funcionario f : list)
			System.out.println(f);

		sc.close();
	}

	public static boolean hasId(List<Funcionario> list, Integer id) {
		Funcionario funcionario = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}

}
