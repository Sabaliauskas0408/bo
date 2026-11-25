package controleBoletimOcorrencia;

public class Outros extends Ocorrencia {
	
	private String tipo;
    private String informacoesAdicionais;
    
	public Outros(int numero, String data, String hora, String local, String descricao, boolean possuiArma,
			String tipoArma, String tipo, String informacoesAdicionais) {
		super(numero, data, hora, local, descricao, possuiArma, tipoArma);
		
		this.tipo = tipo;
        this.informacoesAdicionais = informacoesAdicionais;
        
	}

	@Override
    public String gerarResumo() {
        return "Categoria: Outros"
             + "\nTipo: " + tipo
             + "\nInformações adicionais: " + informacoesAdicionais;
    }
	
	public String getTipo() {
        return tipo;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }
    
}
