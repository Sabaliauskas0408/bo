package controleBoletimOcorrencia;

import java.util.ArrayList;

public abstract class Ocorrencia implements Exportavel{
	
	private int numero;
	private String data;
	private String hora;
	private String local;
	private String descricao;
	private String status;
	private boolean possuiArma;
	private String tipoArma;
	
	private ArrayList<Pessoa> vitimas;
	private ArrayList<Pessoa> testemunhas;
	private ArrayList<Pessoa> suspeitos;
	
	private Historico historico;
	
	public Ocorrencia (int numero, String data, String hora, String local, String descricao, boolean possuiArma, String tipoArma) {
		
		this.numero = numero;
	    this.data = data;
	    this.hora = hora;
	    this.local = local;
	    this.descricao = descricao;
	    this.status = "Aberta";
	    this.possuiArma = possuiArma;
	    this.tipoArma = tipoArma;

	    this.vitimas = new ArrayList<>();
	    this.testemunhas = new ArrayList<>();
	    this.suspeitos = new ArrayList<>();

	    this.historico = new Historico();
	    this.historico.adicionarRegistro("Ocorrência cadastrada");
	
	}
	
	public abstract String gerarResumo();
	
	public void adicionarVitima(Pessoa vitima) {
		vitimas.add(vitima);
		historico.adicionarRegistro("Vítima adicionada: " + vitima.getNome());
	
	}
	
	public void adicionaTestemunha(Pessoa testemunha) {
		testemunhas.add(testemunha);
		historico.adicionarRegistro("Testemunha adicionada: " + testemunha.getNome());
	}
	
	public void adicionaSuspeito(Pessoa suspeito) {
		suspeitos.add(suspeito);
		historico.adicionarRegistro("Suspeito adicionado: " + suspeito.getNome());
	}
	
	public void mudarStatus(String novoStatus) {
		
		String statusAnterior = this.status;
		
		this.status = novoStatus;
		
		historico.adicionarRegistro("Status alterado de " + statusAnterior + " para " + novoStatus);
		
	}
	
	public int getNumero() {
		
        return numero;
        
    }

    public String getStatus() {
    	
        return status;
        
    }
    
    public String getData() {
        return data;
    }
    
    public String getCategoria() {
        return getClass().getSimpleName();
    }

    public String getDescricao() {
    	
        return descricao;
        
    }

    public void exibirHistorico() {
        historico.mostrarRegistros();
        
    }
    
    public String mostrarPessoas(ArrayList<Pessoa> lista) {

        String informacao = "";

        if (lista.isEmpty()) {
            return "Nenhuma cadastrada\n";
        }

        for (Pessoa pessoa : lista) {
            informacao += "Nome: " + pessoa.getNome()
                      + "\nContato: " + pessoa.getContato()
                      + "\n";
        }

        return informacao;
    }
    
    public void mudarDescricao(String novaDescricao) {

        String descricaoAnterior = this.descricao;

        this.descricao = novaDescricao;

        historico.adicionarRegistro(
            "Descrição alterada de: " + descricaoAnterior
            + " para: " + novaDescricao
        );
    }
    
    @Override
    public String gerarRelatorio() {

        String relatorio = "------- BO Nº " + numero + " -------\n";

        relatorio += "Data: " + data + "\n";
        relatorio += "Hora: " + hora + "\n";
        relatorio += "Local: " + local + "\n";
        relatorio += "Descrição: " + descricao + "\n";
        relatorio += "Status: " + status + "\n";
        relatorio += "Possui arma: " + (possuiArma ? "Sim" : "Não") + "\n";

        if (possuiArma) {
            relatorio += "Tipo de arma: " + tipoArma + "\n";
        }

        relatorio += "\n--- VÍTIMAS ---\n";
        relatorio += mostrarPessoas(vitimas);
        relatorio += "\n--- TESTEMUNHAS ---\n";
        relatorio += mostrarPessoas(testemunhas);
        relatorio += "\n--- SUSPEITOS ---\n";
        relatorio += mostrarPessoas(suspeitos);
        
        relatorio += gerarResumo();

        return relatorio;
    }
    
	
}


