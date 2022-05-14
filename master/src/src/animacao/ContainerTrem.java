package src.animacao;

import java.awt.Color;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import src.animacao_modelo.FaseTrem;
import src.control.Control;
import src.logica.ConsumerThread;
import src.view.MainViewer;

public class ContainerTrem extends JFrame {
	/**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;

	public ContainerTrem(ConsumerThread consumer) {
		add(new FaseTrem(consumer));
		setTitle("Anime");
		setSize(1024, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(true);	//amppliar janela
		setVisible(true);
		
	}
	
}