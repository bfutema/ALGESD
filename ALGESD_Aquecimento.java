import javax.swing.JOptionPane;

public class ALGESD_Aquecimento {
   public static void main(String[] args) {
      String[] str = handleConcatenate(ex3(handleCreateVector()));
      JOptionPane.showMessageDialog(null, "Vetor a: " + str[0] + "\nVetor b: " + str[1]);
   }
   
   static int[] handleCreateVector() {
      return new int[] { 32, 45, 89, 66, 12, 35, 10, 96, 38, 15, 13, 11, 65, 81, 35, 64, 16, 89, 54, 19 };
   }
   
   static String[] handleConcatenate(int[][] matriz) {
      String[] str = new String[2];
      
      for (int i = 0; i < matriz.length; i++) {
         String strVector = "";
         
         for (int j = 0; j < matriz[i].length; j++) {
            if ((i + 1) == matriz[i].length) strVector += matriz[i][j];
            else strVector += matriz[i][j] + ", ";
         }
         
         str[i] = strVector;
      }
      
      return str;
   }
   
   static int[][] ex1(int[] a) {
      int[][] matriz = { a, new int[a.length] };
      
      for (int i = 0; i < a.length; i++) matriz[1][i] = a[i];
      
      return matriz;
   }
   
   static int[][] ex2(int[] a) {
      int[][] matriz = { a, new int[a.length] };
      int count = 0;
      
      for (int i = (a.length - 1); i >= 0; i--) {
         matriz[1][count] = a[i];
         count++;
      }
      
      return matriz;
   }
   
   static int[][] ex3(int[] a) {
      int[][] matriz = { a, new int[a.length] };
      int max = 0;
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i];
            matriz[1][i] = a[i];
         }
         else matriz[1][i] = a[i];
      }
      
      matriz[1][0] = max;
      
      return matriz;
   }
}