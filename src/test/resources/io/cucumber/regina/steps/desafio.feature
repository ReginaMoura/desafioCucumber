#language: pt

Funcionalidade: Pesquisa no site torne-se um programador
	
	Esquema do Cenario: Validar resultado da busca TDD no site
		Dado que que estou no site do tornese um programador
		Quando digito no campo de busca a palavra <textoDaBusca>
		Entao devo ver o resultado na busca <textoResultadoDaBusca>
	
	Exemplos: 
	| textoDaBusca 	| textoResultadoDaBusca		|
  | "tdd"				  | "Busca pelo termo tdd"  |
	|	"bdd"			  	| "Busca pelo termo bdd"  | 