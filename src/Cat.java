public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof String) {
            return  obj == name;
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
