package controller;

import model.LSEModelEx24;
import model.LSEModelEx24.Node;
import view.LSEViewEx24;

public class LSEControllerEx24 {
	private static LSEModelEx24 lista;
	private static LSEViewEx24	dspMs;
	
	private static String sAuthor = "Bruno Amaral Futema";
	private static String sRA = "81820360";
	
	private static String sTitle = "ALGESD: Lista Singularmente Encadeada, Exerc'icio 24 (Pilha)";
	
	private static String[] sOptions = {
		"Inserir(Cauda)",
		"Consultar todos os nós",
		"Remover(Cauda)",
		"Sair"
	};
	
	public static void main(String[] args) {
		lista = new LSEModelEx24();
		dspMs = new LSEViewEx24();
		
		String sMsg = "Bem vindo!\n\nSistema feito por:\n\nNome: " + sAuthor + "\nRA: " + sRA;
		
		dspMs.show(sTitle, sMsg);
		
		int iOption;
		
		do {
			iOption = dspMs.menu(sTitle, sOptions);
			
			switch (iOption) {
				case 0 : insertTail(); break;
				
				case 1 : consultAllNodes(); break;
				
				case 2 : removeTail(); break;
				
				case 3 : size(); break;
				
				default : break;
			}
			
		} while (iOption != sOptions.length-1);
		
		dspMs.show(sTitle, "Até Logo!");
		System.exit(0);
	}
	
	static void insertTail() {
		String iElement = dspMs.receive(sTitle, "Digite o elemento do nó: ");
		
		if (iElement == null) iElement = "";
		
		if (iElement.length() > 0) {
			lista.putTail(iElement);
			dspMs.show(sTitle, "Elemento inserido na cauda com sucesso!");
		}
	}

	static void removeTail() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento da cauda removido com sucesso!\n\nElemento removido: " + lista.takeTail());
	}
	
	static void consultAllNodes() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else {
			Node node = lista.new Node(lista.viewHead());
			
			String allNodes = concatenateAllNodes("", node);
			
			dspMs.show(sTitle, "Todos os elementos na sua lista: " + allNodes.substring(0, allNodes.length()-1));
		}
	}
	
	static String concatenateAllNodes(String allNodes, Node next) {
		if (next != null) {
			allNodes += next.getElement() + ",";
			return concatenateAllNodes(allNodes, next.getNext());
		}
		
		return allNodes;
	}
	
	static void size() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Tamanho da lista: " + lista.size());
	}
}
