import javax.swing.JOptionPane;

public class ALGESD5 {
   public static void main(String[] args) {
      exec70();
      exec73();
      exec74();
      exec76();
   }
   
   // MÉTODOS DE EXECUÇÃO --------------------------------------------------------------

   // Método de execução do exercício 70
   static void exec70() {
      int maximo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima do vetor a ser instanciado: "));
   
      int[] vetor70 = new int[maximo];
      
      for (int i = 0; i < vetor70.length; i++) vetor70[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de índice " + i + "/" + maximo + ": "));
      
      int[] vetor70Original = vetor70.clone();
      
      exercicio70(vetor70);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + intVectorToString(vetor70Original) + "\nSeu vetor ordenado: " + intVectorToString(vetor70));
   }
   
   // Método de execução do exercício 73
   static void exec73() {
      char[] vetor73 = new char[10];
      
      for (int i = 0; i < vetor73.length; i++) vetor73[i] = JOptionPane.showInputDialog("Digite o caracter de índice " + i + "/10: ").charAt(0);
      
      char[] vetor73Original = vetor73.clone();
      
      String chave73 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 73: ");
      
      if (chave73.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      
      exercicio73_OrdenacaoPorInsercao(vetor73);
      
      int retorno73 = exercicio73_BuscaBinariaRecursiva(vetor73, chave73.charAt(0), 0, vetor73.length - 1);
      
      if (retorno73 != -1) JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor73Original) + "\nSeu vetor ordenado: " + charVectorToString(vetor73) + "\nO índice da chave é: " + retorno73);
      else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
   }
   
   // Método de execução do exercício 74
   static void exec74() {
      char[] vetor74 = new char[5];
      
      for (int i = 0; i < vetor74.length; i++) vetor74[i] = JOptionPane.showInputDialog("Digite o caracter de índice " + i + "/5: ").charAt(0);
      
      char[] vetor74Original = vetor74.clone();
      
      exercicio74(vetor74, 0, vetor74.length-1);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor74Original) + "\nSeu vetor ordenado: " + charVectorToString(vetor74));
   }
   
   // Método de execução do exercício 76
   static void exec76() {
      double[] vetor76 = new double[20];
      
      for (int i = 0; i < vetor76.length; i++) vetor76[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o número de índice " + i + "/20: "));
      
      double[] vetor76Original = vetor76.clone();
      
      exercicio76(vetor76, 0, vetor76.length-1);
      
      JOptionPane.showMessageDialog(null, "Seu vetor original: " + doubleVectorToString(vetor76Original) + "\nSeu vetor ordenado de forma descrescente: " + doubleVectorToString(vetor76));
   }
   
   // MÉTODOS DE RESOLUÇÕES --------------------------------------------------------------
   
   // Resolução do exercício 70
   static void exercicio70(int[] vetor) {
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
   
   // Resoluções do exercício 73
   static void exercicio73_OrdenacaoPorInsercao(char[] vetor) {
      int i, j;
      char aux;
      
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
   
   static int exercicio73_BuscaBinariaRecursiva(char[] vetor, char chave, int menor, int maior) {
      int meio = (menor + maior) / 2;
      if (chave < vetor[meio] && maior >= 0 && menor <= maior) return exercicio73_BuscaBinariaRecursiva(vetor, chave, menor, meio - 1);
      else if (chave > vetor[meio] && menor < vetor.length && menor <= maior) return exercicio73_BuscaBinariaRecursiva(vetor, chave, meio + 1, maior);
      else if (menor > maior) return -1;
      else return meio;
   }
   
   // Resolução do exercício 74
   static void exercicio74(char[] vetor, int baixo, int alto) {
      int indicePivo, i, j;
      char pivo;
      
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
      
      if (baixo < indicePivo) exercicio74(vetor, baixo, indicePivo-1);
      if (alto > indicePivo) exercicio74(vetor, indicePivo+1, alto);
   }
   
   // Resolução do exercício 76
   static void exercicio76(double[] vetor, int baixo, int alto) {
      int indicePivo, i, j;
      double pivo;
      
      i = baixo;
      j = alto;
      pivo = vetor[baixo];
      
      while (baixo < alto) {
         while ((vetor[alto] <= pivo) && (baixo < alto)) alto--;
         
         if (baixo != alto) {
            vetor[baixo]=vetor[alto];
            baixo++;
         }
         
         while ((vetor[baixo] >= pivo) && (baixo < alto)) baixo++;
         
         if (baixo != alto) {
            vetor[alto]=vetor[baixo];
            alto--;
         }
      }
      
      vetor[baixo] = pivo;
      indicePivo = baixo;
      baixo = i;
      alto = j;
      
      if (baixo < indicePivo) exercicio76(vetor, baixo, indicePivo-1);
      if (alto > indicePivo) exercicio76(vetor, indicePivo+1, alto);
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
