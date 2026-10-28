import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithCursor<T> {
    //Importante: No cambiar ni los nombres ni la visibilidad
    Node<T> left;
    Node<T> right;
    int sizeLeft;
    int sizeRight;

    public LinkedListWithCursor() {
        left = null;
        right = null;
        sizeLeft = 0;
        sizeRight = 0;
    }


    public LinkedListWithCursor(Collection<T> col, int index) {
        // TODO Ejercicio 1
        if(index<0 || index>col.size()){
            throw new IndexOutOfBoundsException();
        }
        Iterator<T> it = col.iterator();

        for (int i = 0; i < index; i++) {
            T elem = it.next();
            this.left = new Node<>(elem, this.left);
            this.sizeLeft++;
        }

        Node<T> lastRight = null;
        while (it.hasNext()) {
            T elem = it.next();
            Node<T> newNode = new Node<>(elem, null);

            if (this.right == null) {
                this.right = newNode;
            } else {
                lastRight.next = newNode;
            }
            lastRight = newNode;
            this.sizeRight++;
        }
    }


    public int index() {
        // TODO Ejercicio 2
        return this.sizeLeft;
    }


    public int size() {
        // TODO Ejercicio 3
        return this.sizeRight + this.sizeLeft;
    }


    public T current() {
        // TODO Ejercicio 4
        if(this.right == null){
            return null;
        }
        return this.right.data;
    }


    public void add(T item) {
        // TODO Ejercicio 5
        this.left = new Node<>(item, this.left);
        this.sizeLeft++;
    }


    public T remove() {
        // TODO Ejercicio 6
        if (this.right == null) {
            throw new NoSuchElementException();
        }

        T removedData = this.right.data;
        this.right = this.right.next;
        this.sizeRight--;

        return removedData;
    }


    public T next() {
        // TODO Ejercicio 7
        if(this.right == null){
            throw  new NoSuchElementException();
        }
        T devolver = current();
        Node<T> aux = this.right;
        this.right = this.right.next;
        aux.next = this.left;
        this.left = aux;
        this.sizeLeft++;
        this.sizeRight--;
        return devolver;
    }


    public T previous() {
        // TODO Ejercicio 8
        if(this.left == null){
            throw  new NoSuchElementException();
        }
        Node<T> aux = this.left;
        this.left = this.left.next;
        aux.next = this.right;
        this.right = aux;
        this.sizeLeft--;
        this.sizeRight++;
        return current();
    }


    public T moveTo(int index) {
        // TODO Ejercicio 9
        if(index<0 || index>this.size()){
            throw new IndexOutOfBoundsException();
        }
        while(index > sizeLeft){
            next();
        }
        while(index < sizeLeft){
            previous();
        }
        if(this.right == null){
            return null;
        }
        return this.right.data;
    }

    /**
     * Devuelve la lista con el formato [izquierda][*derecha], por ejemplo
     * "[l, u][*n, a]", "[][*s, o]", "[s, o][*]" o "[][*]".
     *  NO LO MODIFIQUES.
     */
    @Override
    public String toString() {
        // La cadena izquierda está en orden inverso: se copia a un array al revés
        Object[] leftItems = new Object[sizeLeft];
        Node<T> n = left;
        for (int i = sizeLeft - 1; i >= 0 && n != null; i--) {
            leftItems[i] = n.data;
            n = n.next;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < leftItems.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(leftItems[i]);
        }
        sb.append("][*");
        n = right;
        boolean first = true;
        while (n != null) {
            if (!first) sb.append(", ");
            sb.append(n.data);
            first = false;
            n = n.next;
        }
        return sb.append("]").toString();
    }
}
