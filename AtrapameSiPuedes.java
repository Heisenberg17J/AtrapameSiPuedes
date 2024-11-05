import javax.swing.*;

public class AtrapameSiPuedes{
    private final Mapa mapa;
    private final Timer timer;

    @SuppressWarnings("unused")
    public AtrapameSiPuedes(){
        mapa = new Mapa(1200, 400);

        ConfigurarVentana();

        timer = new Timer(125, e -> { // Movimientos fluidos
            mapa.actualizar(); // Llama al método para actualizar la posición de Pacman
            mapa.repaint(); // Vuelve a dibujar el mapa y Pacman
            if(mapa.getGameOver()){
                mostrarVentanaPerdiste();
            }
        });
        timer.start();
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
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    //Acabar el juego
    public void mostrarVentanaPerdiste() {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Perdiste", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); 
    }
}
