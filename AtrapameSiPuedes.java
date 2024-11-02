
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtrapameSiPuedes implements  ActionListener{
    private Timer temporizador;
    private final Mapa mapa;
    private final PacMan pacman;
    private final Controles controles;

    public AtrapameSiPuedes(){
        mapa = new Mapa(1200, 400);
        pacman = new PacMan(1, 1, 30);
        controles = new Controles(pacman);

        ConfigurarVentana();

        temporizador = new Timer(150, this);
        temporizador.start(); 
    }
    public static void main(String[] args) {
       new AtrapameSiPuedes();
    }

    public final void ConfigurarVentana(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Atrapame Si Puedes");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(mapa);
        ventana.pack();
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(ventana);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
        mapa.repaint();
    }
}
