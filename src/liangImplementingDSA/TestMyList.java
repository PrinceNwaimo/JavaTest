package liangImplementingDSA;

public class TestMyList {
    public static void main(String[] args) {
        MyList<String> list1 = new MyArrayList<>(new String[] {"Tom", "George", "Peter", "Jean", "Jane"});
        MyList<String> list2 = new MyArrayList<>(new String[] {"Tom", "George", "Michael", "Michelle", "Daniel"});

        System.out.println("Initial list1: " + list1);
        System.out.println("Initial list2: " + list2);

        // Test addAll
        list1.addAll(list2);
        System.out.println("After list1.addAll(list2): list1 = " + list1);
        System.out.println("list2 = " + list2);

        // Recreate list1 and list2
        list1 = new MyArrayList<>(new String[] {"Tom", "George", "Peter", "Jean", "Jane"});
        list2 = new MyArrayList<>(new String[] {"Tom", "George", "Michael", "Michelle", "Daniel"});

        // Test removeAll
        list1.removeAll(list2);
        System.out.println("After list1.removeAll(list2): list1 = " + list1);
        System.out.println("list2 = " + list2);

        // Recreate list1 and list2
        list1 = new MyArrayList<>(new String[] {"Tom", "George", "Peter", "Jean", "Jane"});
        list2 = new MyArrayList<>(new String[] {"Tom", "George", "Michael", "Michelle", "Daniel"});

        // Test retainAll
        list1.retainAll(list2);
        System.out.println("After list1.retainAll(list2): list1 = " + list1);
        System.out.println("list2 = " + list2);
    }
}
