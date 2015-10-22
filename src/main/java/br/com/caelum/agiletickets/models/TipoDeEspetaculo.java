package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA(0.05, 0.1, Integer.MAX_VALUE , 0), 
	SHOW(0.05, 0.1, Integer.MAX_VALUE, 0), 
	TEATRO(0, 0, Integer.MAX_VALUE, 0), 
	BALLET(0.50, 0.2, 60, 0.1),
	ORQUESTRA(0.50, 0.2, 60, 0.1);
	
	private double proporcaoMinima;
	private double adicionalProporcao;
	private int tempoMaximo;
	private double adicionalTempo;
	
	public double getProporcaoMinima() {
		return proporcaoMinima;
	}

	public double getAdicionalProporcao() {
		return adicionalProporcao;
	}

	public int getTempoMaximo() {
		return tempoMaximo;
	}

	public double getAdicionalTempo() {
		return adicionalTempo;
	}

	private TipoDeEspetaculo(double proporcaoMinima, double adicionalProporcao, int tempoMaximo, double adicionalTempo) {
		this.proporcaoMinima = proporcaoMinima;
		this.adicionalProporcao = adicionalProporcao;
		this.tempoMaximo = tempoMaximo;
		this.adicionalTempo = adicionalTempo;
	}
	
}
