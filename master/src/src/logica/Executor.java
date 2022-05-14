package src.logica;

import java.util.ArrayList;
import src.telaBuffer.BarraDeProgresso;

import src.animacao.Container;
import src.animacao.ContainerTrem;

public class Executor {
	
	private static ArrayList<ProducerThread> producerThreads;
	private static ArrayList<ConsumerThread> consumerThreads;
	//private static int[] timesToProduce;
	public static int numProducers;
	public static int numConsumers;
	public static int bufferSize;
//	public static int timeToProduce;
	public static int timeToTravel;
	public static int wagonCapacity;
	public static ArrayList<Integer> timesToProduce = new ArrayList<>();
	
	//This class simply contains the main method for the program
	//It didn't really seem like it belonged in bounded buffer and it
	//  was easier to manage over here, so there you go
	public static void main(String[] args) throws InterruptedException {
		//Parse the arguments
		//int[] timesToProduce = {1,1,5};
		//numProducers = Integer.parseInt("3");
		//numConsumers = Integer.parseInt("1");
		//bufferSize = Integer.parseInt("12");
		//timeToProduce = Integer.parseInt("2");
		//timeToTravel = Integer.parseInt("5");
		//wagonCapacity = Integer.parseInt("10");
		
		
		System.out.println("NumProducers: "+numProducers);
		System.out.println("timesToProduce: "+timesToProduce);
		
		System.out.println("numConsumers: "+numConsumers);
		System.out.println("bufferSize: "+bufferSize);
		System.out.println("timeToTravel: "+timeToTravel);
		System.out.println("wagonCapacity: "+wagonCapacity);
		
		BarraDeProgresso Executor = new BarraDeProgresso();
		Executor.main(args);
		
		
		//Create a new buffer of the appropriate size
		BoundedBuffer buffer = new BoundedBuffer(bufferSize);
		//Create and start the producers
		producerThreads = new ArrayList<ProducerThread>(numProducers);
		for(int i = 0; i < numProducers; i++) {
			ProducerThread producer = new ProducerThread(buffer, timesToProduce.get(i), i, (i + 1) * 50);
			producerThreads.add(producer);
			//producer.start();
		}
		//Create and start the consumers
		ConsumerThread consumer = new ConsumerThread(buffer,1,timeToTravel,wagonCapacity);
		new ContainerTrem(consumer);
		new Container(producerThreads);
	
	}

	public static int getNumConsumers() {
		return numConsumers;
	}

	public static void setNumConsumers(int numConsumers) {
		Executor.numConsumers = numConsumers;
	}

	public static void setProducerThreads(ArrayList<ProducerThread> producerThreads) {
		Executor.producerThreads = producerThreads;
	}

	public static void setConsumerThreads(ArrayList<ConsumerThread> consumerThreads) {
		Executor.consumerThreads = consumerThreads;
	}

	public static void setNumProducers(int numProducers) {
		Executor.numProducers = numProducers;
	}

	public static void setBufferSize(int bufferSize) {
		Executor.bufferSize = bufferSize;
	}

//	public static void setTimeToProduce(int timeToProduce) {
//		Executor.timeToProduce = timeToProduce;
//	}

	public static void setTimeToTravel(int timeToTravel) {
		Executor.timeToTravel = timeToTravel;
	}

	public static void setWagonCapacity(int wagonCapacity) {
		Executor.wagonCapacity = wagonCapacity;
	}

	public static void setTimesToProduce(ArrayList<Integer> timesToProduce) {
		Executor.timesToProduce = timesToProduce;
	}

	public static int getBufferSize() {
		return bufferSize;
	}

	public static int getWagonCapacity() {
		return wagonCapacity;
	}
	
	
}

//producerThreads = new ArrayList<ProducerThread>(numProducers);
//for(int i = 0; i < numProducers; i++) {
	//ProducerThread producer = new ProducerThread(buffer, timeToProduce, i);
	//producerThreads.add(producer);
	//producer.start();
//}
//Create and start the consumers
//for(int i = 0; i < numConsumers; i++) {
//	ConsumerThread consumer = new ConsumerThread(buffer,i,timeToTravel,wagonCapacity);
//	consumer.start();
//}

