package src.logica;

import java.util.concurrent.TimeUnit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import src.animacao_modelo.FaseTrem;

public class ConsumerThread extends Thread {
	
	private int consumerNumber;
	private int wagonToTravel;
	public int timeToTravel;
	private BoundedBuffer buffer;
	private int x, y;
	private double dx, dy;
	private Image imagem;
	private double altura, largura;
	private int call;
	private int flag;
	private int time;
	private double totalMoved;
	private boolean start;
	private FaseTrem fas;
	
	//Initialize variables in constructor
	public ConsumerThread(BoundedBuffer buffer, int consumerNumber, int timeToTravel, int wagonToTravel) {
		this.buffer = buffer;
		this.consumerNumber = consumerNumber;
		this.wagonToTravel = wagonToTravel;
		this.timeToTravel = timeToTravel;
		this.call = 0;
		this.x = 0; //1375 1010 - Trem com vag�o some
		//this.x = -300; // Volta
		this.y = 638;
		this.time = timeToTravel;
		this.start = false;
		this.totalMoved = 0;
	}
	
	public void run() {
		while(true) {
			//Wait until the buffer is not empty
			try {
				buffer.acquireFull(wagonToTravel);
				buffer.acquireMutex();
				System.out.println("HIIII");
				System.out.println("Retirando: " + wagonToTravel);
				buffer.removeItem(wagonToTravel);
				buffer.releaseMutex();
				buffer.releaseEmpty(wagonToTravel);
				wait(timeToTravel);
				if(totalMoved < 0) {
					this.totalMoved = 0;
					this.x = 0;
				}
				System.out.println("Cheguei em A");
			} catch (InterruptedException e) {
				//Exit notice, print anything remaining in the box, die
				System.out.println("Thread " + consumerNumber + " exit");
				break;
			}
		}
	}
	
	public void setFas(FaseTrem fas)
	{
		this.fas = fas;
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon(ConsumerThread.class.getResource("/imagens/trem_comvagao (1).png"));
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void update(FaseTrem fas,int times) {
		totalMoved = totalMoved + (times * dx);
		System.out.print("Movido: ");
		System.out.println(totalMoved);
		x = ((int) totalMoved);
//		this.setX(x+=dx);
		y +=dy;
		System.out.print("X: ");
		System.out.println(getX());
		fas.repaint();
	}

	public boolean loaded() {
		return this.start;
	}
	private boolean wait(int timeToTravel) {
		long time = System.currentTimeMillis();
		long time2 = time; 
		this.x = 0;
		this.totalMoved = 0;
		setDx(false);
		changeImagem(true);
		while(System.currentTimeMillis() - time < timeToTravel * 1000) {
			while(System.currentTimeMillis() - time2 < 10) {}
			time2 = System.currentTimeMillis();
			update(fas,10);
			//System.out.println(call);
		}
		this.call = 0;
		System.out.println("Passou primeira parte");
		time = System.currentTimeMillis();
		time2 = time;
		setDx(true);
		changeImagem(false);
		this.x = 810;
		this.totalMoved = 810;
		while(System.currentTimeMillis() - time < timeToTravel * 1000) {
			while(System.currentTimeMillis() - time2 < 10) {}
			time2 = System.currentTimeMillis();
			update(fas,10);
		}
		// Atualizar a cada x ms, encontrar quanto que atualiza a cada 1ms
		// mas atualizar somente a cada y ms, o que faria o valor de 
		// att ser y * dx;
		return true;
	}	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public void changeImagem(boolean going) {
		if(going) {
			ImageIcon referencia = new ImageIcon(ConsumerThread.class.getResource("/imagens/trem_comvagao (1).png"));
			imagem = referencia.getImage();
			this.setImagem(imagem);
		} else {
			ImageIcon referencia = new ImageIcon(ConsumerThread.class.getResource("/imagens/trem_sem_vagao.png"));
			imagem = referencia.getImage();
			this.setImagem(imagem);			
		}
	}
	
	public void setImagem(Image newImage) {
		this.imagem = newImage;
	}

	public void setDx(boolean going) {
		if(!going) {
			this.dx = (double) (600 - 0) / (timeToTravel * 1000 );			
		} else {
			//System.out.println(timeToTravel * (( 1010 - (- 410) ) / 1000 ));
			this.dx = (double)  (0 - (820)) / (timeToTravel * 1000 );
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getLargura() {
		return largura;
	}
	
}