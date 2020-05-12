package model;

public class LSEModelEx26 {
	public class Node {
		private char iElement;
		private Node nNext;
		
		public Node() {
			iElement = Character.MIN_VALUE;
			nNext = null;
		}
		
		public Node(char iElement) {
			this.iElement = iElement;
			this.nNext = nInicio.getNext();
		}
		
		public Node(char iElement, Node nNext) {
			this.iElement = iElement;
			this.nNext = nNext;
		}
		
		public char getElement() { return iElement; }
		
		public Node getNext() { return nNext; }
		
		public void setNext(Node nNext) { this.nNext = nNext; }
	}
	
	private Node nInicio;
	private Node nFim;
	private int iTamanho;
	
	public LSEModelEx26() {
		nInicio = null;
		nFim = null;
		iTamanho = 0;
	}
	
	public void putTail(char iElement) {
		Node nNovo = new Node(iElement, null);
		
		if (isEmpty()) nInicio = nNovo;
		else nFim.setNext(nNovo);
		
		nFim = nNovo;
		iTamanho++;
	}
	
	public char takeTail() {
		char iElement = Character.MIN_VALUE;
		
		if (!isEmpty()) {
			iElement = nInicio.getElement();
			
			if (size() == 1) {
				nInicio = null;
				nFim = null;
			} else nInicio = nInicio.getNext();
			
			iTamanho--;
		}
		
		return iElement;
	}
	
	public char viewHead() {
		char iElement = Character.MIN_VALUE;
		
		if (!isEmpty()) iElement = nInicio.getElement();
		
		return iElement;
	}
	
	public char viewTail() {
		char iElement = Character.MIN_VALUE;
		
		if (!isEmpty()) iElement = nFim.getElement();
		
		return iElement;
	}
	
	public int size() {
		return iTamanho;
	}
	
	public boolean isEmpty() {
		boolean empty = false;
		
		if (size() == 0) empty = true;
		
		return empty;
	}
}
