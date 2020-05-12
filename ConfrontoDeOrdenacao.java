import java.util.Random;
import javax.swing.JOptionPane;

public class ConfrontoDeOrdenacao {
   public static void main(String[] args) {
      int input = 1;
      do {
         int tamanho = 10000;
      
         int[] vetorA = new int[tamanho];
         int[] vetorB = new int[tamanho];
         int[] vetorC = new int[tamanho];
         int[] vetorD = new int[tamanho];
         int[] vetorE = new int[tamanho];
         
         criarVetoresAleatorios(vetorA, vetorB, vetorC, vetorD, vetorE, tamanho);
         
         long startA = System.nanoTime();
         bubbleSort(vetorA);
         long endA = System.nanoTime();
         
         long startB = System.nanoTime();
         selectionSort(vetorB);
         long endB = System.nanoTime();
         
         long startC = System.nanoTime();
         insertionSort(vetorC);
         long endC = System.nanoTime();
         
         long startD = System.nanoTime();
         quickSort(vetorD, 0, vetorD.length-1);
         long endD = System.nanoTime();
         
         long startE = System.nanoTime();
         mergeSort(vetorE);
         long endE = System.nanoTime();
         
         long microssecondsA = (endA - startA) / 1000;
         long microssecondsB = (endB - startB) / 1000;
         long microssecondsC = (endC - startC) / 1000;
         long microssecondsD = (endD - startD) / 1000;
         long microssecondsE = (endE - startE) / 1000;
         
         double secondsA = (microssecondsA / 1000000000);
         double secondsB = (microssecondsB / 1000000000);
         double secondsC = (microssecondsC / 1000000000);
         double secondsD = (microssecondsD / 1000000000);
         double secondsE = (microssecondsE / 1000000000);
         
         JOptionPane.showMessageDialog(null,
               "Resultado do vetorA ordenado por BubbleSort: " + microssecondsA + " microssegundos e " + secondsA + " segundos" +
               "\nResultado do vetorB ordenado por SelectionSort: " + microssecondsB + " microssegundos e " + secondsB + " segundos" +
               "\nResultado do vetorC ordenado por InsertionSort: " + microssecondsC + " microssegundos e " + secondsC + " segundos" +
               "\nResultado do vetorD ordenado por QuickSort: " + microssecondsD + " microssegundos e " + secondsD + " segundos" +
               "\nResultado do vetorE ordenado por MergeSort: " + microssecondsE + " microssegundos e " + secondsE + " segundos");
         
         input = Integer.parseInt(JOptionPane.showInputDialog("Você quer testar novamente?"));
      } while (input == 1);
   }
   
   static void criarVetoresAleatorios(int[] vA, int[] vB, int[] vC, int[] vD, int[] vE, int tamanho) {
      for (int i = 0; i < tamanho; i++) {
         Random r = new Random();
         int n = (int)(Math.random() * 25 + (i * 2) * r.nextInt(30));
         vA[i] = n;
         vB[i] = n;
         vC[i] = n;
         vD[i] = n;
         vE[i] = n;
      }
   }
   
   static void bubbleSort(int[] vetor) {
      int iA, iB;
      int aux;
      for (iA=1; iA < vetor.length; iA++) {
         for (iB=vetor.length-1; iB >= iA; iB--) {
            if (vetor[iB-1] > vetor[iB]) {
               aux = vetor[iB-1];
               vetor[iB-1] = vetor[iB];
               vetor[iB] = aux;
            }
         }
      }
   }
   
   static void selectionSort(int[] vetor) {
      int i, j, k;
      int aux;
      
      for (i = 0; i < vetor.length-1; i++) {
         k = i;
         aux = vetor[i];
         
         for (j = i+1; j < vetor.length; j++) {
            if (vetor[j] < aux) {
               k = j;
               aux = vetor[j];
            }
         }
         vetor[k] = vetor[i];
         vetor[i] = aux;
      }
   }
   
   static void insertionSort(int[] vetor) {
      int i, j;
      int aux;
      
      for (i = 1; i < vetor.length; i++) {
         aux = vetor[i];
         j = i-1;
         
         while (j >= 0 && aux < vetor[j]) {
            vetor[j+1] = vetor[j];
            j--;
         }
         
         vetor[j+1] = aux;
      }
   }
   
   static void quickSort(int[] vetor, int baixo, int alto) {
      int indicePivo, i, j;
      int pivo;
      
      i = baixo;
      j = alto;
      pivo = vetor[baixo];
      
      while (baixo < alto) {
         while ((vetor[alto] >= pivo) && (baixo < alto)) alto--;
         
         if (baixo != alto) {
            vetor[baixo]=vetor[alto];
            baixo++;
         }
         
         while ((vetor[baixo] <= pivo) && (baixo < alto)) baixo++;
         
         if (baixo != alto) {
            vetor[alto]=vetor[baixo];
            alto--;
         }
      }
      
      vetor[baixo] = pivo;
      indicePivo = baixo;
      baixo = i;
      alto = j;
      
      if (baixo < indicePivo) quickSort(vetor, baixo, indicePivo-1);
      if (alto > indicePivo) quickSort(vetor, indicePivo+1, alto);
   }
   
   static void mergeSort(int[] vetor) {
      if (vetor.length > 1) {
         int tamanho1 = vetor.length/2;
         int tamanho2 = vetor.length-tamanho1;
         int[] vetorA = new int[tamanho1];
         int[] vetorB = new int[tamanho2];
         
         for (int i = 0; i < tamanho1; i++) {
            vetorA[i] = vetor[i];
         }
         
         for (int i = tamanho1; i < (tamanho1+tamanho2); i++) {
            vetorB[i-tamanho1] = vetor[i];
         }
         
         mergeSort(vetorA);
         mergeSort(vetorB);
         merge(vetor, vetorA, vetorB);
      }
   }
   
   static void merge(int[] vetor, int[] vetor1, int[] vetor2) {
      int i = 0, j = 0, k = 0;
      
      while (vetor1.length != j && vetor2.length != k) {
         if (vetor1[j] <= vetor2[k]) {
            vetor[i] = vetor1[j];
            i++;
            j++;
         } else {
            vetor[i] = vetor2[k];
            i++;
            k++;
         }
      }
      
      while (vetor1.length != j) {
         vetor[i] = vetor1[j];
         i++;
         j++;
      }
      
      while (vetor2.length != k) {
         vetor[i] = vetor2[k];
         i++;
         k++;
      }
   }
}