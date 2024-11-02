import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controles extends KeyAdapter{
    private PacMan pacman;

    public Controles(PacMan pacman){
        this.pacman = pacman;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int tecla = e.getKeyCode();
        switch(tecla){
            case KeyEvent.VK_LEFT -> pacman.moverPacman(-1, 0);
            case KeyEvent.VK_RIGHT -> pacman.moverPacman(1, 0);
            case KeyEvent.VK_UP -> pacman.moverPacman(0, -1);
            case KeyEvent.VK_DOWN -> pacman.moverPacman(0, 1);
            default -> {
                
            }



        }
    }

}
