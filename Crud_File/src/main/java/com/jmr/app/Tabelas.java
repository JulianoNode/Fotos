package com.jmr.app;

public class Tabelas {
	
	public String runProgeto () {
		
		System.out.println(runCategoria() 
						 + runPrivacidade() 
						 + runEspecialidade() 
						 + runGenero()
						 + runFormato()	
						 						 
						 + runFornecedor()
						 + runParcela()
						 + runProduto()
						 + runValorParcela()
						 + runImagem()
						 
						 + runAutor()
						 + runDia() 
						 + runMes() 
						 + runAno() 
						 );
		return "" ;
	}
	
	public String runCategoria () {
		return "\n\t|_ Progeto Categoria: nome/descrição " ;
	}
	
	public String runPrivacidade () {
		return "\n\t|_ Progeto Privacidade: titulo/descrição " ;
	}
	
	
	public String runEspecialidade () {
		return "\n\t|_ Progeto Especialidade: titulo/descrição " ;
	}
	
	public String runGenero () {
		return "\n\t|_ Progeto Genero: titulo/descrição " ;
	}
	
	public String runFormato () {
		return "\n\t|_ Progeto Formato: Titulo \n" ;
	}	
	
	public String runAutor () {
		return "\n\t|_ Progeto Autor: nome/idade " ;
	}
	
	
	public String runFornecedor () {
		return "\n\t|_ Progeto Fornecedor: nome/link " ;
	}
	
	public String runParcela () {
		return "\n\t|_ Progeto Parcela: parcela " ;
	}
	
	public String runProduto () {
		return "\n\t|_ Progeto Produto: link/titulo/imagem " ;
	}
	
	public String runValorParcela () {
		return "\n\t|_ Progeto ValorParcela: valor" ;
	}
	
	public String runImagem () {
		return "\n\t|_ Progeto Imagem: nome/foto \n" ;
	}
	
	public String runDia () {
		return "\n\t|_ Progeto Dia: dia" ;
	}
	public String runMes () {
		return "\n\t|_ Progeto Mes: mes" ;
	}
	public String runAno () {
		return "\n\t|_ Progeto Ano: ano" ;
	}


}
