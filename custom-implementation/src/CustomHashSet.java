class HashSetCustom<E>{
    private HashMapCustom<E, Object> hashMapCustom;

    public HashSetCustom(){
        hashMapCustom=new HashMapCustom<>();
    }

    public void add(E value){
        hashMapCustom.put(value, null);
    }

    public boolean contains(E obj){
        return hashMapCustom.contains(obj) !=null ? true :false;
    }

    public void display(){
        hashMapCustom.displaySet();
    }

    public boolean remove(E obj){
        return hashMapCustom.remove(obj);
    }
}

public class CustomHashSet {
    public static void main(String[] args) {
        HashSetCustom<Integer> hashSetCustom = new HashSetCustom<Integer>();
        hashSetCustom.add(21);
        hashSetCustom.add(25);
        hashSetCustom.add(30);
        hashSetCustom.add(33);
        hashSetCustom.add(35);

        System.out.println("HashSetCustom contains 21 ="+hashSetCustom.contains(21));
        System.out.println("HashSetCustom contains 51 ="+hashSetCustom.contains(51));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

        System.out.println("\n\n21 removed: "+hashSetCustom.remove(21));
        System.out.println("22 removed: "+hashSetCustom.remove(22));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

    }
}
