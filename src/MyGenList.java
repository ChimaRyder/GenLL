public class MyGenList <E> {
    E[] array;
    int size;


    public MyGenList() {
        this.size = 0;
        this.array = (E[]) new Object[5];
    }

    void add (E o) throws ArrayFullException {
        try {
            array[size++] = o;
        } catch (ArrayIndexOutOfBoundsException e) {
            size--;
            throw new ArrayFullException("The array is full and " + o + " cannot be inserted.");
        }
    }

    void addAt(int pos, E o) throws ArrayFullException {
        if (pos < 1 || pos > size + 1) {
            throw new InvalidPositionException("Position must be between 1 and " + (size+1));
        }

        if (size() >= 5) {
            throw new ArrayFullException("The array is full and " + o + " cannot be inserted.");
        }

        for (int i = size; i >= pos; i--) {
            array[i] = array[i-1];
        }

        array[pos-1] = o;
        size++;

    }

    boolean remove (Object name) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(name)) {
                size--;
                for (int j = i; j < size; j++) {
                    array[j] = array[j+1];
                }

                return true;
            }
        }

        return false;
    }

    E removeAt (int pos) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        E temp = array[pos-1];
        for (int i = pos-1; i < size; i++) {
            array[i] = array[i+1];
        }

        size--;
        return temp;
    }

    boolean contains(Object name) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    int size() {
        return size;
    }
    boolean isEmpty() {
        return size == 0;
    }

    E get (int pos) {
        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        return array[pos-1];
    }

    E set (int pos, E e) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        E temp = array[pos-1];
        array[pos-1] = e;
        return temp;
    }


}
