package fag.objeto;

import java.time.LocalDateTime;

public class Veiculo {
	private String placa;
	private String modelo;
	private String tamanho;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	
	public Veiculo(String placa, String modelo, String tamanho, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	public void registrarEntrada() {
		this.horaEntrada = LocalDateTime.now();
	}
	
	public void registrarSaida() {
		this.horaSaida = LocalDateTime.now();
	}
	
}
