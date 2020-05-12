package controller;

import model.LSEModelSample;
import view.LSEViewSample;

public class LSEControllerSample {
	private static LSEModelSample lista;
	private static LSEViewSample	dspMs;
	
	private static String sAuthor = "Bruno Amaral Futema";
	private static String sRA = "81820360";
	
	private static String sTitle = "ALGESD: Lista Singularmente Encadeada";
	
	private static String[] sOptions = {
		"Inserir (Cabeça)",
		"Inserir(Cauda)",
		"Remover(Cabeça)",
		"Remover(Cauda)",
		"Consultar(Cabeça)",
		"Consultar(Cauda)",
		"Tamanho",
		"Sair"
	};
	
	public static void main(String[] args) {
		lista = new LSEModelSample();
		dspMs = new LSEViewSample();
		
		String sMsg = "Bem vindo!\n\nSistema feito por:\n\nNome: " + sAuthor + "\nRA: " + sRA;
		
		dspMs.show(sTitle, sMsg);
		
		int iOption;
		
		do {
			iOption = dspMs.menu(sTitle, sOptions);
			
			switch (iOption) {
				case 0 : insertHead(); break;
				case 1 : insertTail(); break;
				
				case 2 : removeHead(); break;
				case 3 : removeTail(); break;
				
				case 4 : consultHead(); break;
				case 5 : consultTail(); break;
				
				case 6 : size(); break;
				
				default : break;
			}
			
		} while (iOption != sOptions.length-1);
		
		dspMs.show(sTitle, "Até Logo!");
		System.exit(0);
	}
	
	static void insertHead() {
		int iElement = dspMs.receive(sTitle, "Digite o elemento do nó: ");
		
		if (iElement != -1) {
			lista.putHead(iElement);
			dspMs.show(sTitle, "Elemento inserido na cabeça com sucesso!");
		}
	}
	
	static void insertTail() {
		int iElement = dspMs.receive(sTitle, "Digite o elemento do nó: ");
		
		if (iElement != -1) {
			lista.putTail(iElement);
			dspMs.show(sTitle, "Elemento inserido na cauda com sucesso!");
		}
	}
	
	static void removeHead() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento da cabeça removido com sucesso!\n\nElemento removido: " + lista.takeHead());
	}
	
	static void removeTail() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento da cauda removido com sucesso!\n\nElemento removido: " + lista.takeTail());
	}
	
	static void consultHead() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento que está na cabeça: " + lista.viewHead());
	}
	
	static void consultTail() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento que está na cauda: " + lista.viewTail());
	}
	
	static void size() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Tamanho da lista: " + lista.size());
	}
}
