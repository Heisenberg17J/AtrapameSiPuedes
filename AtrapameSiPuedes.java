import javax.swing.*;

public class AtrapameSiPuedes{
    private final Mapa mapa;
    private final Timer timer;

    public AtrapameSiPuedes(){
        mapa = new Mapa(1200, 400);

        ConfigurarVentana();

        timer = new Timer(100, e -> { // Ajustar a 50 ms para un movimiento más fluido
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
    public void mostrarVentanaPerdiste() {
        timer.stop(); // Detenemos el juego
        JOptionPane.showMessageDialog(null, "Perdiste", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Opcionalmente cerramos el juego o reiniciamos si prefieres
    }
}
