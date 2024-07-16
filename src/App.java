import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.contorllers.Laberinto;
import Ejercicios.models.Celda;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * System.out.println("Programación Dinámica");
         * 
         * long startime, endtime = 0;
         * startime = System.nanoTime();
         * System.out.println(fibonacci(40));
         * endtime = System.nanoTime();
         * System.out.println("Time taken: " + (endtime - startime) + " ns");
         * 
         * startime = System.nanoTime();
         * System.out.println(fibonacciWithCaching(40));
         * endtime = System.nanoTime();
         * System.out.println("Time taken: " + (endtime - startime) + " ns");
         * 
         * startime = System.nanoTime();
         * System.out.println(fibonacciCaching(40));
         * endtime = System.nanoTime();
         * System.out.println("Time taken: " + (endtime - startime) + " ns");
         */
        /// Ejericio 1
        runEjercicio();

    }

    // Normal recursive method
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // First caching method: Using a Map
    private static Map<Integer, Integer> cacheMap = new HashMap<>();

    public static int fibonacciWithCaching(int n) {
        if (n <= 1) {
            return n;
        }
        // revisar en cache si ya se calculo
        if (cacheMap.containsKey(n)) {
            cacheMap.get(n);

        }

        int result = fibonacciWithCaching(n - 1) + fibonacciWithCaching(n - 2);
        cacheMap.put(n, result);
        return result;
    }

    // Second caching method: Using an array
    public static int fibonacciCaching(int n) {
        int[] cache = new int[n + 1];
        return fibonacciArreglo(n, cache);
    }

    private static int fibonacciArreglo(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibonacciArreglo(n - 1, cache) + fibonacciArreglo(n - 2, cache);
        return cache[n];
    }

    public static void runEjercicio() {

        Laberinto laberinto = new Laberinto();
        boolean[][] grid = {
                { true, true, true, true },
                { false, false, false, true },
                { true, true, false, true },
                { true, true, false, true }
        };

        List<Celda> camino = laberinto.getPath(grid);
        System.out.println("El camino es: " + camino);
    }
}
