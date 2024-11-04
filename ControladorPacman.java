import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControladorPacman extends KeyAdapter {
    private final PacMan pacman;
    private final int[][] mapa;

    public ControladorPacman(PacMan pacman, int[][] mapa) {
        this.pacman = pacman;
        this.mapa = mapa;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> pacman.mover(-1, 0);
            case KeyEvent.VK_RIGHT -> pacman.mover(1, 0);
            case KeyEvent.VK_UP -> pacman.mover(0, -1);
            case KeyEvent.VK_DOWN -> pacman.mover(0, 1);
        }
    }
}
