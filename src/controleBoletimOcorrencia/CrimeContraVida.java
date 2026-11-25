package controleBoletimOcorrencia;

public class CrimeContraVida extends Ocorrencia {
	
	private String tipo;
    private int quantidadeVitimasFatais;
    
	public CrimeContraVida(int numero, String data, String hora, String local, String descricao, boolean possuiArma,
			String tipoArma, String tipo, int quantidadeVitimasFatais) {
		
		super(numero, data, hora, local, descricao, possuiArma, tipoArma);
		
		this.tipo = tipo;
        this.quantidadeVitimasFatais = quantidadeVitimasFatais;
        
	}
	
	@Override
    public String gerarResumo() {
        return "Categoria: Crime contra a Vida"
             + "\nTipo: " + tipo
             + "\nQuantidade de vítimas fatais: "
             + quantidadeVitimasFatais;
    }
	
	public String getTipo() {
        return tipo;
    }

    public int getQuantidadeVitimasFatais() {
        return quantidadeVitimasFatais;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidadeVitimasFatais(int quantidadeVitimasFatais) {
        this.quantidadeVitimasFatais = quantidadeVitimasFatais;
    }

}
