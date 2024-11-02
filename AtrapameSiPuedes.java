
import javax.swing.*;

public class AtrapameSiPuedes{
    private final Mapa mapa;

    public AtrapameSiPuedes(){
        mapa = new Mapa(1200, 400);

        ConfigurarVentana();
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

}
