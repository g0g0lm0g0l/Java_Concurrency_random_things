package org.ulloso.ivan;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
	List<Object> list;

	public Buffer(int tamanio) {
		list = new ArrayList<Object>();
	}

	public synchronized void remove() {
		try {
			if (!list.isEmpty()) {
				list.remove(list.size() - 1);
				this.notifyAll();
				Thread.sleep(10);
			} else {
				this.wait();
			}
			System.out.println(list.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void set() {
		try {
			if (list.size() == 50) {
				this.wait();
			} else {
				list.add(1);
				this.notifyAll();
				Thread.sleep(10);
			}
			System.out.println(list.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
