package liangSortingAlgorithms;

import java.util.ArrayList;

//public class Heap4 <E extends Comparable<E>> implements Cloneable{

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        Heap<E> newHeap = (Heap<E>) super.clone();
////        newHeap.list = new ArrayList<>(list);
//        return newHeap;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Heap<?> otherHeap = (Heap<?>) obj;
////        return list.equals(otherHeap.list);
//    }


//    In the clone method, we create a new Heap object and copy the list field by creating a new ArrayList with the same elements. This ensures that the cloned heap is independent of the original heap.
//
//    In the equals method, we compare the list fields of the two heaps. If the lists are equal, we consider the heaps to be equal. We also handle the cases where the object is null or not an instance of the Heap class.
//
//    Note that the Heap class should implement the Cloneable interface to support cloning:


//    public class Heap<E extends Comparable<E>> implements Cloneable {
//        // ...
//    }


//    Also, it's a good practice to override the hashCode method when overriding the equals method:


//    @Override
//    public int hashCode() {
////        return list.hashCode();
//    }
//}

//    This ensures that equal objects have equal hash codes, which is important for using the Heap class in hash-based data structures.
//}
