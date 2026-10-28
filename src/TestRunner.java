
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.Failure;

/**
 * Ejecuta los tests de validación de la Práctica 4.
 *
 *   - Sin argumentos: ejecuta todos los tests e indica si la práctica es APTA.
 *   - Con un número de ejercicio del enunciado (1-9): ejecuta solo su test.
 *     Con 10: ejecuta el test combinado.
 *     En IntelliJ: Run > Edit Configurations... > Program arguments.
 */
public class TestRunner {

    /**
     * Número del test que corresponde a cada ejercicio del enunciado.
     * Los tests de index (Ejercicio 2) y size (Ejercicio 3) van antes que el del
     * constructor (Ejercicio 1), porque este los necesita:
     *   Ejercicio 1 -> test 03, Ejercicio 2 -> test 01, Ejercicio 3 -> test 02,
     *   del Ejercicio 4 en adelante el número coincide.
     */
    private static int testNumber(int exercise) {
        switch (exercise) {
            case 1: return 3;
            case 2: return 1;
            case 3: return 2;
            default:
                if (exercise < 1 || exercise > 10) {
                    throw new IllegalArgumentException("Ejercicio " + exercise + " no válido (1-10)");
                }
                return exercise;
        }
    }

    public static void main(String[] args) {
        Request request = Request.aClass(LinkedListWithCursorTest.class);
        if (args.length > 0) {
            final int exercise = Integer.parseInt(args[0].trim());
            final String number = String.format("%02d", testNumber(exercise));
            request = request.filterWith(new Filter() {
                @Override
                public boolean shouldRun(Description d) {
                    return d.getMethodName() == null
                            || d.getMethodName().startsWith("testLinkedListWithCursor" + number);
                }

                @Override
                public String describe() {
                    return "Ejercicio " + exercise;
                }
            });
        }

        JUnitCore core = new JUnitCore();
        core.addListener(new org.junit.runner.notification.RunListener() {
            private boolean failed;

            @Override
            public void testStarted(Description d) {
                failed = false;
            }

            @Override
            public void testFailure(Failure f) {
                failed = true;
                Throwable t = f.getException();
                String msg = (t instanceof UnsupportedOperationException)
                        ? t.getMessage()
                        : t.getClass().getSimpleName() + ": " + t.getMessage();
                System.out.printf("  FALLO  %s%n         %s%n", f.getDescription().getMethodName(), msg);
            }

            @Override
            public void testFinished(Description d) {
                if (!failed) System.out.printf("  OK     %s%n", d.getMethodName());
            }
        });

        Result r = core.run(request);
        System.out.println();
        System.out.printf("Tests superados: %d de %d%n",
                r.getRunCount() - r.getFailureCount(), r.getRunCount());
        if (args.length == 0) {
            System.out.println(r.wasSuccessful() ? "Práctica APTA" : "Práctica NO APTA");
        }
    }
}
