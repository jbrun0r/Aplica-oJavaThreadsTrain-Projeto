package src.telaBuffer;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import src.logica.Executor;

public class BarraDeProgresso extends JFrame {

	private Executor executor;		//será usado para get em class Executor tamanho do buffer
	public static JProgressBar barra = new JProgressBar(0,(Executor.getWagonCapacity()));


	public BarraDeProgresso() {
		configurarJanela();
		barra.setBounds(10, 10, 280, 40);
		barra.setStringPainted(true); //mostra a %
		barra.setValue(0);
		barra.setMinimum(0);
		barra.setMaximum(executor.getBufferSize());		//Recebe o tamanho do buffer de executor
		barra.setForeground(Color.GRAY);
		//barra.setFont(new Font("MV Boli",Font.BOLD,20));
		barra.setBackground(Color.white);
		
		add(barra);
		
		
		
	}
	
	public void configurarJanela( ) {
		setTitle("Capacidade Depósito");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(315,100);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	//	new BarraDeProgresso();
	}
	
	public class Func {
		public void run() {
		}
		
	}
	
	public void Incrementa() {
		barra.setValue(barra.getValue()+1);
	}
	
	public void Descrementa() {
		barra.setValue(barra.getValue()-(executor.getWagonCapacity()));
	}
	
}