import java.util.Collection;

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
        throw new UnsupportedOperationException("Ejercicio 1: por implementar");
    }


    public int index() {
        // TODO Ejercicio 2
        throw new UnsupportedOperationException("Ejercicio 2: por implementar");
    }


    public int size() {
        // TODO Ejercicio 3
        throw new UnsupportedOperationException("Ejercicio 3: por implementar");
    }


    public T current() {
        // TODO Ejercicio 4
        throw new UnsupportedOperationException("Ejercicio 4: por implementar");
    }


    public void add(T item) {
        // TODO Ejercicio 5
        throw new UnsupportedOperationException("Ejercicio 5: por implementar");
    }


    public T remove() {
        // TODO Ejercicio 6
        throw new UnsupportedOperationException("Ejercicio 6: por implementar");
    }


    public T next() {
        // TODO Ejercicio 7
        throw new UnsupportedOperationException("Ejercicio 7: por implementar");
    }


    public T previous() {
        // TODO Ejercicio 8
        throw new UnsupportedOperationException("Ejercicio 8: por implementar");
    }


    public T moveTo(int index) {
        // TODO Ejercicio 9
        throw new UnsupportedOperationException("Ejercicio 9: por implementar");
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
