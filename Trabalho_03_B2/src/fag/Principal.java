package fag;

import java.util.Scanner;

import fag.objeto.Estacionamento;
import fag.objeto.Veiculo;

public class Principal {

	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Cadastro de vagas: ");
		System.out.println("Quantas vagas deseja cadastrar? ");
		int quantidadeVagas = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < quantidadeVagas; i++) {
			System.out.println("Número da vaga: ");
			int numVaga = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Tamanho da vaga (pequeno/medio/grande): ");
			String tamVaga = scanner.nextLine().toLowerCase();
			estacionamento.adicionarVaga(numVaga, tamVaga);
		}
		
		while (true) {
			System.out.println("\n1. Registrar entrada de veículo");
			System.out.println("2. Registrar saída de veículo");
			System.out.println("3. Gerar relatório de vagas ocupadas");
			System.out.println("4. Gerar histórico de permanência");
			System.out.println("5. Sair");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			
			case 1: 
				System.out.println("Placa do veículo: ");
				String placa = scanner.nextLine();
				System.out.println("Modelo do veículo: ");
				String modelo = scanner.nextLine();
				System.out.println("Tamanho do veículo (pequeno/médio/grande): ");
				String tamanho = scanner.nextLine().toLowerCase();
				
				Veiculo veiculo = new Veiculo(placa, modelo, tamanho, null, null);
				estacionamento.registrarEntradaVeiculo(veiculo);
				break;
				
			case 2: 
				System.out.println("Informe a placa do veículo para registrar a saída: ");
				String placaSaida = scanner.nextLine();
				estacionamento.registrarSaidaVeiculo(placaSaida);
				break;
			
			case 3:
				estacionamento.gerarRelatorioVagasOcupadas();
				break;
				
			case 4:
				estacionamento.gerarHistoricoPermanencia();
				break;
				
			case 5:
				System.out.println("Saindo do sistema.");
				scanner.close();
				return;
				
			default:
				System.out.println("Opção invalida! Tente novamento.");
				break;
			}
		}
	}

}
