package controleBoletimOcorrencia;

public class CrimeCibernetico extends Ocorrencia {
	
	private String tipo;
    private String plataformaEnvolvida;
    private double prejuizo;
    
	public CrimeCibernetico(int numero, String data, String hora, String local, String descricao, boolean possuiArma,
			String tipoArma, String tipo, String plataformaEnvolvida, double prejuizo) {
		super(numero, data, hora, local, descricao, possuiArma, tipoArma);
		
		this.tipo = tipo;
        this.plataformaEnvolvida = plataformaEnvolvida;
        this.prejuizo = prejuizo;
        
	}

	@Override
    public String gerarResumo() {
        return "Categoria: Crime Cibernético"
             + "\nTipo: " + tipo
             + "\nPlataforma envolvida: " + plataformaEnvolvida
             + "\nPrejuízo: R$ " + prejuizo;
    }
	
	public String getTipo() {
        return tipo;
    }

    public String getPlataformaEnvolvida() {
        return plataformaEnvolvida;
    }

    public double getPrejuizo() {
        return prejuizo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPlataformaEnvolvida(String plataformaEnvolvida) {
        this.plataformaEnvolvida = plataformaEnvolvida;
    }

    public void setPrejuizo(double prejuizo) {
        this.prejuizo = prejuizo;
    }
    
}
