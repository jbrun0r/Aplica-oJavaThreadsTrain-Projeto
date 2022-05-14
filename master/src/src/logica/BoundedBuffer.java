package src.logica;

import java.util.concurrent.Semaphore;
import src.telaBuffer.BarraDeProgresso;

public class BoundedBuffer {
	
	private int buffer;
	public int capacity;
	private Semaphore mutex;
	public Semaphore empty;
	private Semaphore full;
	
	//Initialize everything in the constructor
	public BoundedBuffer(int size) {
		mutex = new Semaphore(1);
		full = new Semaphore(0);
		empty = new Semaphore(size);
		buffer = 0;
		capacity = size;
	}
	
	//Add in item to tail of the circular array
	public void addItem() {
		buffer = buffer + 1;
		BarraDeProgresso.barra.setValue((buffer));
		BarraDeProgresso.barra.setString("Ocupando "+ buffer+"/"+Executor.bufferSize);
		
		if(buffer==Executor.bufferSize) {
			BarraDeProgresso.barra.setString("Depósito Cheio");
		}
	}
	public void printBuffer() {
		System.out.println("Restam: " + buffer);
	}
	
	//Remove and return an item from the head of the circular array
	public void removeItem(int quantd) {
		buffer = buffer - quantd;
		BarraDeProgresso.barra.setValue(buffer);
		BarraDeProgresso.barra.setString("Ocupando "+ buffer+"/"+Executor.bufferSize);
		
		if(buffer==Executor.bufferSize) {
			BarraDeProgresso.barra.setString("Depósito Cheio");
		}
	}
	
	//If the full semaphore has no permits, the buffer is empty
	public boolean isEmpty() {
		return full.availablePermits() == 0;
	}
	
	public int current() {
		return buffer;
	}
	
	//Just mutators for the semaphores. Preserving encapsulation or whatever
	public void acquireEmpty() throws InterruptedException {
		empty.acquire();
	}
	
	public void releaseEmpty(int quant) {
		empty.release(quant);
	}
	
	public void acquireFull(int quant) throws InterruptedException {
		System.out.println("Full antes de acquire: " +full.availablePermits());
		full.acquire(quant);
		System.out.println("Full depois de acquire: " +full.availablePermits());
	}
	
	public void releaseFull() {
		System.out.println("Full antes do release : " + full.availablePermits());
		full.release();			
		System.out.println("Full depois do release : " + full.availablePermits());
	}
	
	public void acquireMutex() throws InterruptedException {
		mutex.acquire();
	}
	
	public void releaseMutex() {
		mutex.release();
	}
	
}
