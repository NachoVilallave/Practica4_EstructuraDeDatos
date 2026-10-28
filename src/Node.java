/**
 * Nodo de una cadena simplemente enlazada.
 * ESTA CLASE SE PROPORCIONA. NO LA MODIFIQUES.
 */
public class Node<T> {
    //Importante: No cambiar ni los nombres ni la visibilidad
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }
}
