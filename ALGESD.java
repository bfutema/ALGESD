import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ALGESD {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      
      // JOptionPane.showMessageDialog(frame, "Exercício 22");
//       
//       int termo = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para calcular a série de Fibonacci: "));
//       JOptionPane.showMessageDialog(frame, "Resultado: " + exercicio22(termo));
//       
//       JOptionPane.showMessageDialog(frame, "Ir para o exercício 23");
//       
//       int tamanhoVetor = Integer.parseInt(JOptionPane.showInputDialog(frame, "Informe a quantidade de dígitos para criar um vetor: "));
//       int[] vetor = new int[tamanhoVetor];
//       
//       for (int i = 0; i < vetor.length; i++) {
//          vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de posiçao " + (i + 1) + ": "));
//       }
//       
//       JOptionPane.showMessageDialog(frame, "Resultado: " + exercicio23(vetor, vetor.length));
//       
//       JOptionPane.showMessageDialog(frame, "Ir para o exercício 27");
//       
//       JOptionPane.showMessageDialog(frame, "Digite a seguir dois números para calcular a potencia.");
//       
//       int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número: "));
//       int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número: "));
//       
//       JOptionPane.showMessageDialog(frame, "Resultado: " + exercicio27(n1, n2));
//       
//       JOptionPane.showMessageDialog(frame, "Ir para o exercício 28");
//       
//       JOptionPane.showMessageDialog(frame, "Digite a seguir dois números para calcular a soma sucessiva entre eles.");
//       
//       int n3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número: "));
//       int n4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número: "));
// 
//       JOptionPane.showMessageDialog(frame, "Resultado: " + exercicio28(n3, n4));

      // Exercício 32
      // int check = Integer.parseInt(JOptionPane.showInputDialog("Você deseja digitar os valores ou usar o vetor padrão? (Sim = 1 | Não = 2)"));
// 
//       int[] vetor = new int[15];
//       
//       if (check == 1) {
//          JOptionPane.showMessageDialog(frame, "Digite a seguir 15 números para criar um vetor");
//       
//          for (int i = 0; i < vetor.length; i++) {
//             vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ": "));
//          }
//       } else {
//          for (int i = 0; i < vetor.length; i++) {
//             vetor[i] = (i + 1);
//          }
//       }
//       
//       int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave de busca: "));
//       
//       int retorno = exercicio32(vetor, chave);
//       
//       if (retorno > vetor.length) {
//          JOptionPane.showMessageDialog(frame, "Chave de busca não encontrada!");
//       } else {
//          String str = handleVector(vetor);
//          JOptionPane.showMessageDialog(frame, "Seu vetor: " + str + "\nO índice da chave é: " + retorno);
//       }
            
      // Exercício 33
      //String texto = JOptionPane.showInputDialog("Digite um texto com no máximo 15 caracteres.");
      //
      //if (texto.length() != 15) {
      //   JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      //} else {
      //   char[] vetor33 = new char[texto.length()];
      //   
      //   for (int i = 0; i < vetor33.length; i++) {
      //      vetor33[i] = texto.charAt(i);
      //   }
      //   
      //   String chaveBusca = JOptionPane.showInputDialog("Digite um caracter para usar como chave de busca no vetor: ");
      //   
      //   if (chaveBusca.length() != 1) {
      //      JOptionPane.showMessageDialog(null, "Você não digitou a quantidade de caracteres válida, tente novamente!");
      //   }
      //   
      //   int resultado = exercicio33(vetor33, chaveBusca.charAt(0));
      //   
      //   if (resultado != -1) {
      //      JOptionPane.showMessageDialog(null, "O índice do caracter encontrado é " + resultado);
      //   } else {
      //      JOptionPane.showMessageDialog(null, "O caracter não foi encontrado!");
      //   }
      //}
      
      // Exercício 39
      //int[] vetor39 = new int[15];
      int[] vetor39 = new int[] { 7, 3, 4, 5, 8, 4, 7, 8, 9, 4 };
      
      //for () {
      //   
      //}
      
      int retorno39 = exercicio39(vetor39, 4, 0);
      
      if (retorno39 != -1) {
         JOptionPane.showMessageDialog(null, "O índice do elemento digitado como chave é " + retorno39);
      } else {
         JOptionPane.showMessageDialog(null, "O elemento não foi encontrado!");
      }
      
      // Exercício 40
      
//       char[] vetor40 = new char[] { 'c', 'd', 'a', 'b', 'k', 'a', 'f', 'g', 'a', 'w' };
//       
//       int retorno40 = exercicio40(vetor40, 'z', 9);
//       
//       if (retorno40 != -1) {
//          JOptionPane.showMessageDialog(null, "O índice do elemento digitado como chave é " + retorno40);
//       } else {
//          JOptionPane.showMessageDialog(null, "O elemento não foi encontrado!");
//       }
   }
   
   // Primeira entrega
   /*
      22o) Elaborar um programa, em linguagem Java, para calcular o N-ésimo elemento da
      série de Fibonacci. O índice desse elemento deverá ser digitado para a realização do
      cálculo. Criar um método que calcula o resultado da série, utilizando-se da recursividade.
      
      Série de Fibonacci: O próximo elemento tem o valor igual à soma dos dois elementos
      anteriores da série: 1, 1, 2, 3, 5, 8, 13, 21, ..., infinito;
   */
   static int exercicio22(int n) {
      if (n == 0) return 0;
      else if (n == 1) return 1;
      else return exercicio22(n-1) + exercicio22(n-2);
   }
   
   /*
      23o) Utilizando recursividade, criar um programa, em linguagem Java, que calcule e
      apresente a soma de todos os elementos de um vetor, inteiro, de tamanho 10, o qual deverá
      ser preenchido, anteriormente ao cálculo, pelo operador;
   */
   static int exercicio23(int[] vetor, int tamanho) {
      if (tamanho == 1) return vetor[0];
      else return vetor[tamanho - 1] + exercicio23(vetor, tamanho - 1);
   }
   
   /*
      27o) Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
      capaz de receber, via teclado, dois números inteiros e positivos, calculando o primeiro
      elevado ao segundo.
   */
   static int exercicio27(int a, int b) {
      if (a < 0 && b < 0) return 1;
      else if (b == 0) return 1;
      else return a * exercicio27(a, b - 1);
   }
   
   /*
      28o) Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
      capaz de receber, via teclado, dois números inteiros e positivos, calculando a
      multiplicação entre esses dois números, porém, não se utilizando a multiplicação para
      realizar o cálculo e sim a operação de soma sucessiva.
      
      Exemplo: 4 * 3 é igual a 3 + 3 + 3 + 3.
   */
   static int exercicio28(int a, int b) {
      if (a > 0 && b > 1) return a += exercicio28(a, b - 1);
      else if (b == 0) return 0;
      else return a;
   }
   
   // Segunda Entrega
   static int exercicio32(int[] vetor, int chave) {
      int retorno = 0;
      
      for (int i = 0; i < vetor.length; i++) {
         if (vetor[i] == chave) {
            retorno = i;
            break;
         }
         else retorno = vetor.length + 1;
      }
      
      return retorno;
   }
   
   static int exercicio33(char[] vetor, char chave) {
      int retorno = -1;
      
      for (int i = 0; i < vetor.length; i++) {
         if (vetor[i] == chave) {
            retorno = i;
            break;
         }
      }
      
      return retorno;
   }
   
   static int exercicio39(int[] vetor, int chave, int i) {
      if (i % 2 != 0) {
         if ((i + 1) == vetor.length) return -1;
         else {
            if (vetor[i] == chave) return i;   
            else {
               exercicio39(vetor, chave, i + 1);
               return -1;
            }
         }
      } else {
         exercicio39(vetor, chave, i + 1);
         return -1;
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
   
   //static int exercicio32_Recursivo(int[] vetor, int chave, int i) {
   //   if (vetor.length == i) return vetor.length + 1;
   //   else if (vetor[i] == chave) return i;
   //   else return exercicio32_Recursivo(vetor, chave, i + 1);
   //}
   
   static String handleVector(int[] vetor) {
      String str = "";
      
      for (int i = 0; i < vetor.length; i++) {
         if ((i + 1) == vetor.length) str += vetor[i];
         else str += vetor[i] + ", ";
      }
      
      return str;
   }
}