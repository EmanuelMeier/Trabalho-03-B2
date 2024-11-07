package fag.objeto;

import java.util.ArrayList;
import fag.objeto.Vaga;
import fag.objeto.Veiculo;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Estacionamento {
	public List<Vaga> vagas = new ArrayList<>();
	public List<Veiculo> veiculos = new ArrayList();
	
	public void adicionarVaga(int numVaga, String tamVaga) {
		vagas.add(new Vaga(numVaga, tamVaga, true));
	}
	
	public void registrarEntradaVeiculo(Veiculo veiculo) {
		for (Vaga vaga : vagas) {
			if (vaga.isDisponibilidade() && vaga.getTamVaga().equalsIgnoreCase(veiculo.getTamanho())) {
				vaga.ocuparVaga();
				veiculo.registrarEntrada();
				veiculo.registrarEntrada();
				veiculos.add(veiculo);
				System.out.println("Veiculo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getNumVaga());
				return;
			}
		}
		System.out.println("Nenhuma vaga disponivel para esse tamanho!");
	}
	
	public void registrarSaidaVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa) && veiculo.getHoraSaida() == null) {
				veiculo.registrarSaida();
				long minutos = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida()).toMinutes();
				double valorPago = calcularValor(minutos);
				
				for (Vaga vaga : vagas) {
					if(!vaga.isDisponibilidade()) {
						vaga.liberarVaga();
						break;
					}
				}
				
				System.out.println("Veículo " + veiculo.getPlaca() + " saiu. Tempo de permanência: "  + 
				minutos + " minutos. Valor a pagar R$" + valorPago);
				return;
			}
		}
		System.out.println("Veículo não foi encontrado ou já saiu.");
	}
	
	public double calcularValor(long minutos) {
		if (minutos <= 60) return 5.0;
		if (minutos <= 180) return 10.0;
		return 15.0;
	}
	
	public void gerarRelatorioVagasOcupadas() {
		System.out.println("Relatório de vagas ocupadas: ");
		for (Vaga vaga : vagas) {
			if (!vaga.isDisponibilidade()) {
				System.out.println("Vaga: " + vaga.getNumVaga() + ", Tamanho: " + vaga.getTamVaga());
			}
		}
	}
	
	  public void gerarHistoricoPermanencia() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	        System.out.println("Histórico de Permanência dos Veículos:");
	        for (Veiculo veiculo : veiculos) {
	            if (veiculo.getHoraSaida() != null) {
	                long minutos = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida()).toMinutes();
	                double valorPago = calcularValor(minutos);

	                System.out.println("Veículo: " + veiculo.getPlaca() +
	                        ", Entrada: " + veiculo.getHoraEntrada().format(formatter) +
	                        ", Saída: " + veiculo.getHoraSaida().format(formatter) +
	                        ", Tempo de permanência: " + minutos + " minutos, Valor pago: R$" + valorPago);
	            }
	        }
	    }
}
