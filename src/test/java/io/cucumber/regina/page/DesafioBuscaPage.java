package io.cucumber.regina.page;

public class DesafioBuscaPage {
	
	//Método para validar o resultado
		public boolean testes (String resultado, String busca) {
			boolean teste = false;
			if (resultado.equals(busca)) {
				teste = true;
			}else {
				teste = false;
			}	
			
			return teste;
		}
		

}
