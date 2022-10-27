package src.logica;

import java.util.concurrent.TimeUnit;


import javax.swing.ImageIcon;

import src.animacao_modelo.Fase;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProducerThread extends Thread {
	
	private int productCount = 1;
	private BoundedBuffer buffer;
	private int timeToProduce;
	private int producerNumber;
	private long t = 5L;
	public int x, y;
	private double dx, dy;
	private Fase fas;
	private Image imagem;
	private ImageIcon empacotador = new ImageIcon(ProducerThread.class.getResource("/imagens/empacotador.png"));
	private ImageIcon empacotador_voltando = new ImageIcon(ProducerThread.class.getResource("/imagens/empacotador_voltando.png"));
	private ImageIcon empacotador_dormindo = new ImageIcon(ProducerThread.class.getResource("/imagens/empacotador_dormindo.png"));
	private int altura, largura;
	private double totalMoved;
	//Initialize in constructor
	public ProducerThread(BoundedBuffer buffer, int timeToProduce, int producerNumber,int y) {
		this.buffer = buffer;
		this.timeToProduce = timeToProduce;
		this.producerNumber = producerNumber;
		this.x = 25; // x = 250 max
		this.y = y;
		this.totalMoved = 25;
	}
	
	public void run() {
		while(true) { // Nunca vai parar
			try {
				//Wait until the buffer is not full
				if(buffer.empty.availablePermits() != 0) { 
					setImagem("trabalhar"); 
					System.out.println("!=0");
					fas.repaint();
				} else {
					System.out.println("else");
					setImagem("dormindo");
					fas.repaint();
				}
				buffer.acquireEmpty();
				setImagem("trabalhar");
				wait(timeToProduce);
				if(x != 25) {
					this.x = 25;
					this.totalMoved = 25;
					fas.repaint();
				}
				buffer.acquireMutex();
				//Wait until no one else is using it and prevent other access
				//Add the produced item
				System.out.println("Adicionando ao buffer");
				buffer.addItem();
				System.out.println("Buffer depois de adicionado:");
				buffer.printBuffer();
				//Release semaphores
				buffer.releaseFull();			
				buffer.releaseMutex();					
			} catch (InterruptedException e) {
				//Should never happen. Prints out if it does.
				System.out.println("Producer thread interrupted!");
			}
		}
	}
	
	public void load() {
		this.imagem = empacotador.getImage();
	}
	
	public Image getImage() {
		return this.imagem;
	}
	
	public void setFas(Fase fas) {
		this.fas = fas;
	}

	public void update(Fase fas,int times) {
		totalMoved = totalMoved + (times * dx);
		x = ((int) totalMoved);
		System.out.print("Posição X: ");
		System.out.println(x);
		System.out.print("Posição Total: ");
		System.out.println(totalMoved);
//		thiss.setX(x+=dx);
		y +=dy;
		fas.repaint();
	}
	
	public void setImagem(String name) {
		if(name == "dormindo") {
			System.out.println("A mimir");
			this.imagem = empacotador_dormindo.getImage();
			this.fas.repaint();
		} else if (name == "trabalhar") {
			System.out.println("A ir");
			this.imagem = empacotador.getImage();
			this.fas.repaint();
		} else if (name == "voltando") {
			System.out.println("A voltar");
			this.imagem = empacotador_voltando.getImage();
			this.fas.repaint();
		}
	}
	public void setDx(boolean going) {
		if(!going) {
			System.out.println((double) (250) - 25 / (float) ((timeToProduce/2) * 1000 ));
			this.dx = (double) (250 - (25)) / (timeToProduce/2 * 1000 );
		} else {
			//System.out.println(timeToTravel * (( 1010 - (- 410) ) / 1000 ));
			System.out.println((double)  ((25 - (250)) / ((timeToProduce/2) * 1000 )));
			this.dx = (double) (25 - (250)) / (timeToProduce/2 * 1000 );
		}
	}
	
	private boolean wait(int timeToProduce) {
		long time = System.currentTimeMillis();
		long time2 = time; 
		if(timeToProduce == 1) {
			setImagem("trabalhando");
			while(System.currentTimeMillis() - time < 500) {
				while(System.currentTimeMillis() - time2 < 10) {}
				time2 = System.currentTimeMillis();
				this.dx = (double) (255 - (25)) / 500;
				update(fas,10);
				//System.out.println(call);
			}
			System.out.println("Passou primeira parte");
			time = System.currentTimeMillis();
			time2 = time;
			setImagem("voltando");
			while(System.currentTimeMillis() - time < 500) {
				while(System.currentTimeMillis() - time2 < 10) {}
				time2 = System.currentTimeMillis();
				this.dx =  -(double) (255 - (25)) / 500;
				update(fas,10);
			}
		} else {
			setDx(false);
			setImagem("trabalhando");
			while(System.currentTimeMillis() - time < (timeToProduce/2) * 1000) {
				while(System.currentTimeMillis() - time2 < 10) {}
				time2 = System.currentTimeMillis();
				update(fas,10);
				//System.out.println(call);
			}
			System.out.println("Passou primeira parte");
			time = System.currentTimeMillis();
			time2 = time;
			setDx(true);
			setImagem("voltando");
			while(System.currentTimeMillis() - time < (timeToProduce/2) * 1000) {
				while(System.currentTimeMillis() - time2 < 10) {}
				time2 = System.currentTimeMillis();
				update(fas,10);
			}
		}

		// Atualizar a cada x ms, encontrar quanto que atualiza a cada 1ms
		// mas atualizar somente a cada y ms, o que faria o valor de 
		// att ser y * dx;
		return true;
	}		
}
