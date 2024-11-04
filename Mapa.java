import java.awt.*;
import javax.swing.JPanel;

public class Mapa extends JPanel{
    private final int ANCHO;
    private final int LARGO;
    private final PacMan pacman;
    private final ControladorPacman controles;


    int[][] mapa = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {1,2,1,2,1,2,1,1,1,2,1,2,1,2,1,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
        {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,2,2,2,1,2,2,2,1,0,0,0,2,1},
        {1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,1,1,2,1,2,1,2,1,2,1,0,0,1,2,1},
        {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,0,1,2,1},
        {1,2,1,2,1,2,1,2,1,2,2,2,1,2,2,2,1,2,1,2,2,2,1,2,1,0,0,1,2,1},
        {1,2,1,1,1,2,1,2,1,1,1,2,1,2,1,2,1,2,1,1,1,2,1,2,1,1,1,1,2,1},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public Mapa(int ancho, int largo){
        this.ANCHO = ancho;
        this.LARGO = largo;
        this.setPreferredSize(new Dimension(ANCHO,LARGO));
        this.setBackground(Color.BLACK);


        pacman = new PacMan(1, 1, 40);
        controles = new ControladorPacman(pacman, mapa);
        

        setFocusable(true);
        addKeyListener(controles);
    }

    public void actualizar() {
        pacman.actualizarPosicion(mapa); 
    }

    public void dibujarMapa(Graphics g){
        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[fila].length; columna++) {
                int valor = mapa[fila][columna];
                switch (valor) {
                    case 1 -> {
                        g.setColor(Color.BLUE);
                        g.fillRect(columna * 40, fila * 40, 40, 40);
                    }
                    case 2 -> {
                        g.setColor(AMARILLO_CLARO);
                        g.fillOval(columna * 40 + 10, fila * 40 + 10, 20, 20);
                    }
                    case 3 -> {
                        g.setColor(Color.YELLOW);
                        g.fillOval(columna * 30 + 10, fila * 30 + 10, 30, 30);
                    }
                    default -> {
                        g.setColor(Color.BLACK);
                        g.fillRect(columna * 40, fila * 40, 40, 40);
                    }
                }
            }
        }
    }

    public void dibujarPacman(Graphics g) {
        int x = pacman.getX() * 40;
        int y = pacman.getY() * 40;
        int direccion = pacman.getDireccion();
        
        g.setColor(Color.YELLOW);
    
        // Ajustar el arco según la dirección (posición inicial y amplitud de la boca)
        switch (direccion) {
            case 0 -> g.fillArc(x, y, 40, 40, 30, 300);    // Derecha
            case 90 -> g.fillArc(x, y, 40, 40, 120, 300);   // Arriba
            case 180 -> g.fillArc(x, y, 40, 40, 210, 300);  // Izquierda
            case 270 -> g.fillArc(x, y, 40, 40, 300, 300);  // Abajo
        }
    }


    public static final Color AMARILLO_CLARO = new Color(255, 255, 153);

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        dibujarMapa(g);
        dibujarPacman(g);
    }
}