public class MyList {
    int[] array;
    int size;
    static int capacity = 5;

    public MyList() {
        this.size = 0;
        this.array = new int[capacity];
    }

    void add (int num) throws ArrayFullException {
        try {
            array[size++] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            size--;
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
        }
    }

    void addAt(int pos, int num) throws ArrayFullException {
            if (pos < 1 || pos > size + 1) {
                throw new InvalidPositionException("Position must be between 1 and " + (size+1));
            }

            if (size() >= 5) {
                throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
            }

            for (int i = size; i >= pos; i--) {
                array[i] = array[i-1];
            }

            array[pos-1] = num;
            size++;

    }

    boolean remove (int num) {
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                size--;
                for (int j = i; j < size; j++) {
                    array[j] = array[j+1];
                }

                return true;
            }
        }

        return false;
    }

    int removeAt (int pos) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        int temp = array[pos-1];
        for (int i = pos-1; i < size; i++) {
             array[i] = array[i+1];
        }

        size--;
        return temp;
    }

    boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
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

    int get (int pos) {
        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        return array[pos-1];
    }

    int set (int pos, int num) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        int temp = array[pos-1];
        array[pos-1] = num;
        return temp;
    }


}
