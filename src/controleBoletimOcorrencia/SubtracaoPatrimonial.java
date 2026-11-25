package controleBoletimOcorrencia;

public class SubtracaoPatrimonial extends Ocorrencia {

	private String tipo;
	private String bemSubtraido;
	private double valorEstimado;
	
	public SubtracaoPatrimonial(int numero, String data, String hora, String local, String descricao,
			boolean possuiArma, String tipoArma, String tipo, String bemSubtraido, double valorEstimado) {
		
		super(numero, data, hora, local, descricao, possuiArma, tipoArma);
		
		this.tipo = tipo;
		this.bemSubtraido = bemSubtraido;
		this.valorEstimado = valorEstimado;
		
	}

	@Override
	public String gerarResumo() {
	    return "BO Nº: " + getNumero()
	         + "\nCategoria: Subtração Patrimonial"
	         + "\nTipo: " + tipo
	         + "\nBem subtraído: " + bemSubtraido
	         + "\nValor estimado: R$ " + valorEstimado
	         + "\nStatus: " + getStatus();
	}

	public String gettipo() {
	    return tipo;
	}

	public String getbemSubtraido() {
	    return bemSubtraido;
	}

	public double getvalorEstimado() {
	    return valorEstimado;
	}

	public void settipo(String tipo) {
	    this.tipo = tipo;
	}

	public void setbemSubtraido(String bemSubtraido) {
	    this.bemSubtraido = bemSubtraido;
	}

	public void setvalorEstimado(double valorEstimado) {
	    this.valorEstimado = valorEstimado;
	}
	

}
