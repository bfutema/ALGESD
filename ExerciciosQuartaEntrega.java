import javax.swing.JOptionPane;

/*60) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
ordenado em tela. Utilizar um método de ordenação por trocas.*/

/*63) Elaborar um programa, em linguagem Java, capaz de realizar a busca de um
determinado caractere, digitado, em um vetor qualquer de tamanho 10, também com seus
elementos do tipo char digitados, informando qual o índice do vetor que esse caractere se
localiza. Utilizar ordenação do tipo troca e busca binária recursiva.*/

/*64) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
conteúdo de cada elemento de um vetor do tipo char, de tamanho 5, via teclado, executar
uma ordenação crescente do mesmo e apresentar o vetor ordenado em tela. Utilizar um
método de ordenação por seleção.*/

/*66) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
conteúdo de cada elemento de um vetor do tipo double, de tamanho 20, via teclado,
executar uma ordenação decrescente do mesmo e apresentar o vetor ordenado em tela.
Utilizar um método de ordenação por seleção.*/
//- 60; 63; 64; 66.

public class ExerciciosQuartaEntrega {
	public static void main(String [] args) {
		iniciarExercicios();
	}
	
	public static void iniciarExercicios() {
		while(true) {
			
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
					+ "Exercicio 60 - Ordenação por trocas (Bubble-Sort) \n "
					+ "Exercicio 63 - Busca binaria recursiva em vetor ordenado por bubble-sort do tipo char. \n "
					+ "Exercicio 64 - Ordenação por Selection-Sort. \n "
					+ "Exercicio 66 - Vetor do tipo double desordenado por Selection-Sort. \n "
					+ "Digite '0' para sair\""));
			if (pergunta == 60) {
				int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do seu vetor"));
				int [] vetor = exercicio60(tamanho);
				String vetorConcatenado = "";
				
				for (int i = 0; i < tamanho; i++) {
					vetorConcatenado += vetor[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);

				JOptionPane.showMessageDialog(null, "Seu vetor ordenado: " + vetorFinal);
			}
			else if (pergunta == 63) {	
				char [] vetor = criarVetorChar(0, 10);
				
				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor: (" + a + ") está na posição: " + exercicio63(vetor, 0, vetor.length-1, a));
			}
			else if (pergunta == 64) {
				char [] vetor = criarVetorChar(1, 5);
				String vetorConcatenado = "";
				
				for (int i = 0; i < vetor.length; i++) {
					vetorConcatenado += vetor[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);
				JOptionPane.showMessageDialog(null, "Seu vetor ordenado: " + vetorFinal);
			}
			
			else if (pergunta == 66) {
				double vetor[] = criarVetor(20);
				double vetorOrdenado[] = exercicio66(vetor, 20);
				
				String vetorConcatenado = "";
				for (int i = 0; i < vetorOrdenado.length; i++) {
					vetorConcatenado += vetorOrdenado[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);
				JOptionPane.showMessageDialog(null, "Seu vetor desordenado: " + vetorFinal);
				
			}
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 60 || pergunta != 63 || pergunta != 64 || pergunta != 66 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 60, 63, 64, 66, 0");
			}
		}
	}
	

	
	public static int[] ordenarVetorBubble(int vetor[], int tamanho) {
		int aux;
		
		for(int i = 1; i < tamanho; i++) {
			for(int j = tamanho-1; j >= i; j--) {
				if(vetor[j-1] > vetor[j]) {
					aux = vetor[j-1];
					vetor[j-1] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
	
	
	public static char[] criarVetorChar(int tipo, int a){
		char [] vetor = new char[a];
		char [] vetorOrdenado = new char[a];
		      
	    for (int i = 0; i < a; i++) {
		    String valores = JOptionPane.showInputDialog("Digite uma letra para ser inserida no vetor");
	        char valor = valores.charAt(0);
	        vetor[i] = valor; 
	    }
	    if(tipo == 0) {
			vetorOrdenado = ordenarVetorCharBubble(vetor, a);
			return vetorOrdenado;
	    }
	    else if (tipo == 1) {
			vetorOrdenado = exercicio64(vetor, a);
			return vetorOrdenado;
	    }
	    return vetorOrdenado;
	}
	
	public static char[] ordenarVetorCharBubble(char vetor[], int a) {
		char aux;
		
		for(int i = 1; i < a; i++) {
			for(int j = a-1; j >= i; j--) {
				if(vetor[j-1] > vetor[j]) {
					aux = vetor[j-1];
					vetor[j-1] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
			
	
	public static double[] criarVetor(int a){
		double [] vetor = new double[a];
		      
		for (int i = 0; i < a; i++) {
			double valores = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor"));
		    vetor[i] = valores;
		    	  
		}
		return vetor;
	}
	
	//Exercicios
	
	public static int[] exercicio60(int a){
		int [] vetor = new int[a];
		      
		for (int i = 0; i < a; i++) {
			int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor"));
		    vetor[i] = valores;
		    	  
		}
		int [] vetorOrdenado = ordenarVetorBubble(vetor, a);
		return vetorOrdenado;
	}
	
	public static int exercicio63(char [] vetor, int baixo, int alto, char posicao) {
		int meio;
		
		if(baixo <= alto) {
			meio = (baixo+alto)/2;
			if(posicao < vetor[meio]) {
				return exercicio63(vetor, baixo, meio-1, posicao);
			}
			else if (posicao > vetor[meio]) {
				return exercicio63(vetor, meio+1, alto, posicao);
			}
			else {
				return meio;
			}
		}
		return -1;
	}

	
	//ordenarVetorCharSelection
	public static char[] exercicio64(char vetor[], int a) {
		int posicao;
		char aux;
		
		for(int i = 0; i < a-1; i++) {
			posicao = i;
			aux = vetor[i];
			
			for(int j = i+1; j < a; j++) {
				if(vetor[j] < aux) {
					posicao = j;
					aux = vetor[j];
				}
			}
			vetor[posicao] = vetor[i];
			vetor[i] = aux;
		}
		return vetor;
	}


	
	public static double[] exercicio66(double vetor[], int a) {
		int posicao;
		double aux;
		
		for(int i = 0; i < a-1; i++) {
			posicao = i;
			aux = vetor[i];
			
			for(int j = i+1; j < a; j++) {
				if(vetor[j] > aux) {
					posicao = j;
					aux = vetor[j];
				}
			}
			vetor[posicao] = vetor[i];
			vetor[i] = aux;
		}
		return vetor;
	}
}