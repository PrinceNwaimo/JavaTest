package diettel8;

public class IntegerSet {
    private boolean[] set;

    public IntegerSet() {
        set = new boolean[101]; // 0 to 100
    }

    public void insertElement(int element) {
        if (element >= 0 && element <= 100) {
            set[element] = true;
        }
    }

    public void deleteElement(int element) {
        if (element >= 0 && element <= 100) {
            set[element] = false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean isEmpty = true;

        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                if (!isEmpty) {
                    sb.append(", ");
                }
                sb.append(i);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            sb.append("---");
        }

        sb.append("}");
        return sb.toString();
    }

    public IntegerSet union(IntegerSet other) {
        IntegerSet unionSet = new IntegerSet();

        for (int i = 0; i < set.length; i++) {
            if (set[i] || other.set[i]) {
                unionSet.insertElement(i);
            }
        }

        return unionSet;
    }

    public IntegerSet intersection(IntegerSet other) {
        IntegerSet intersectionSet = new IntegerSet();

        for (int i = 0; i < set.length; i++) {
            if (set[i] && other.set[i]) {
                intersectionSet.insertElement(i);
            }
        }

        return intersectionSet;
    }

    public boolean isEqualTo(IntegerSet other) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] != other.set[i]) {
                return false;
            }
        }

        return true;
    }
}
