import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Mapa extends JPanel{
    private final int ANCHO;
    private final int LARGO;
    private final PacMan pacman;
    private final ControladorPacman controles;
    private final ArrayList<Fantasma> fantasmas;
    private final Mapas mapas;
    private int[][] mapa;
    private Boolean GameOver = false;
    private int puntuacion = 0;
    
        public Mapa(int ancho, int largo, int mapaIndex){
            this.ANCHO = ancho;
            this.LARGO = largo;
            this.setPreferredSize(new Dimension(ANCHO,LARGO));
            this.setBackground(Color.BLACK);
            mapas = new Mapas();
            this.mapa = mapas.getMapa(mapaIndex);
    
            pacman = new PacMan(1, 1, 40);
            controles = new ControladorPacman(pacman, mapa);
            
            fantasmas = new ArrayList<>();
    
            inicializarFantasmas();
    
            setFocusable(true);
            addKeyListener(controles);
        }
    
        private void inicializarFantasmas() {
            // Crear fantasmas en posiciones iniciales y agregarlos a la lista
            fantasmas.add(new Fantasma(26, 3, Color.RED, mapa, pacman));
        }
        public void setMapa(int index){
            mapa = mapas.getMapa(index);
            pacman.setPacman();
            if (0 == index) {
                fantasmas.set(0,new Fantasma(27, 3, Color.RED, mapa, pacman));
            }
            if(1 == index) {
                fantasmas.set(0, new Fantasma(15, 5, Color.GRAY, mapa, pacman));
            }
            if(2 == index){
                fantasmas.set(0, new Fantasma(1, 8, Color.MAGENTA, mapa, pacman));
            }
        }

        public void reiniciar(){
            this.GameOver = false;
        }

        public boolean getGameOver() {
            return GameOver;
        }
    
        public void actualizar() {
            pacman.actualizarPosicion(mapa); 
            verificarColisiones();
    
            for (Fantasma fantasma : fantasmas) {
                fantasma.mover(); // Movimiento aleatorio
            }
    
            for (Fantasma fantasma : fantasmas) {
                if (fantasma.getX() == pacman.getX() && fantasma.getY() == pacman.getY()) {
                    GameOver = true;
            } // Pacman Colisiona con fantasma
        }
    }

    public int [][] getMapa(){
        return mapa;
    }

    public void verificarColisiones(){
        if (mapa[pacman.getY()][pacman.getX()] == 2){
            mapa[pacman.getY()][pacman.getX()] = 0;
            puntuacion ++;
            setPuntuacion(puntuacion);
        }
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

    private void dibujarPuntuacion(Graphics g){

        String puntos= puntuacion+" Puntos";
        Font fuente=new Font("Serif", Font.BOLD, 24);
        g.setFont(fuente);
        g.setColor(Color.WHITE);
        g.drawString(puntos,(ANCHO-100) , 20);
    }
    public void setPuntuacion(int puntos){
        puntuacion=puntos;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public static final Color AMARILLO_CLARO = new Color(255, 255, 153);

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        dibujarMapa(g);
        dibujarPacman(g);
        dibujarPuntuacion(g);

        for (Fantasma fantasma : fantasmas) {
            fantasma.dibujar(g);
        }
    }
}