package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		String nome;
		Integer id, qtdFuncionarios, idParaAumento, posicao = -1;
		Double salario;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe a quantidade de Funcionários: ");
		qtdFuncionarios = scan.nextInt();
		
		List<Funcionario> f = new ArrayList<Funcionario>();
		
		for (int i = 0; i < qtdFuncionarios; i++) {
			System.out.println("");
			
			System.out.print("ID: ");
			id = scan.nextInt();
			
			while (hasId(f, id)) {
				System.out.println("Este ID já existe! Tente novamente.");
				id = scan.nextInt();
			}
			
			System.out.print("Nome: ");
			nome = scan.next();
			
			System.out.print("Salário: ");;
			salario = scan.nextDouble();
			
			f.add(new Funcionario(id, nome, salario));
		}
		
		System.out.println("");
		System.out.println("--------------");
		System.out.println("");
		
		System.out.print("Informe o ID do funcionário para o aumento: ");
		idParaAumento = scan.nextInt();
		
		System.out.println("");
		System.out.println("--------------");
		System.out.println("");
		
		Funcionario f2 = f.stream().filter(el -> el.getId() == idParaAumento).findFirst().orElse(null);
//		posicao = posicaoId(f, idParaAumento);
		
		if (f2 != null) {
			System.out.print("Porcentagem a ser aumentada: ");
			double porcentagem = scan.nextDouble();
//			f.get(posicao).aumentaSalario(porcentagem);
			f2.aumentaSalario(porcentagem);
			
			System.out.println("");
			System.out.println("--------------");
			System.out.println("");
		}
		else {
			System.out.println("ID não encontrado.");
			System.out.println("");
		}

		for (Funcionario funcionario : f) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salário: " + funcionario.getSalario());
			System.out.println("");
		}
		
		scan.close();
	}
	
	public static int posicaoId(List<Funcionario> f, int posicao) {
		for (int i = 0; i < f.size(); i++) {
			if (f.get(i).getId() == posicao) {
				return posicao;
			}
		}
		return -1;
	}
	
	public static boolean hasId(List<Funcionario> f, int id) {
		Funcionario f1 = f.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
		return f1 != null;
	}
}
