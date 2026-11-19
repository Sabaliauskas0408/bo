package controleBoletimOcorrencia;

import java.util.ArrayList;

public class Historico {
	
	private ArrayList<String> registros;
	
	public Historico() {
		
		registros = new ArrayList<>();
		
	}
	
	public void adicionarRegistro(String registro) {
		
		registros.add(registro);
	}
	
	public void mostrarRegistros() {
		if(registros.isEmpty()) {
			System.out.println("Nenhum registro no histórico");
		} else {
			for(int i = 0; i < registros.size(); i++) {
				System.out.println((i+1) + "." + registros.get(i));
			}
		}
	}
}
