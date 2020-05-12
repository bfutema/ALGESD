package view;

import javax.swing.JOptionPane;

public class LSEViewEx24 {
	private String[] 	sSN 	= { "Sim", "Não" };
	private String 		sIO 	= "Selecione a opção desejada: ";
	private String		sExit 	= "Deseja sair?";
	
	public void show(String sTitle, String sI) {
		JOptionPane.showMessageDialog(null, sI, sTitle, JOptionPane.PLAIN_MESSAGE);
	}
	
	public String receive(String sTitle, String sI) {
		return JOptionPane.showInputDialog(null, sI, sTitle, JOptionPane.QUESTION_MESSAGE);
	}
	
	public int menu(String sTitle, String[] sOptions) {
		int iOption, iSN;
		
		do {
			iOption = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sOptions, null);
			
			if (iOption == sOptions.length-1) {
				iSN = JOptionPane.showOptionDialog(null, sExit, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sSN, null);
				
				if (iSN == 1) iOption = -1;
			}
		} while (iOption < 0 || iOption > sOptions.length-1);
		
		return iOption;
	}
}
