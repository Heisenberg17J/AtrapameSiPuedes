import java.awt.*;

public class Fantasma {
    private int x, y;
    private final Color color;
    private final int[][] mapa;
    private final PacMan pacman;

    public Fantasma(int x, int y, Color color, int[][] mapa, PacMan pacman) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.mapa = mapa;
        this.pacman = pacman;
    }

    public void mover() {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();

        int dx = 0, dy = 0;

        // Determinar la dirección en la que el fantasma debe moverse
        if (Math.abs(pacmanX - x) > Math.abs(pacmanY - y)) {
            // Mover en dirección horizontal hacia PacMan
            dx = pacmanX > x ? 1 : -1;
        } else {
            // Mover en dirección vertical hacia PacMan
            dy = pacmanY > y ? 1 : -1;
        }

        // Chequear si puede moverse en la dirección elegida
        if (esMovimientoValido(x + dx, y + dy)) {
            x += dx;
            y += dy;
        } else if (dx != 0 && esMovimientoValido(x, y + (pacmanY > y ? 1 : -1))) {
            // Si no puede moverse horizontalmente, intenta verticalmente
            y += pacmanY > y ? 1 : -1;
        } else if (dy != 0 && esMovimientoValido(x + (pacmanX > x ? 1 : -1), y)) {
            // Si no puede moverse verticalmente, intenta horizontalmente
            x += pacmanX > x ? 1 : -1;
        }
    }

    private boolean esMovimientoValido(int nuevoX, int nuevoY) {
        // Verifica si el movimiento es dentro de los límites del mapa y no es una pared
        return nuevoX >= 0 && nuevoX < mapa[0].length && nuevoY >= 0 && nuevoY < mapa.length && mapa[nuevoY][nuevoX] != 1;
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x * 40, y * 40, 40, 40);
        g.fillOval(x * 40 , y * 40 + 22, 16, 18);
        g.fillOval(x * 40 + 10, y * 40 + 22, 16, 18);
        g.fillOval(x * 40 + 25, y * 40 + 22, 16, 18);
        g.setColor(Color.WHITE);
        g.fillOval(x * 40 + 2, y * 40 + 5, 15, 15);
        g.fillOval(x * 40 + 20, y * 40 + 5, 15, 15);
    }

    public int getX() { 
        return x; 
    }
    public int getY() { 
        return y; 
    }
}
