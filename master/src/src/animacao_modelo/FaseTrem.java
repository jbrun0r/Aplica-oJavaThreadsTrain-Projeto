package src.animacao_modelo;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import src.animacao.modelo.Trem;
import src.logica.ConsumerThread;

public class FaseTrem extends JPanel {
	private Image fundo;
	private Timer timer;
	private int i = 0;
	public ConsumerThread tr;
	
	public FaseTrem(ConsumerThread tremThread) {
		
		setFocusable(true);
		setDoubleBuffered(true);
		this.tr = tremThread;
		tr.setFas(this);
		ImageIcon referencia = new ImageIcon(FaseTrem.class.getResource("/imagens/fundo.png"));
		fundo = referencia.getImage();	
		//timer = new Timer(1, this);
		// A cada 1 mili segundo, ele vai executar essa bagaça
		// Então eu quero que em 1 segundo que é 1000 mili segundo ele percorra toda a tela
		// Para percorrer toda a tela eu tenho que andar 1410px a partir de onde a imagem foi criada
		// Ou seja que a cada 1 mili segundo eu tenho que somar x a posição inicial que é -410px para que ele alcance em 1410px em 1000 iterações
		//timer.start();
		tr.load();
		tr.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(this.tr.getImagem(), this.tr.getX(), this.tr.getY(), this);
		g.dispose();
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(this.tr.loaded()) {
//			if(this.tr.getX() <= 1210 && i == 0) { 
//				this.tr.setDx(tr.timeToTravel,false);
//				this.tr.changeImagem(true);
//				this.tr.update(this);
//			} else {
//				i = 1;
//			}
//			if(i == 1 && this.tr.getX() >= -410) {
//				this.tr.setDx(-tr.timeToTravel,true);
//				this.tr.changeImagem(false);
//				this.tr.update(this);
//			} else {
//				i = 0;
//			}
//		}
		
//		i++;
//		
//		if(i==((trem.getLargura()+trem.getLargura())+350)){
//			i=0;
//			flag = -flag;
//			System.out.println(System.currentTimeMillis());
//		}
		
		
	}