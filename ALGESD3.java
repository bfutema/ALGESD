import javax.swing.JOptionPane;

public class ALGESD3 {
   public static void main(String[] args) {
      // Exercício 42 ----------------------------------------------------------------------------------------------------
      exec42();
      
      // Exercício 44 ----------------------------------------------------------------------------------------------------
      exec44();
      
      // Exercício 49 ----------------------------------------------------------------------------------------------------
      exec49();
      
      // Exercício 50 ----------------------------------------------------------------------------------------------------
      exec50();
   }
   
   static void exec42() {
      String texto42 = JOptionPane.showInputDialog("Digite um texto com no máximo 10 caracteres.");
      
      while (texto42.length() != 10) {
         JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, digite novamente!");
         texto42 = JOptionPane.showInputDialog("Digite um texto com no máximo 10 caracteres.");
      }
      
      char[] vetor42 = new char[10];
      
      for (int i = 0; i < vetor42.length; i++) vetor42[i] = texto42.charAt(i);
      
      String chave42 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 42: ");
      
      if (chave42.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      
      int retorno42 = exercicio42(vetor42, chave42.charAt(0));
      
      if (retorno42 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + charVectorToString(vetor42) + "\nO índice da chave é: " + retorno42);
      else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
   }
   
   static void exec44() {
      int[] vetor44 = new int[15];
      
      for (int i = 0; i < vetor44.length; i++) vetor44[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de índice " + i + "/15: "));
      
      int chave44 = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave de busca do exercício 44: "));
      
      int retorno44 = exercicio44(vetor44, chave44);
      
      if (retorno44 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + intVectorToString(vetor44) + "\nO índice da chave é: " + retorno44);
      else JOptionPane.showMessageDialog(null, "Chave de busca não encontrada!");
   }
   
   static void exec49() {
      int[] vetor49 = new int[10];
      
      for (int i = 0; i < vetor49.length; i++) vetor49[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de índice " + i + "/10: "));

      int[] vetor49Ordenado = vetor49.clone();
      
      int chave49 = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave de busca do exercício 49: "));
      
      intVectorBubbleSort(vetor49Ordenado);
      
      int retorno49 = exercicio49(vetor49Ordenado, chave49, 0, vetor49Ordenado.length - 1);
      
      if (retorno49 != -1) JOptionPane.showMessageDialog(null, "Seu vetor original: " + intVectorToString(vetor49) + "\nSeu vetor ordenado: " + intVectorToString(vetor49Ordenado) + "\nO índice da chave é: " + retorno49);
      else JOptionPane.showMessageDialog(null, "Chave de busca não encontrada!");
   }
   
   static void exec50() {
      String texto50 = JOptionPane.showInputDialog("Digite um texto com no máximo 10 caracteres.");
       
      while (texto50.length() != 10) {
         JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, digite novamente!");
         texto50 = JOptionPane.showInputDialog("Digite um texto com no máximo 10 caracteres.");
      }
      
      char[] vetor50 = new char[10];
      
      for (int i = 0; i < vetor50.length; i++) vetor50[i] = texto50.charAt(i);
      
      char[] vetor50Ordenado = vetor50.clone();
      
      String chave50 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 50: ");
      
      if (chave50.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      
      charVectorBubbleSort(vetor50Ordenado);
      
      int retorno50 = exercicio50(vetor50Ordenado, chave50.charAt(0), 0, vetor50Ordenado.length - 1);
      
      if (retorno50 != -1) JOptionPane.showMessageDialog(null, "Seu vetor original: " + charVectorToString(vetor50) + "\nSeu vetor ordenado: " + charVectorToString(vetor50Ordenado) + "\nO índice da chave é: " + retorno50);
      else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
   }
   
   static int exercicio42(char[] vetor, char chave) {
      int menor = 0, meio, maior = vetor.length - 1;
      
      while (menor <= maior) {
         meio = (menor + maior) / 2;
         if (chave < vetor[meio]) maior = meio - 1;
         else if (chave > vetor[meio]) menor = meio + 1;
         else return meio;
      }
      
      return -1;
   }
   
   static int exercicio44(int[] vetor, int chave) {
      int menor = 0, meio, maior = vetor.length;
      
      while (menor <= maior) {
         meio = (menor + maior) / 2;
         if (meio >= vetor.length) break;
         else if (chave < vetor[meio]) maior = meio - 1;
         else if (chave > vetor[meio]) menor = meio + 1;
         else return meio;
      }
      
      return -1;
   }
   
   static int exercicio49(int[] vetor, int chave, int menor, int maior) {
      int meio = (menor + maior) / 2;
      if (chave < vetor[meio] && maior >= 0) return exercicio49(vetor, chave, menor, meio - 1);
      else if (chave > vetor[meio] && menor < vetor.length) return exercicio49(vetor, chave, meio + 1, maior);
      else return -1;
   }
   
   static int exercicio50(char[] vetor, char chave, int menor, int maior) {
      int meio = (menor + maior) / 2;
      if (chave < vetor[meio]) return exercicio50(vetor, chave, menor, meio - 1);
      else if (chave > vetor[meio]) return exercicio50(vetor, chave, meio + 1, maior);
      else return meio;
   }
   
   static void intVectorBubbleSort(int[] vetor) {
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
   
   static void charVectorBubbleSort(char[] vetor) {
      int iA, iB;
      char aux;
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
   
   // Métodos criados apenas para facilitar na correção
   static String intVectorToString(int[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
   
   static String charVectorToString(char[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
}