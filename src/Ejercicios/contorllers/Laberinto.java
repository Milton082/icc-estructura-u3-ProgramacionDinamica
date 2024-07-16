package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.List;

import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    public List<Celda> getPath(boolean[][] grid) {
        List<Celda> path = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return path;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (dfs(grid, 0, 0, path, visited)) {
            return path;
        }
        return new ArrayList<>(); // Retorna una lista vacía si no hay camino
    }

    // Método recursivo DFS para encontrar el camino
    private boolean dfs(boolean[][] grid, int row, int col, List<Celda> path, boolean[][] visited) {
        // Verifica si está fuera de los límites o en una celda no transitable o ya
        // visitada
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col] || visited[row][col]) {
            return false;
        }

        // Marca la celda como visitada
        visited[row][col] = true;
        path.add(new Celda(row, col));

        // Si ha llegado a la esquina inferior derecha, retorna verdadero
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }

        // Intenta moverse hacia abajo
        if (dfs(grid, row + 1, col, path, visited)) {
            return true;
        }

        // Intenta moverse hacia la derecha
        if (dfs(grid, row, col + 1, path, visited)) {
            return true;
        }

        // Si no hay camino, desmarca la celda y retrocede
        path.remove(path.size() - 1);
        visited[row][col] = false;

        return false;
    }
}