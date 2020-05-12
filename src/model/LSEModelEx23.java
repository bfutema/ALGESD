package model;

public class LSEModelEx23 {
	public class Node {
		private int iElement;
		private Node nNext;
		
		public Node() {
			iElement = 0;
			nNext = null;
		}
		
		public Node(int iElement) {
			this.iElement = iElement;
			this.nNext = nInicio.getNext();
		}
		
		public Node(int iElement, Node nNext) {
			this.iElement = iElement;
			this.nNext = nNext;
		}
		
		public int getElement() { return iElement; }
		
		public Node getNext() { return nNext; }
		
		void setNext(Node nNext) { this.nNext = nNext; }
	}
	
	private Node nInicio;
	private Node nFim;
	private int iTamanho;
	
	public LSEModelEx23() {
		nInicio = null;
		nFim = null;
		iTamanho = 0;
	}
	
	public void putTail(int iElement) {
		Node nNovo = new Node(iElement, null);
		
		if (isEmpty()) nInicio = nNovo;
		else nFim.setNext(nNovo);
		
		nFim = nNovo;
		iTamanho++;
	}
	
	public int takeTail() {
		int iElement = -1;
		
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
	
	public int viewHead() {
		int iElement = -1;
		
		if (!isEmpty()) iElement = nInicio.getElement();
		
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
