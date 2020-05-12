import javax.swing.JOptionPane;

public class ALGESD_QuickSort2 {
   public static void main(String[] args) {
      EXEC_quickSort();
   }
   
   static void EXEC_quickSort() {
      int[] vetorA = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
      int[] vetorB = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      double[] vetorC = new double[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
      
      int[] vetorAOriginal = vetorA.clone();
      int[] vetorBOriginal = vetorB.clone();
      double[] vetorCOriginal = vetorC.clone();
      
      quickSort_Asc(vetorA, 0, vetorA.length-1);
      quickSort_Desc(vetorB, 0, vetorB.length-1);
      quickSort_Asc(vetorC, 0, vetorC.length-1);
      
      JOptionPane.showMessageDialog(null, "Seu vetor A original: " + intVectorToString(vetorAOriginal) + "\nSeu vetor A ordenado: " + intVectorToString(vetorA)
         + "\n\nSeu vetor B original: " + intVectorToString(vetorBOriginal) + "\nSeu vetor B ordenado: " + intVectorToString(vetorB)
         + "\n\nSeu vetor C original: " + doubleVectorToString(vetorCOriginal) + "\nSeu vetor C ordenado: " + doubleVectorToString(vetorC));
   }
   
   static void quickSort_Asc(double[] iVet, int iBaixo, int iAlto) {
      int iP, iB, iA;
      double iPivot;
      
      iB=iBaixo;
      iA=iAlto;
      iPivot=iVet[iBaixo];
      while (iBaixo < iAlto) {
         while ((iVet[iAlto] >= iPivot) && (iBaixo < iAlto))
            iAlto--;
         if (iBaixo != iAlto) {
            iVet[iBaixo]=iVet[iAlto];
            iBaixo++;
         }
         while ((iVet[iBaixo] <= iPivot) && (iBaixo < iAlto))
            iBaixo++;
         if (iBaixo != iAlto) {
            iVet[iAlto]=iVet[iBaixo];
            iAlto--;
         }
      }
      iVet[iBaixo]=iPivot;
      iP=iBaixo;
      iBaixo=iB;
      iAlto=iA;
      if (iBaixo < iP) quickSort_Asc(iVet, iBaixo, iP-1);
      if (iAlto > iP) quickSort_Asc(iVet, iP+1, iAlto);
   }
   
   static void quickSort_Asc(int[] iVet, int iBaixo, int iAlto) {
      int iP, iB, iA;
      int iPivot;
      
      iB=iBaixo;
      iA=iAlto;
      iPivot=iVet[iBaixo];
      while (iBaixo < iAlto) {
         while ((iVet[iAlto] >= iPivot) && (iBaixo < iAlto)) iAlto--;
         if (iBaixo != iAlto) {
            iVet[iBaixo]=iVet[iAlto];
            iBaixo++;
         }
         while ((iVet[iBaixo] <= iPivot) && (iBaixo < iAlto)) iBaixo++;
         if (iBaixo != iAlto) {
            iVet[iAlto]=iVet[iBaixo];
            iAlto--;
         }
      }
      iVet[iBaixo]=iPivot;
      iP=iBaixo;
      iBaixo=iB;
      iAlto=iA;
      if (iBaixo < iP) quickSort_Asc(iVet, iBaixo, iP-1);
      if (iAlto > iP) quickSort_Asc(iVet, iP+1, iAlto);
   }
   
   static void quickSort_Desc(int[] iVet, int iBaixo, int iAlto) {
      int iP, iB, iA;
      int iPivot;
      
      iB=iBaixo;
      iA=iAlto;
      iPivot=iVet[iBaixo];
      while (iAlto > iBaixo) {
         while ((iVet[iAlto] <= iPivot) && (iAlto > iBaixo)) iAlto--;
         if (iBaixo != iAlto) {
            iVet[iBaixo]=iVet[iAlto];
            iBaixo++;
         }
         while ((iVet[iBaixo] >= iPivot) && (iAlto > iBaixo)) iBaixo++;
         if (iBaixo != iAlto) {
            iVet[iAlto]=iVet[iBaixo];
            iAlto--;
         }
      }
      iVet[iBaixo]=iPivot;
      iP=iBaixo;
      iBaixo=iB;
      iAlto=iA;
      if (iBaixo > iP) quickSort_Desc(iVet, iP+1, iBaixo);
      if (iAlto < iP) quickSort_Desc(iVet, iAlto, iP-1);
   }
   
   static String intVectorToString(int[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
   
   static String doubleVectorToString(double[] vetor) {
      String str = ""; for (int i = 0; i < vetor.length; i++) if ((i + 1) == vetor.length) str += vetor[i]; else str += vetor[i] + ", ";
      return str;
   }
}