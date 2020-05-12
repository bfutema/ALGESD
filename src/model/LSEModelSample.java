package model;

public class LSEModelSample {
	public class Node {
		private int iElement;
		private Node nNext;
		
		public Node() {
			iElement = 0;
			nNext = null;
		}
		
		public Node(int iElement, Node nNext) {
			this.iElement = iElement;
			this.nNext = nNext;
		}
		
		int getElement() { return iElement; }
		
		Node getNext() { return nNext; }
		
		void setNext(Node nNext) { this.nNext = nNext; }
	}
	
	private Node nInicio;
	private Node nFim;
	private int iTamanho;
	
	public LSEModelSample() {
		nInicio = null;
		nFim = null;
		iTamanho = 0;
	}
	
	public void putHead(int iElement) {
		Node nNovo = new Node(iElement, null);
		
		if (isEmpty()) nFim = nNovo;
		else nNovo.setNext(nInicio);
		
		nInicio = nNovo;
		iTamanho++;
	}
	public void putTail(int iElement) {
		Node nNovo = new Node(iTamanho, null);
		
		if (isEmpty()) nInicio = nNovo;
		else nFim.setNext(nNovo);
		
		nFim = nNovo;
		iTamanho++;
	}
	
	public int takeHead() {
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
	public int viewTail() {
		int iElement = -1;
		
		if (!isEmpty()) iElement = nFim.getElement();
		
		return iElement;
	}
	
	public int size() { return iTamanho; }
	public boolean isEmpty() {
		boolean empty = false;
		
		if (size() == 0) empty = true;
		
		return empty;
	}
}
