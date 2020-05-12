import javax.swing.*;
import java.util.*;

public class Exercicios {
   public static void main(String[] args) {
      int[] a = exercicio01_Aquecimento();
      
      exercicio02_Aquecimento(a);
   }
   
   private static void exercicio5_ListaDeExercíciosAlgoritmos() {
      String capicuas = "";
      ArrayList<String> capicuasVector = new ArrayList<String>();
      int[] vetor = new int[16];
      
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame, "Digite 16 números!");
      
      for (int i = 0; i < vetor.length; i++) {
         String str = JOptionPane.showInputDialog("Digite um número: ");
         vetor[i] = Integer.parseInt(str);
      }
      
      for (int i = 0; i < vetor.length; i++) {
         if (i > 2) {
            if (vetor[i] == vetor[i - 3]) {
               if (vetor[i - 1] == vetor[i - 2]) {
                  capicuasVector.add(vetor[i - 3] + "" + vetor[i - 2] + "" + vetor[i - 1] + "" + vetor[i]);
                  if (capicuas == "") {
                     capicuas += vetor[i - 3] + "" + vetor[i - 2] + "" + vetor[i - 1] + "" + vetor[i];
                  } else {
                     capicuas += " | " + vetor[i - 3] + "" + vetor[i - 2] + "" + vetor[i - 1] + "" + vetor[i];
                  }
               }
            }
         }
      }
      
      JOptionPane.showMessageDialog(frame, "Capicuas: " + capicuas + ", Qtd Capicuas: " + capicuasVector.size());
   }
   
   private static void exercicio4_ListaDeExercíciosAlgoritmos(char[] vetor) {
      for (int i = 0; i < vetor.length; i++) {
         if (i % 2 != 0) {
            char aux = vetor[i-1];
            vetor[i-1] = vetor[i];
            vetor[i] = aux;
         }
      }
      
      for (int i = 0; i < vetor.length; i++) {
         System.out.println(vetor[i]);
      }
   }
   
   private static char[] exercicio3_ListaDeExercíciosAlgoritmos() {
      char[] vetor = new char [26];
      for (int i = 0; i < vetor.length; i++) {
         if (i == 0) vetor[i] = 'A';
         if (i == 1) vetor[i] = 'B';
         if (i == 2) vetor[i] = 'C';
         if (i == 3) vetor[i] = 'D';
         if (i == 4) vetor[i] = 'E';
         if (i == 5) vetor[i] = 'F';
         if (i == 6) vetor[i] = 'G';
         if (i == 7) vetor[i] = 'H';
         if (i == 8) vetor[i] = 'I';
         if (i == 9) vetor[i] = 'J';
         if (i == 10) vetor[i] = 'K';
         if (i == 11) vetor[i] = 'L';
         if (i == 12) vetor[i] = 'M';
         if (i == 13) vetor[i] = 'N';
         if (i == 14) vetor[i] = 'O';
         if (i == 15) vetor[i] = 'P';
         if (i == 16) vetor[i] = 'Q';
         if (i == 17) vetor[i] = 'R';
         if (i == 18) vetor[i] = 'S';
         if (i == 19) vetor[i] = 'T';
         if (i == 20) vetor[i] = 'U';
         if (i == 21) vetor[i] = 'V';
         if (i == 22) vetor[i] = 'W';
         if (i == 23) vetor[i] = 'X';
         if (i == 24) vetor[i] = 'Y';
         if (i == 25) vetor[i] = 'Z';
         System.out.println(i + " - " + vetor[i]);
      }
      
      return vetor;
   }
   
   private static void exercicio2_ListaDeExercíciosAlgoritmos() {
      int vetor[] = new int [100];
      for (int i = 0; i < vetor.length; i++) {
         vetor[i] = i;
         if (i % 2 == 0) {
            vetor[i] = 0;
         }
         System.out.println(vetor[i]);
      }
   }
   
   public static void exercicio1_ListaDeExercíciosAlgoritmos() {
      int vetor[] = new int[100];
      int n = vetor.length;
      
      for (int i = 0; i < n; i++) {
         vetor[i] = i;
         System.out.println(i);
      }
   }
   
   // Ex: 22, 23, 27, 28
   
   // Aquecimento
   public static void exercicio02_Aquecimento(int[] a) {
      int[] b = new int[a.length];
      
      for (int i = a.length; i > 0; i--) {
         b[i] = a[i];
         
         System.out.println("Vetor A: " + a[i]);
         System.out.println("Vetor B: " + b[i]);
      }
   }
   
   public static int[] exercicio01_Aquecimento() {
      int[] a = new int[] { 32, 45, 89, 66, 12, 35, 10, 96, 38, 15, 13, 11, 65, 81, 35, 64, 16, 89, 54, 19 };
      int[] b = new int[a.length];
      
      for (int i = 0; i < a.length; i++) {
         b[i] = a[i];
         
         //System.out.println("Vetor A: " + a[i]);
         //System.out.println("Vetor B: " + b[i]);
      }
      
      return a;
   }
      
   // Recursao Aula 01
   public static int exercicio2_Aula01MetodosRecursivos(int inicial, int razao, int valorMaximo) {
      if (inicial <= valorMaximo){
         System.out.println(inicial);
         inicial *= razao;

         return exercicio2_Aula01MetodosRecursivos(inicial, razao, valorMaximo);
      } else {
         return 0;
      }
   }
      
   public static int exercicio1_Aula01MetodosRecursivos(int numero, int quantidade) {
      if (numero <= quantidade) {
         int aux = 0;
         
         if (numero % 2 != 0) {
            aux = numero;
            System.out.println(aux);
         }
         
         numero++;
         
         return exercicio1_Aula01MetodosRecursivos(numero, quantidade);
      } else {
         return 0;
      }
   }
}