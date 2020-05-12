/*
 * ALGED - Lista Ex - 1o Sem - Ex42
 *
 *	Busca Binária Completa e Crescente em vetor char de tamanho fixo
 */
import	javax.swing.*;

public class ALGED_Lista_Ex_1o_Sem_Ex42
{
	public static void main(String Args[])
	{
		int	iTAM=10;	// <----------- Alterar o tamanho do vetor apenas aqui
		char	cVetor[]=new char[iTAM];

		String	sIO,sTitle;
		int	iPos;
		char	cN;
	
		sTitle="ALGED-Ex42";
		sIO="Busca Binária Completa e Crescente em vetor char de tamanho fixo";
		JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.PLAIN_MESSAGE);
		digita_vetor(cVetor);
		sTitle="Digite";
		sIO="Caractere de busca binária:";
		sIO=JOptionPane.showInputDialog(null,sIO,sTitle,JOptionPane.QUESTION_MESSAGE);
		cN=sIO.charAt(sIO.length()-1);
		iPos=busca_binaria(cVetor,cN);
		if(iPos < 0)
		{
			sTitle="Atenção";
			sIO="O caractere de busca binária não se encontra no vetor";
			JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			sTitle="Resultado";
			sIO="O caractere de busca binária "+cN+" está no índice "+iPos+" do vetor.";
			JOptionPane.showMessageDialog(null,sIO,sTitle,JOptionPane.INFORMATION_MESSAGE);
		}
		System.exit(0);
	}

	public static void digita_vetor(char cVet[])
	{
		String	sIO,sTitle;
		int	iI;
		
		for(iI=0;iI<cVet.length;iI++)
		{
         String sTeste;
         
			sTitle="Digite";
			sIO="Elemento de índice "+iI+"/"+(cVet.length-1);
			sIO=JOptionPane.showInputDialog(null,sIO,sTitle,JOptionPane.QUESTION_MESSAGE);
			cVet[iI]=sIO.charAt(sIO.length()-1);
		}
	}
	
	public static int busca_binaria(char cVet[], char cK)
	{
		int  iBaixo, iAlto, iMeio;

		iBaixo=0;
		iAlto=cVet.length-1;
		while(iBaixo <= iAlto)
		{
			iMeio=(iBaixo+iAlto)/2;
			if(cK < cVet[iMeio])	iAlto=iMeio-1;
			else	if(cK > cVet[iMeio])	iBaixo=iMeio+1;
					else	return iMeio;
		}
		return	-1;
	}
	
}// Fecha classe