package src.animacao;

import java.awt.Color;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JProgressBar;

import src.animacao_modelo.Fase;
import src.logica.Executor;
import src.logica.ProducerThread;


public class Container extends JFrame {
	private static final long serialVersionUID = 1L;
	

	public Container(ArrayList<ProducerThread> list) {
		
		add(new Fase(list));
		setTitle("Empacotador");
		setSize(315, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	

	
	public static void main(String []args) {
//		new Container();
//		
//		Fase f = new Fase();;
//		f.setSinal(true);
		
	}
	
//	public void ChamaTrem() {
//		add(new Fase());
//	}
}

