package telran.interview;

import java.util.HashMap;

public class MyArray<T> {
	private final int size;
	private T defaultValue;
	private final HashMap<Integer, T> array;

	public void setAll(T value) {
		this.defaultValue = value;
		this.array.clear();
	}

	public void set(int index, T value) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		array.put(index, value);
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array.getOrDefault(index, defaultValue);
	}

	public MyArray(int size) {
		this.size = size;
		this.defaultValue = null;
		this.array = new HashMap<>();
	}
}