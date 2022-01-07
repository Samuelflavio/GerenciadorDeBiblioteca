package sistema;

import java.util.Scanner;

import registros.*;
import dados.*;

public class Main {
	
	public static Scanner tc = new Scanner(System.in);
	private static Rlivro rL;
	private static Rcliente rC;
	
	private static void adicionaCliente() {
		String nome, telefone;
		Cliente c;
		System.out.println("==> Adicionar cliente:\n");
		System.out.println("Nome: ");
		nome = tc.nextLine();
		System.out.print("Telefone: ");
		telefone = tc.nextLine();
		
		c = new Cliente(nome, telefone);
		rC.addCliente(c);
	}
	private static void adicionaLivro() {
		String titulo, autor;
		double valor;
		Livros l;
		System.out.println("==> Adicionar Livro:\n");
		System.out.print("Titulo: ");
		titulo = tc.nextLine();
		System.out.print("Autor: ");
		autor = tc.nextLine();
		System.out.print("Valor: ");
		valor = tc.nextDouble();
		
		l = new Livros(titulo, autor, valor);
		rL.addLivros(l);
	}
	private static void listarLivrosLivres() {
		System.out.println("[( Lista de livros Disponiveis! )]");
		System.out.println("Nr Registro\t titulo\t autor\t valor");
		for (int i = 0; i < rL.size(); i++) {
			Livros l = rL.getLivro(i);
			if(l.getDataEmprestimo()==null) {
				System.out.printf ("%s\t %s\t %s\t %s\t\n",
						l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor());
			}
			
		}
	}

	private static void listarTodosClientes() {
		System.out.println("=== Lista de Clientes ===");
		System.out.println("Cod\t Nome\t\t\t Telefone" );
		for (int i = 0; i < rC.size(); i++) {
			Cliente c = rC.getCliente(i);
			System.out.printf ("%s\t %s\t\t  %s\n",
					c.getCodigoDoCliente(), c.getNome(), c.setTelefone());
			}
	}
	
	private static void listarTodosLivros() {
		System.out.println("=== Lista de livros disponiveis ===");
		System.out.println("Cod\t Titulo\t\t\t Autor\t\t Valor\t\t Situacao\t\t Colega" );
		for (int i = 0; i < rL.size(); i++) {
			Livros l = rL.getLivro(i);
			if(l.getDataEmprestimo()==null){
			System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t Livro Disponivel\n",
					l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor());
			}
			else{
			System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t %s\n",
						l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor(), l.getClienteComLivro());
			}
		}
	}
	
	private static void emprestarLivro() {
		boolean flag=false;
		boolean flagCliente=false;
		int cod;
		int codCliente;
		System.out.print("Digite o codigo do livro a ser emprestado:");
		cod = tc.nextInt();
		tc.nextLine();
		Main.listarTodosClientes();
		System.out.println();
		System.out.print("Digite o codigo do cliente:");
		codCliente = tc.nextInt();
		tc.nextLine();
		for (int i = 0; i < rC.size(); i++) {
			Cliente cliente = rC.getCliente(i);
			if(cliente.getCodigoDoCliente()==codCliente){
			flagCliente=true;
			for (int i1 = 0; i1 < rL.size(); i1++) {
				Livros l = rL.getLivro(i1);
				if(l.getCodigoDoLivro()==cod&&l.getDataEmprestimo()==null){
				rL.emprestaLivro(l,cliente);
				System.out.println("livro codigo "+l.getCodigoDoLivro()+" emprestado com sucesso para o cliente: " + cliente.getNome() + ".");
				System.out.println("Data de emprestimo: "+l.getDataEmprestimo());
				flag=true;
				}
			}
			if(flag==false){
				System.out.println("Livro não encontrado ou já emprestado.");
			}
			}
		}
		if(flagCliente==false){
			System.out.println("Cliente não encontrado.");
		}
		
		
	}
	
	private static void devolverLivro() {
		boolean flag=false;
		int cod;
		System.out.print("Digite o codigo do livro a ser devolvido:");
		cod = tc.nextInt();
		tc.nextLine();
		for (int i = 0; i < rL.size(); i++) {
			Livros l = rL.getLivro(i);
			if(l.getCodigoDoLivro()==cod){
			l.setDataEmprestimo(null);
			flag=true;
			System.out.println("livro codigo "+l.getCodigoDoLivro()+" devolvido com sucesso.");
			}
		}
		if(flag==false){
			System.out.println("Livro não encontrado.");
		}
	}
	
	private static void listarLivrosAZ() {
		rL.ordenaTituloAZ();
		
	}
	
	public static void main(String[] args) {

		rL = new Rlivro();
		rC = new Rcliente();
		
		Livros l1 = new Livros ("Programacao Java I", "Jose da Silva", 98.50);
		Livros l2 = new Livros ("Calculo II", "Marina Golvea", 150.00);
		Livros l3 = new Livros ("Eletricidade Aplicada II", "Alexandre Timbu", 60.80);
		Livros l4 = new Livros ("Microeletronica II", "Luis Amaro", 52.99);
		Livros l5 = new Livros ("Arquitetura de Processadores", "Mateus Budista", 180.00);
		rL.addLivros(l1);
		rL.addLivros(l2);
		rL.addLivros(l3);
		rL.addLivros(l4);
		rL.addLivros(l5);
		Cliente c1 = new Cliente ("Amarildo Silva", "41996635285");
		Cliente c2 = new Cliente ("Jose dos Santos", "4198574525");
		Cliente c3 = new Cliente ("Isabela Amaral", "41986325412");
		Cliente c4 = new Cliente ("Bruna de Oliveira","41997456328");
		rC.addCliente(c1);
		rC.addCliente(c2);
		rC.addCliente(c3);
		rC.addCliente(c4);
		
		
		
		int op;
		do {
			System.out.println("\n==> Menu:\n");
			System.out.println("0 - sair");
			System.out.println("1 - adiciona livro");
			System.out.println("2 - adiciona cliente");
			System.out.println("3 - emprestar livro");
			System.out.println("4 - devolver livro");
			System.out.println("5 - listar livros por ordem alfabetica");
			System.out.print("\n Opcao: ");
			op = tc.nextInt();
			tc.nextLine(); 

			switch (op) {
			case 0: 
				System.out.println("Saindo..."); 
			case 1:
				adicionaLivro();
				break;
			case 2:
				adicionaCliente();
				break;
			case 3:
				listarLivrosLivres();
				emprestarLivro();
				break;
			case 4:
				devolverLivro();
				break;
			case 5:
				listarLivrosAZ();
				listarTodosLivros();
				break;	
			default:
				System.out.println("Opcao invalida!\n\n");
				break;
			}
		} while (op != 0);
		
	}
	
}
	


