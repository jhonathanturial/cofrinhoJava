package Uninter;

import java.util.Scanner;

public class Menu {
	
	private Scanner sc;
	private Cofrinho cofrinho;
	
	public Menu(){
		sc = new Scanner(System.in);
		cofrinho = new Cofrinho();
	}
	
	public void MenuPrincipal() {
		// Exibe o menu principal 
		System.out.println("COFRINHO");
		System.out.println("1-Adicionar Moeda");
		System.out.println("2-Remover Moeda");
		System.out.println("3-Listar Moedas");
		System.out.println("4-Calcular total convertido para Real");
		System.out.println("0-Encerrar");
		
		// Obtém a opção selecionada pelo usuário
		String opcaoSelecionada = sc.next();
		
		// Verifica a opção selecionada pelo usuário
		switch (opcaoSelecionada) {
			case "0":
				// Caso a opção seja 0, exibe uma mensagem de encerramento
				System.out.println("Sistema Encerrado!");
				break;
				
			case "1":
				// Caso a opção seja 1, exibe o submenu para adicionar moeda e depois volta ao menu principal
				exibirSubMenuAdicionarMoeda();
				MenuPrincipal();	 
				break;
				
			case "2":
				// Caso a opção seja 2, exibe o submenu para remover moeda e depois volta ao menu principal
				exibirSubMenuRemoverMoeda();
				MenuPrincipal();
				break;
				
			case "3":
				// Caso a opção seja 3, lista todas as moedas no cofrinho e depois volta ao menu principal
				cofrinho.listagemMoedas();
				MenuPrincipal();
				break;
				
			case "4":
				// Caso a opção seja 4, calcula o valor total convertido para Real, exibe o resultado e depois volta ao menu principal
				double TotalConvertido = cofrinho.totalConvertido();
				String valorTotalConvertidoTextual = String.format("%.2f", TotalConvertido);
				valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
				System.out.println("O valor total convertido para real é: " + valorTotalConvertidoTextual);
				MenuPrincipal();
				break;
				
			default:
				// Caso a opção seja inválida, exibe uma mensagem de erro e volta ao menu principal
				System.out.println("Opção inválida!");
				MenuPrincipal();
				break;
		}
	}
	
	private void exibirSubMenuAdicionarMoeda() {
		// Exibe o submenu para adicionar moedas 
		System.out.println("Escolha a Moeda:");
		System.out.println("1 - Real");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");
		
		// Obtém a opção de moeda selecionada pelo usuário
		int opcaoMoeda = sc.nextInt();
		
		// Solicita ao usuário que digite o valor da moeda
		System.out.println("Digite o valor:");
		String valorTextualMoeda = sc.next(); 
		
		// Realiza algumas manipulações para tratar a entrada do usuário e converter o valor em double
		valorTextualMoeda = valorTextualMoeda.replace(",", ".");
		double valorMoeda = Double.valueOf(valorTextualMoeda);
		
		// Verifica a opção de moeda selecionada pelo usuário 
		switch (opcaoMoeda) {
			case 1:
				// Caso a opção seja 1, cria um objeto da classe Real com o valor informado e adiciona ao cofrinho
				Real moedaReal = new Real(valorMoeda);
				cofrinho.adicionar(moedaReal);
				break;
			case 2:
				// Caso a opção seja 2, cria um objeto da classe Dolar com o valor informado e adiciona ao cofrinho
				Dolar moedaDolar = new Dolar(valorMoeda);
				cofrinho.adicionar(moedaDolar);
				break;
			case 3:
				// Caso a opção seja 3, cria um objeto da classe Euro com o valor informado e adiciona ao cofrinho
				Euro moedaEuro = new Euro(valorMoeda);
				cofrinho.adicionar(moedaEuro);
				break;
			default:
				// Caso a opção seja inválida, exibe uma mensagem de erro
				System.out.println("Não existe essa moeda!");
				break;
		}
		
		System.out.println("Moeda adicionada!");
	}
	
	private void exibirSubMenuRemoverMoeda() {
		// Exibe o submenu para remover moedas
		System.out.println("Escolha a Moeda:");
		System.out.println("1 - Real");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");
		
		// Obtém a opção de moeda selecionadas
		int opcaoMoeda = sc.nextInt();
		
		// Solicita ao usuário que digite o valor da moeda
		System.out.println("Digite o valor:");
		String valorTextualMoeda = sc.next(); 
		
		// Realiza algumas manipulações para tratar a entrada do usuário e converter o valor em double
		valorTextualMoeda = valorTextualMoeda.replace(",", ".");
		double valorMoeda = Double.valueOf(valorTextualMoeda);
		

		switch (opcaoMoeda) {
			case 1:
				// Caso a opção seja 1, cria um objeto da classe Real com o valor informado
				
				Real moedaReal = new Real(valorMoeda);
				// Tenta remover a moeda do cofrinho e armazena o resultado em uma variável booleana
				
				boolean removeuMoedaReal = cofrinho.remover(moedaReal);
				
				if (removeuMoedaReal) {
					System.out.println("Moeda removida com sucesso!");
				} else {
					System.out.println("Não foi encontrada nenhuma moeda com esse valor");
				}
				break;
			case 2:
				// Caso a opção seja 2, cria um objeto da classe Dolar com o valor informado
				
				Dolar moedaDolar = new Dolar(valorMoeda);
				
				// Tenta remover a moeda do cofrinho e armazena o resultado em uma variável booleana
				
				boolean removeuMoedaDolar = cofrinho.remover(moedaDolar);
				
				if (removeuMoedaDolar) {
					System.out.println("Moeda removida com sucesso!");
				} else {
					System.out.println("Não foi encontrada nenhuma moeda com esse valor");
				}
				break;
			case 3:
				// Caso a opção seja 3, cria um objeto da classe Euro com o valor informado
				
				Euro moedaEuro = new Euro(valorMoeda);
				
				// Tenta remover a moeda do cofrinho e armazena o resultado em uma variável booleana
				
				boolean removeuMoedaEuro = cofrinho.remover(moedaEuro);
				
				if (removeuMoedaEuro) {
					System.out.println("Moeda removida com sucesso!");
				} else {
					System.out.println("Não foi encontrada nenhuma moeda com esse valor");
				}
				break;
			default:
				// Caso a opção seja inválida, exibe uma mensagem de erro
				System.out.println("Não existe essa moeda!");
				break;
		}
	}
	
	public static void main(String[] args) {
		
		// Cria uma instância do Menu e exibe o menu principal para iniciar a interação com o usuário
		
		Menu menu = new Menu();
		menu.MenuPrincipal();
		
		// ALUNO: Jhonathan Turial
		// RU: 3993727
	}
}
