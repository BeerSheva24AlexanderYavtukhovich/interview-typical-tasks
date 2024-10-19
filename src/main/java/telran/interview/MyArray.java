package telran.interview;

public class MyArray<T> {
    private final Object[] array;
    private Object setAllValue;
    private boolean isSetAll;

    public void setAll(T value) {
        setAllValue = value;
        isSetAll = true;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = value;
        isSetAll = false;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return isSetAll ? (T) setAllValue : (T) array[index];

    }

    public MyArray(int size) {
        array = new Object[size];
        setAllValue = null;
        isSetAll = false;
    }
}