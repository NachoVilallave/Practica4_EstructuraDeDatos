import java.util.ArrayList;
import java.util.List;

public class MainPractica4 {
    public static void main(String[] args) {

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el constructor: ");
        LinkedListWithCursor<String> lista = new LinkedListWithCursor<>();
        System.out.println("Lista vacía: " + lista);
        LinkedListWithCursor<String> lista2 = new LinkedListWithCursor<>(List.of("A", "B", "C"), 0);
        System.out.println("Lista con todos los elementos a la derecha del cursor: " + lista2);
        LinkedListWithCursor<String> lista3 = new LinkedListWithCursor<>(List.of("A", "B", "C"), 3);
        System.out.println("Lista con todos los elementos a la izquierda del cursor: " + lista3);
        LinkedListWithCursor<String> lista4 = new LinkedListWithCursor<>(List.of("A", "B", "C"), 1);
        System.out.println("Lista con un elemento a la izquierda y dos a la derecha del cursor: " + lista4);

        int index=0;
        LinkedListWithCursor<String> lista5 = new LinkedListWithCursor<>(new ArrayList<>(), index);
        System.out.println("Lista con vacía con índice 0 "+lista5+" "+index);


        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método index(): ");
        System.out.println("Dada: " + lista + " --> index() es 0 y devuelve " + lista.index());
        System.out.println("Dada: " + lista2 + " --> index() es 0 y devuelve " + lista2.index());
        System.out.println("Dada: " + lista3 + " --> index() es 3 y devuelve " + lista3.index());
        System.out.println("Dada: " + lista4 + " --> index() es 1 y devuelve " + lista4.index());

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método size(): ");
        System.out.println("Dada: " + lista + " --> size() = " + lista.size());
        System.out.println("Dada: " + lista2 + " --> size() = " + lista2.size());
        System.out.println("Dada: " + lista3 + " --> size() = " + lista3.size());
        System.out.println("Dada: " + lista4 + " --> size() = " + lista4.size());

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método current(): ");
        System.out.println("Dada: " + lista + " --> current() = " + lista.current());
        System.out.println("Dada: " + lista2 + " --> current() = " + lista2.current());
        System.out.println("Dada: " + lista3 + " --> current() = " + lista3.current());
        System.out.println("Dada: " + lista4 + " --> current() = " + lista4.current());

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método add(\"Z\"): ");
        System.out.println("Antes: " + lista);
        lista.add("Z");
        System.out.println("Después: " + lista);
        System.out.println("Antes: " + lista2);
        lista2.add("Z");
        System.out.println("Después: " + lista2);
        System.out.println("Antes: " + lista3);
        lista3.add("Z");
        System.out.println("Después: " + lista3);
        System.out.println("Antes: " + lista4);
        lista4.add("Z");
        System.out.println("Después: " + lista4);

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método remove(): ");
        System.out.println("Antes: " + lista);
        try {
            lista.remove();
            System.out.println("Después: " + lista);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista2);
        try {
            lista2.remove();
            System.out.println("Después: " + lista2);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista3);
        try {
            lista3.remove();
            System.out.println("Después: " + lista3);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista4);
        try {
            lista4.remove();
            System.out.println("Después: " + lista4);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método next(): ");
        System.out.println("Antes: " + lista);
        try {
            lista.next();
            System.out.println("Después: " + lista);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista2);
        try {
            lista2.next();
            System.out.println("Después: " + lista2);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista3);
        try {
            lista3.next();
            System.out.println("Después: " + lista3);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista4);
        try {
            lista4.next();
            System.out.println("Después: " + lista4);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método previous(): ");
        System.out.println("Antes: " + lista);
        try {
            lista.previous();
            System.out.println("Después: " + lista);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista);
        try {
            lista.previous();
            System.out.println("Después: " + lista);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista3);
        try {
            lista3.previous();
            System.out.println("Después: " + lista3);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Antes: " + lista3);
        try {
            lista3.previous();
            System.out.println("Después: " + lista3);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------------");
        System.out.println("Probando el método previous(): ");
        System.out.println("Lista: " + lista3);
        int indices[] = {0, 4, 1, 3, 7, -1};
        for (int i=0; i<indices.length; i++) {
            try {
                System.out.println(" --> moveTo(" + indices[i] + ")");
                lista3.moveTo(indices[i]);
                System.out.println("Después: " + lista3);
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage() + " lista queda: " + lista3);
            }
        }
        System.out.println("\n------------------------------------------------------");
        System.out.println("FIN");

    }
}