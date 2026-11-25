
package controleBoletimOcorrencia;

import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorOcorrencias {

    private ArrayList<Ocorrencia> ocorrencias;

    public GerenciadorOcorrencias() {
        ocorrencias = new ArrayList<>();
    }

    public boolean cadastrar(Ocorrencia novaOcorrencia) {

        if (novaOcorrencia == null) {
            return false;
        }

        if (buscarPorNumero(novaOcorrencia.getNumero()) != null) {
            return false;
        }

        ocorrencias.add(novaOcorrencia);

        return true;
    }

    public Ocorrencia buscarPorNumero(int numero) {

        for (Ocorrencia ocorrencia : ocorrencias) {

            if (ocorrencia.getNumero() == numero) {
                return ocorrencia;
            }
        }

        return null;
    }
    
    public boolean alterarStatus(int numero, String novoStatus) {

        Ocorrencia ocorrencia = buscarPorNumero(numero);

        if (ocorrencia == null) {
            return false;
        }

        ocorrencia.mudarStatus(novoStatus);

        return true;
    }
    
    public boolean alterarDescricao(int numero, String novaDescricao) {

        Ocorrencia ocorrencia = buscarPorNumero(numero);

        if (ocorrencia == null) {
            return false;
        }

        ocorrencia.mudarDescricao(novaDescricao);

        return true;
    }
    
    public boolean remover(int numero) {

        Ocorrencia ocorrencia = buscarPorNumero(numero);

        if (ocorrencia == null) {
            return false;
        }

        ocorrencias.remove(ocorrencia);

        return true;
    }
    

	public void listarEmTabela() {
	
	    if (ocorrencias.isEmpty()) {
	        System.out.println("Nenhum boletim cadastrado.");
	        return;
	    }
	
	    System.out.println("--------------------------------------------------------------------------");
	
	    System.out.printf("%-10s %-25s %-15s %-15s%n",
	            "NÚMERO", "CATEGORIA", "DATA", "STATUS");
	
	    System.out.println("--------------------------------------------------------------------------");
	
	    for (Ocorrencia ocorrencia : ocorrencias) {
	
	        System.out.printf("%-10d %-25s %-15s %-15s%n",
	                ocorrencia.getNumero(),
	                ocorrencia.getCategoria(),
	                ocorrencia.getData(),
	                ocorrencia.getStatus());
	    }
	
	    System.out.println("--------------------------------------------------------------------------");
	}
	
	public void ordenarPorNumero() {
	
	    ocorrencias.sort(new Comparator<Ocorrencia>() {
	
	        @Override
	        public int compare(Ocorrencia bo1, Ocorrencia bo2) {
	            return Integer.compare(
	                    bo1.getNumero(),
	                    bo2.getNumero()
	            );
	        }
	    });
	
	    listarEmTabela();
	}

}

