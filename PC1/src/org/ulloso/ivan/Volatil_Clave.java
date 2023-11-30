package org.ulloso.ivan;

public class Volatil_Clave {

	public static void main(String[] args) {

		Buffer buffer = new Buffer(50);

		for (int numThreads = 0; numThreads < 1; numThreads++) {
			Thread remove = new Thread(() -> {
				for (;;) 
					buffer.remove();					
			});
			Thread add = new Thread(() -> {
				for (;;)
					buffer.set();
			});
			remove.start();
			add.start();
		}
	}
}
