package controller;

import model.LSEModelEx26;
import model.LSEModelEx26.Node;
import view.LSEViewEx26;

public class LSEControllerEx26 {
	private static LSEModelEx26 lista;
	private static LSEViewEx26	dspMs;
	
	private static String sAuthor = "Bruno Amaral Futema";
	private static String sRA = "81820360";
	
	private static String sTitle = "ALGESD: Lista Singularmente Encadeada, Exerc'icio 26 (Pilha)";
	
	private static String[] sOptions = {
		"Digitar uma frase",
		"Consultar todos os nós",
		"Remover caracter",
		"Sair"
	};
	
	public static void main(String[] args) {
		lista = new LSEModelEx26();
		dspMs = new LSEViewEx26();
		
		String sMsg = "Bem vindo!\n\nSistema feito por:\n\nNome: " + sAuthor + "\nRA: " + sRA;
		
		dspMs.show(sTitle, sMsg);
		
		int iOption;
		
		do {
			iOption = dspMs.menu(sTitle, sOptions);
			
			switch (iOption) {
				case 0 : fillListWithPhraseCharacters(); break;
				
				case 1 : consultAllNodes(); break;
				
				case 2 : removeCharacters(); break;
				
				case 3 : size(); break;
				
				default : break;
			}
			
		} while (iOption != sOptions.length-1);
		
		dspMs.show(sTitle, "Até Logo!");
		System.exit(0);
	}
	
	static void fillListWithPhraseCharacters() {
		String phrase = dspMs.receive(sTitle, "Digite uma frase: ");
		
		for (int i = 0; i < phrase.length(); i++) {
			char iElement = phrase.charAt(i);
			
			lista.putTail(iElement);
		}
		
		dspMs.show(phrase, "Todos os caracteres da sua frase foram inseridos na cauda com sucesso!");
	}
	
	static void removeCharacters() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else {
			char c = dspMs.receive(sTitle, "Digite uma frase: ").charAt(0);
			
			String allNodes = concatenateAllNodes("", lista.new Node(lista.viewHead()));
			
			if (!allNodes.contains(String.valueOf(c))) {
				dspMs.show(sTitle, "Sua lista não contém o caracter informado!");
			} else {
				Node prevNove = lista.new Node();
				
				prevNove.setNext(lista.new Node(lista.viewHead()));
				
				String allNodesRem = removeAllByChar("", c, prevNove, lista.new Node(lista.viewHead()));
				dspMs.show(sTitle, "Resultado da frase após a remoção do caracter informado:\n\n" + allNodesRem);
			}
		}
	}

	static String removeAllByChar(String allNodes, char c, Node prev, Node next) {
		if (next != null) {
			if (c == next.getElement()) {
				prev.setNext(next.getNext());
				allNodes += next.getNext().getElement() + ",";
				return removeAllByChar(allNodes, c, prev.getNext(), next.getNext().getNext());
			} else {
				allNodes += next.getElement() + ",";
				return removeAllByChar(allNodes, c, prev.getNext(), next.getNext());
			}
		}
		
		return allNodes;
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
	
	static void consultHead() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Elemento que está na cabeça: " + lista.viewHead());
	}
	
	static void size() {
		if (lista.isEmpty()) dspMs.show(sTitle, "A sua lista está vazia!");
		else dspMs.show(sTitle, "Tamanho da lista: " + lista.size());
	}
}
