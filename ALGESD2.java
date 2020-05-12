import javax.swing.JOptionPane;

public class ALGESD2 {
   public static void main(String[] args) {
      // Exercício 32 ----------------------------------------------------------------------------------------------------
      int[] vetor32 = new int[15];
      
      for (int i = 0; i < vetor32.length; i++) vetor32[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ": "));
      
      int chave32 = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave de busca do exercício 32: "));
      
      int retorno32 = exercicio32(vetor32, chave32);
      
      if (retorno32 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + intVectorToString(vetor32) + "\nO índice da chave é: " + retorno32);
      else JOptionPane.showMessageDialog(null, "Chave de busca não encontrada!");
      
      // Exercício 33 ----------------------------------------------------------------------------------------------------
      String texto33 = JOptionPane.showInputDialog("Digite um texto com no máximo 15 caracteres.");
      
      while (texto33.length() != 15) {
         JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, digite novamente!");
         texto33 = JOptionPane.showInputDialog("Digite um texto com no máximo 15 caracteres.");
      }
      
      if (texto33.length() != 15) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, digite novamente!");
      else {
         char[] vetor33 = new char[texto33.length()];
         
         for (int i = 0; i < vetor33.length; i++) vetor33[i] = texto33.charAt(i);
         
         String chave33 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 33: ");
         
         if (chave33.length() != 1) JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
         
         int retorno33 = exercicio33(vetor33, chave33.charAt(0));
         
         if (retorno33 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + charVectorToString(vetor33) + "\nO índice da chave é: " + retorno33);
         else JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
      }
      
      // Exercício 39 ----------------------------------------------------------------------------------------------------
      int[] vetor39 = new int[10];
      
      for (int i = 0; i < vetor39.length; i++) vetor39[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ": "));
      
      int chave39 = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave de busca do exercício 39: "));
      
      int retorno39 = exercicio39(vetor39, chave39, 0);
      
      if (retorno39 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + intVectorToString(vetor39) + "\nO índice da chave é: " + retorno39);
      else JOptionPane.showMessageDialog(null, "O elemento não foi encontrado!");

      // Exercício 40 ----------------------------------------------------------------------------------------------------
      String texto40 = JOptionPane.showInputDialog("Digite um texto qualquer: ");
      
      char[] vetor40 = new char[texto40.length()];
      
      for (int i = 0; i < vetor40.length; i++) vetor40[i] = texto40.charAt(i);
      
      String chave40 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 40: ");
      
      while (chave40.length() != 1) {
         JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, digite novamente!");
         chave40 = JOptionPane.showInputDialog("Digite a chave de busca do exercício 40: ");
      }
      
      int retorno40 = exercicio40(vetor40, chave40.charAt(0), (vetor40.length - 1));
      
      if (retorno40 != -1) JOptionPane.showMessageDialog(null, "Seu vetor: " + charVectorToString(vetor40) + "\nO índice da chave é: " + retorno40);
      else JOptionPane.showMessageDialog(null, "O elemento não foi encontrado!");
   }
   
   static int exercicio32(int[] vetor, int chave) {
      int retorno = -1;
      
      for (int i = 0; i < vetor.length; i++) {
         if (vetor[i] == chave) retorno = i;
      }
      
      return retorno;
   }
   
   static int exercicio33(char[] vetor, char chave) {
      int retorno = -1;
      
      for (int i = 0; i < vetor.length; i++) {
         if (vetor[i] == chave) retorno = i;
      }
      
      return retorno;
   }
   
   static int exercicio39(int[] vetor, int chave, int i) {
      if (i % 2 != 0) {
         if ((i + 1) == vetor.length) return -1;
         else {
            if (vetor[i] == chave) return i;   
            else {
               int ret = exercicio39(vetor, chave, i + 1);
               if (ret == -1) return -1;
               else return exercicio39(vetor, chave, i + 1);
            }
         }
      } else {
         int ret = exercicio39(vetor, chave, i + 1);
         if (ret == -1) return -1;
         else return exercicio39(vetor, chave, i + 1);
      }
   }
   
   static int exercicio40(char[] vetor, char chave, int i) {
      if ((i + 1) == 0) return -1;
      else {
         if (vetor[i] == chave) return i;
         else {
            int ret = exercicio40(vetor, chave, i - 1);
            if (ret == -1) return -1;
            else return exercicio40(vetor, chave, i - 1);
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
