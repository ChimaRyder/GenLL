public class MyCatList {
    Cat[] array;
    int size;
    static int capacity = 5;

    public MyCatList() {
        this.size = 0;
        this.array = new Cat[capacity];
    }

    void add (Cat c) throws ArrayFullException {
        try {
            array[size++] = c;
        } catch (ArrayIndexOutOfBoundsException e) {
            size--;
            throw new ArrayFullException("The array is full and " + c.name + " cannot be inserted.");
        }
    }

    void addAt(int pos, Cat c) throws ArrayFullException {
        if (pos < 1 || pos > size + 1) {
            throw new InvalidPositionException("Position must be between 1 and " + (size+1));
        }

        if (size() >= 5) {
            throw new ArrayFullException("The array is full and " + c.name + " cannot be inserted.");
        }

        for (int i = size; i >= pos; i--) {
            array[i] = array[i-1];
        }

        array[pos-1] = c;
        size++;

    }

    boolean remove (String name) {
        for (int i = 0; i < size; i++) {
            if (array[i].name.equals(name)) {
                size--;
                for (int j = i; j < size; j++) {
                    array[j] = array[j+1];
                }

                return true;
            }
        }

        return false;
    }

    Cat removeAt (int pos) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        Cat temp = array[pos-1];
        for (int i = pos-1; i < size; i++) {
            array[i] = array[i+1];
        }

        size--;
        return temp;
    }

    boolean contains(String name) {
        for (int i = 0; i < size; i++) {
            if (array[i].name.equals(name)) {
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

    Cat get (int pos) {
        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        return array[pos-1];
    }

    Cat set (int pos, Cat c) {
        if (pos < 0 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        Cat temp = array[pos-1];
        array[pos-1] = c;
        return temp;
    }


}
