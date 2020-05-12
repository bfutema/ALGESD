package model;

public class LSEModelEx24 {
	public class Node {
		private String iElement;
		private Node nNext;
		
		public Node() {
			iElement = "";
			nNext = null;
		}
		
		public Node(String iElement) {
			this.iElement = iElement;
			this.nNext = nInicio.getNext();
		}
		
		public Node(String iElement, Node nNext) {
			this.iElement = iElement;
			this.nNext = nNext;
		}
		
		public String getElement() { return iElement; }
		
		public Node getNext() { return nNext; }
		
		void setNext(Node nNext) { this.nNext = nNext; }
	}
	
	private Node nInicio;
	private Node nFim;
	private int iTamanho;
	
	public LSEModelEx24() {
		nInicio = null;
		nFim = null;
		iTamanho = 0;
	}
	
	public void putTail(String iElement) {
		Node nNovo = new Node(iElement, null);
		
		if (isEmpty()) nInicio = nNovo;
		else nFim.setNext(nNovo);
		
		nFim = nNovo;
		iTamanho++;
	}
	
	public String takeTail() {
		String iElement = "";
		
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
	
	public String viewHead() {
		String iElement = "";
		
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
