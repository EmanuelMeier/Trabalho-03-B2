package fag.objeto;

public class Vaga {
	private int numVaga;
	private String tamVaga;
	private boolean disponibilidade;
	
	public Vaga(int numVaga, String tamVaga, boolean disponibilidade) {
		this.numVaga = numVaga;
		this.tamVaga = tamVaga;
		this.disponibilidade = disponibilidade;
	}
	public int getNumVaga() {
		return numVaga;
	}
	public void setNumVaga(int numVaga) {
		this.numVaga = numVaga;
	}
	public String getTamVaga() {
		return tamVaga;
	}
	public void setTamVaga(String tamVaga) {
		this.tamVaga = tamVaga;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
    public void ocuparVaga() {
		this.setDisponibilidade(false);
	}
	
    public void liberarVaga() {
    	this.setDisponibilidade(true);
    }
}
