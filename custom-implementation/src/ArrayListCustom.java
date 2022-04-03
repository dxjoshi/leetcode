import java.util.Arrays;

class CustomArrayList<E> {
    // Define INITIAL_CAPACITY, size of elements of custom ArrayList
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public CustomArrayList() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        if (size == elementData.length) ensureCapacity(); // increase current capacity of list, make it double.
        elementData[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        return (E) elementData[index]; // return value on index.
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);

        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--; // reduce size of CustomArrayList after removal of element.
        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) System.out.print(elementData[i] + " ");
    }

}


public class ArrayListCustom {

    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<Integer>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(1);list.add(2);

        list.display();
        System.out.println("\nelement at index in custom ArrayList > " + 1 + " = " + list.get(1));

        System.out.println("element removed from index " + 1 + " = " + list.remove(1));

        System.out.println("\nlet's display custom ArrayList again after removal at index 1");
        list.display();

        // list.remove(11); //will throw IndexOutOfBoundsException, because
        // there is no element to remove on index 11.
        // list.get(11); //will throw IndexOutOfBoundsException, because there
        // is no element to get on index 11.
    }

}
