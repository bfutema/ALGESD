import javax.swing.JOptionPane;

public class ALGESD6 {
   public static void main(String[] args) {
      exec80();
      exec81();
      exec83();
   }
   
   // Exercício 80 --------------------------------------------------------------------
   static void exec80() {
      int maximo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima do vetor a ser instanciado: "));
      
      int[] vetor80 = new int[maximo];
      
      for (int i = 0; i < vetor80.length; i++) vetor80[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de índice " + i + "/" + maximo + ": "));
      
      int[] vetor80Original = vetor80.clone();
      
      exercicio80(vetor80);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + intVectorToString(vetor80Original) + "\nSeu vetor ordenado: " + intVectorToString(vetor80));
   }
   
   static void exercicio80(int[] vetor) {
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
         
         exercicio80(vetorA);
         exercicio80(vetorB);
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
   
   // Exercício 81 --------------------------------------------------------------------
   static void exec81() {
      double[] vetor81 = new double[20];
      
      for (int i = 0; i < vetor81.length; i++) vetor81[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o número de índice " + i + "/20: "));
      
      double[] vetor81Original = vetor81.clone();
      
      exercicio81(vetor81);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + doubleVectorToString(vetor81Original) + "\nSeu vetor ordenado de forma descrescente: " + doubleVectorToString(vetor81));
   }
   
   static void exercicio81(double[] vetor) {
      if (vetor.length > 1) {
         int tamanho1 = vetor.length/2;
         int tamanho2 = vetor.length-tamanho1;
         double[] vetorA = new double[tamanho1];
         double[] vetorB = new double[tamanho2];
         
         for (int i = 0; i < tamanho1; i++) {
            vetorA[i] = vetor[i];
         }
         
         for (int i = tamanho1; i < (tamanho1+tamanho2); i++) {
            vetorB[i-tamanho1] = vetor[i];
         }
         
         exercicio81(vetorA);
         exercicio81(vetorB);
         merge81(vetor, vetorA, vetorB);
      }
   }
   
   static void merge81(double[] vetor, double[] vetor1, double[] vetor2) {
      int i = 0, j = 0, k = 0;
      
      while (vetor1.length != j && vetor2.length != k) {
         if (vetor1[j] >= vetor2[k]) {
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
   
   // Exercício 83 --------------------------------------------------------------------
   static void exec83() {
      char[] vetor83 = new char[10];
      
      for (int i = 0; i < vetor83.length; i++) vetor83[i] = JOptionPane.showInputDialog("Digite o caracter de índice " + i + "/10: ").charAt(0);
      
      char[] vetor83Original = vetor83.clone();
      
      String chave83 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 83: ");
      
      if (chave83.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      
      exercicio83(vetor83);
      
      int retorno83 = exercicio83_BuscaBinariaRecursiva(vetor83, chave83.charAt(0), 0, vetor83.length - 1);
      
      if (retorno83 != -1) JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor83Original) + "\nSeu vetor ordenado: " + charVectorToString(vetor83) + "\nO índice da chave é: " + retorno83);
      else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
   }
   
   static void exercicio83(char[] vetor) {
      if (vetor.length > 1) {
         int tamanho1 = vetor.length/2;
         int tamanho2 = vetor.length-tamanho1;
         char[] vetorA = new char[tamanho1];
         char[] vetorB = new char[tamanho2];
         
         for (int i = 0; i < tamanho1; i++) {
            vetorA[i] = vetor[i];
         }
         
         for (int i = tamanho1; i < (tamanho1+tamanho2); i++) {
            vetorB[i-tamanho1] = vetor[i];
         }
         
         exercicio83(vetorA);
         exercicio83(vetorB);
         merge83(vetor, vetorA, vetorB);
      }
   }
   
   static void merge83(char[] vetor, char[] vetor1, char[] vetor2) {
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
   
   static int exercicio83_BuscaBinariaRecursiva(char[] vetor, char chave, int menor, int maior) {
      int meio = (menor + maior) / 2;
      if (chave < vetor[meio] && maior >= 0 && menor <= maior) return exercicio83_BuscaBinariaRecursiva(vetor, chave, menor, meio - 1);
      else if (chave > vetor[meio] && menor < vetor.length && menor <= maior) return exercicio83_BuscaBinariaRecursiva(vetor, chave, meio + 1, maior);
      else if (menor > maior) return -1;
      else return meio;
   }
   
   // MÉTODOS AUXILIARES --------------------------------------------------------------
   static String intVectorToString(int[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
   
   static String doubleVectorToString(double[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
   
   static String charVectorToString(char[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
}
