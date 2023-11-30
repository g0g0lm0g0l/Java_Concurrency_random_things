package org.ullo.so;

import java.util.Arrays;
import java.util.Random;

public class Productor_Consumidor {
	private static final int TAMANIO = 50;

	public static void main(String[] args) {
		Random random = new Random();
		Buffer buffer = new Buffer(TAMANIO);
		Thread productor = new Productor(buffer, random.nextInt(0, TAMANIO));
		Thread consumidor = new Consumidor(buffer, random.nextInt(0, TAMANIO));
		productor.start();
		consumidor.start();
		
	}
}

class Buffer {
	int[] buffer;
	int tamanio;

	public Buffer(int tamanio) {
		super();
		this.buffer = new int[tamanio];
	}

	public void consumir(int i) {
		for (int j = 0; j < i; j++) {
			buffer[j] = 0;
		}
		System.out.println(Arrays.toString(buffer));
	}

	public void producir(int i) {
		for (int j = 0 ; j < i && buffer[j] == 0; j++) {
			buffer[j] = 4;
		}
		System.out.println(Arrays.toString(buffer));
	}
}

class Productor extends Thread {
	Buffer buffer;
	int numProducir;

	public Productor(Buffer buffer, int numProducir) {
		super();
		this.buffer = buffer;
		this.numProducir = numProducir;
	}

	@Override
	public void run() {
		for (;;) {
			buffer.producir(numProducir);
		}
	}
}

class Consumidor extends Thread {
	Buffer buffer;
	int numConsumir;

	public Consumidor(Buffer buffer, int numConsumir) {
		super();
		this.buffer = buffer;
		this.numConsumir = numConsumir;
	}

	@Override
	public void run() {
		for (;;) {
			buffer.consumir(numConsumir);
		}
	}
}
