import javax.swing.*;

public class AtrapameSiPuedes{
    private Mapa mapa;
        private final Timer timer;
        private int Index = 2;
        @SuppressWarnings("unused")
        public AtrapameSiPuedes(){
        mapa = new Mapa(1200, 400,Index);

        ConfigurarVentana();

        timer = new Timer(135, e -> {
            mapa.actualizar(); // Llama al método para actualizar la posición de Pacman
            mapa.repaint(); // Vuelve a dibujar el mapa y Pacman
            if(mapa.getGameOver()){
                Perdiste();
            }
            if(Ganaste(mapa.getMapa(), 2)){
                mapa.setMapa(1);
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

    public boolean Ganaste( int[][] mapa, int target){
        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[fila].length; columna++){
                if (mapa[fila][columna] == target) {
                    return false;
                }
                }
        }
            return true;
        }

    //Acabar el juego
    public void Perdiste(){
        timer.stop();

        int option = JOptionPane.showConfirmDialog(null, "¿Quieres intentarlo de nuevo", "intentar",JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION){
            new AtrapameSiPuedes();
        }else{
            System.exit(0);
        }
    }
}
