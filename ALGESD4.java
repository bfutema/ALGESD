import javax.swing.JOptionPane;

public class ALGESD4 {
   public static void main(String[] args) {
      exec60();
      exec63();
      exec64();
      exec66();
   }
   
   // MÉTODOS DE EXECUÇÃO --------------------------------------------------------------
   
   // Método de execução do exercício 60
   static void exec60() {
      int maximo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima do vetor a ser instanciado: "));
   
      int[] vetor60 = new int[maximo];
      
      for (int i = 0; i < vetor60.length; i++) vetor60[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de índice " + i + "/" + maximo + ": "));
      
      int[] vetor60Original = vetor60.clone();
      
      exercicio60(vetor60);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + intVectorToString(vetor60Original) + "\nSeu vetor ordenado: " + intVectorToString(vetor60));
   }
   
   // Método de execução do exercício 63
   static void exec63() {
      char[] vetor63 = new char[10];
      
      for (int i = 0; i < vetor63.length; i++) vetor63[i] = JOptionPane.showInputDialog("Digite o caracter de índice " + i + "/10: ").charAt(0);
      
      char[] vetor63Original = vetor63.clone();
      
      String chave63 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 63: ");
      
      if (chave63.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      
      exercicio63_OrdenacaoPorTroca(vetor63);
      
      int retorno63 = exercicio63_BuscaBinariaRecursiva(vetor63, chave63.charAt(0), 0, vetor63.length - 1);
      
      if (retorno63 != -1) JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor63Original) + "\nSeu vetor ordenado: " + charVectorToString(vetor63) + "\nO índice da chave é: " + retorno63);
      else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
   }
   
   // Método de execução do exercício 64
   static void exec64() {
      char[] vetor64 = new char[5];
      
      for (int i = 0; i < vetor64.length; i++) vetor64[i] = JOptionPane.showInputDialog("Digite o caracter de índice " + i + "/5: ").charAt(0);
      
      char[] vetor64Original = vetor64.clone();
      
      exercicio64(vetor64);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor64Original) + "\nSeu vetor ordenado: " + charVectorToString(vetor64));
   }
   
   // Método de execução do exercício 66
   static void exec66() {
      double[] vetor66 = new double[20];
      
      for (int i = 0; i < vetor66.length; i++) vetor66[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o número de índice " + i + "/20: "));
      
      double[] vetor66Original = vetor66.clone();
      
      exercicio66(vetor66);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + doubleVectorToString(vetor66Original) + "\nSeu vetor ordenado de forma descrescente: " + doubleVectorToString(vetor66));
   }
   
   // MÉTODOS DE RESOLUÇÕES --------------------------------------------------------------
   
   // Resolução do exercício 60
   static void exercicio60(int[] vetor) {
      int i, j;
      int aux;
      for (i = 1; i < vetor.length; i++) {
         for (j = vetor.length - 1; j >= i; j--) {
            if (vetor[j-1] > vetor[j]) {
               aux = vetor[j-1];
               vetor[j-1] = vetor[j];
               vetor[j] = aux;
            }
         }
      }
   }
   
   // Resoluções do exercício 63
   static void exercicio63_OrdenacaoPorTroca(char[] vetor) {
      int i, j;
      char aux;
      for (i = 1; i < vetor.length; i++) {
         for (j = vetor.length-1; j >= i; j--) {
            if (vetor[j-1] > vetor[j]) {
               aux = vetor[j-1];
               vetor[j-1] = vetor[j];
               vetor[j] = aux;
            }
         }
      }
   }
   
   static int exercicio63_BuscaBinariaRecursiva(char[] vetor, char chave, int menor, int maior) {
      int meio = (menor + maior) / 2;
      if (chave < vetor[meio] && maior >= 0 && menor <= maior) return exercicio63_BuscaBinariaRecursiva(vetor, chave, menor, meio - 1);
      else if (chave > vetor[meio] && menor < vetor.length && menor <= maior) return exercicio63_BuscaBinariaRecursiva(vetor, chave, meio + 1, maior);
      else if (menor > maior) return -1;
      else return meio;
   }
   
   // Resolução do exercício 64
   static void exercicio64(char[] vetor) {
      int i, j, k;
      char aux;
      
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
   
   // Resolução do exercício 66
   static void exercicio66(double[] vetor) {
      int k;
      double aux;
      
      for (int i = 0; i < vetor.length-1; i++) {
         k = i;
         aux = vetor[i];
         for (int j = i+1; j < vetor.length; j++) {
            if (vetor[j] > aux) {
               k = j;
               aux = vetor[j];
            }
         }
         vetor[k] = vetor[i];
         vetor[i] = aux;
      }
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
