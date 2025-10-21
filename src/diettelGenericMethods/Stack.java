package diettelGenericMethods;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack <E>{
    private final ArrayList<E> elements;

    public Stack(){
        this(10);
    }
    public Stack(int capacity) {
        int initCapacity = capacity > 0 ? capacity : 10;
        elements = new ArrayList<E>(initCapacity);// validate
           }
   // push element onto stack
    public void push(E pushValue){
        elements.add(pushValue);
    }
           // return the top element if not empty; else throw exception
           public E pop() {
              if (elements.isEmpty()) { // if stack is empty
                     throw new NoSuchElementException("Stack is empty, cannot pop");
                  }
              // remove and return top element of Stack
              return elements.remove(elements.size() - 1);
           }
}
