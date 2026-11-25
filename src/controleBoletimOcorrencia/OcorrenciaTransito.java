package controleBoletimOcorrencia;

public class OcorrenciaTransito extends Ocorrencia {
	
	private String tipo;
    private boolean houveMortes;
    private boolean houveIncendio;
    private int quantidadeVeiculos;
    private int quantidadeFeridos;
    
	public OcorrenciaTransito(int numero, String data, String hora, String local, String descricao, boolean possuiArma,
			String tipoArma, String tipo, boolean houveMortes, boolean houveIncendio, int quantidadeVeiculos, int quantidadeFeridos) {
		super(numero, data, hora, local, descricao, possuiArma, tipoArma);
		
		this.tipo = tipo;
	    this.houveMortes = houveMortes;
	    this.houveIncendio = houveIncendio;
	    this.quantidadeVeiculos = quantidadeVeiculos;
	    this.quantidadeFeridos = quantidadeFeridos;
	    
	}

	@Override
	public String gerarResumo() {

	    String resumo = "Categoria: Ocorrência de Trânsito";

	    resumo += "\nTipo: " + tipo;
	    resumo += "\nVeículos envolvidos: " + quantidadeVeiculos;
	    resumo += "\nFeridos: " + quantidadeFeridos;

	    if (houveMortes) {
	        resumo += "\nHouve mortes: Sim";
	    } else {
	        resumo += "\nHouve mortes: Não";
	    }

	    if (houveIncendio) {
	        resumo += "\nHouve incêndio: Sim";
	    } else {
	        resumo += "\nHouve incêndio: Não";
	    }

	    return resumo;
	}
	
	public String getTipo() {
        return tipo;
    }

    public boolean isHouveMortes() {
        return houveMortes;
    }

    public boolean isHouveIncendio() {
        return houveIncendio;
    }

    public int getQuantidadeVeiculos() {
        return quantidadeVeiculos;
    }

    public int getQuantidadeFeridos() {
        return quantidadeFeridos;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHouveMortes(boolean houveMortes) {
        this.houveMortes = houveMortes;
    }

    public void setHouveIncendio(boolean houveIncendio) {
        this.houveIncendio = houveIncendio;
    }

    public void setQuantidadeVeiculos(int quantidadeVeiculos) {
        this.quantidadeVeiculos = quantidadeVeiculos;
    }

    public void setQuantidadeFeridos(int quantidadeFeridos) {
        this.quantidadeFeridos = quantidadeFeridos;
    }
    
}
