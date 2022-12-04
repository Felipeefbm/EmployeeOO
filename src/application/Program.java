package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.print("Dia do pagamento: ");
		int diaPg = sc.nextInt();
		
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		
		Department dept = new Department(nomeDepartamento, diaPg, new Address(email, telefone));
		
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do funcionario " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Employee employees = new Employee(nome, salario);
			dept.addEmployee(employees);
			
			System.out.println();
		}
		
		
		showReport(dept);
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.println("Departamento" + dept.getName() + " = R$" + String.format("%.2f",dept.payroll()) );
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		System.out.print(dept);
		System.out.println("para duvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}

}
