package diettel8;

public class IntegerSet2 {
    private boolean[] set;

    public IntegerSet2() {
        set = new boolean[101];
    }

    public void insertElement(int k) {
        if (k >= 0 && k <= 100) {
            set[k] = true;
        }
    }

    public void deleteElement(int m) {
        if (m >= 0 && m <= 100) {
            set[m] = false;
        }
    }

    public static IntegerSet2 union(IntegerSet2 set1, IntegerSet2 set2) {
        IntegerSet2 unionSet = new IntegerSet2();

        for (int i = 0; i < 101; i++) {
            if (set1.set[i] || set2.set[i]) {
                unionSet.insertElement(i);
            }
        }

        return unionSet;
    }

    public static IntegerSet2 intersection(IntegerSet2 set1, IntegerSet2 set2) {
        IntegerSet2 intersectionSet = new IntegerSet2();

        for (int i = 0; i < 101; i++) {
            if (set1.set[i] && set2.set[i]) {
                intersectionSet.insertElement(i);
            }
        }

        return intersectionSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean isEmpty = true;
        for (int i = 0; i < 101; i++) {
            if (set[i]) {
                sb.append(i).append(" ");
                isEmpty = false;
            }
        }

        if (isEmpty) {
            sb.append("---");
        }

        return sb.toString().trim();
    }

    public boolean isEqualTo(IntegerSet2 other) {
        for (int i = 0; i < 101; i++) {
            if (set[i] != other.set[i]) {
                return false;
            }
        }

        return true;
    }
}
