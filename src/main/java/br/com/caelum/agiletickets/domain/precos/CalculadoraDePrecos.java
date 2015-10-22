package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = BigDecimal.ZERO;		
		BigDecimal precoSessao = sessao.getPreco();
		
		Integer totalIngressos = sessao.getTotalIngressos();
		Integer ingressosReservados = sessao.getIngressosReservados();
		int diffIngressos = totalIngressos - ingressosReservados;
		
		Integer duracaoEmMinutos = sessao.getDuracaoEmMinutos();
		if (duracaoEmMinutos == null) {
			duracaoEmMinutos = new Integer(0);
		}
		
		double proporcaoIngressos = diffIngressos / totalIngressos.doubleValue();
		
		TipoDeEspetaculo tipoEspetaculo = sessao.getEspetaculo().getTipo();
		double proporcaoMinima = tipoEspetaculo.getProporcaoMinima();
		double adicionalProporcao = tipoEspetaculo.getAdicionalProporcao();
		int tempoMaximo = tipoEspetaculo.getTempoMaximo();
		double adicionalTempo = tipoEspetaculo.getAdicionalTempo();
		
		preco = calculaAdicionalPorProporcao(proporcaoIngressos, precoSessao, preco, proporcaoMinima, adicionalProporcao);				
		preco = preco.add(calculaAdicionalPorTempo(duracaoEmMinutos, precoSessao, tempoMaximo, adicionalTempo));

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
	
	private static BigDecimal calculaAdicionalPorProporcao(double proporcaoIngressos, BigDecimal precoSessao, BigDecimal preco, double proporcaoMinima, double adicionalProporcao) {
		if(proporcaoIngressos <= proporcaoMinima) {
			return precoSessao.add(precoSessao.multiply(BigDecimal.valueOf(adicionalProporcao)));
		} 
		return preco = precoSessao;
	}

	private static BigDecimal calculaAdicionalPorTempo(Integer duracaoEmMinutos, BigDecimal precoSessao, int tempoMaximo, double adicionalTempo) {
		if(duracaoEmMinutos > tempoMaximo){
			return precoSessao.multiply(BigDecimal.valueOf(adicionalTempo));
		}
		return BigDecimal.ZERO;
	}

}