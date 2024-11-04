public class PacMan {
    private int x, y; // Posición en la matriz
    private int tamaño; // Tamaño de Pacman en píxeles
    private int dx = 0, dy = 0;
    private int proximoDx = 0, proximoDy = 0;  // Dirección de movimiento
    private int direccion = 0;

    public PacMan(int x, int y, int tamaño) {
        this.x = x;
        this.y = y;
        this.tamaño = tamaño;
    }

    public void mover(int dx, int dy) {
        this.proximoDx = dx;
        this.proximoDy = dy;
    }

    public void actualizarPosicion(int[][] mapa) {
        // Verificar si la próxima dirección solicitada es válida (sin pared)
        int nuevoX = x + proximoDx;
        int nuevoY = y + proximoDy;

        if (esValido(nuevoX, nuevoY, mapa)) {
            // Si la nueva dirección es válida, la aplica
            dx = proximoDx;
            dy = proximoDy;
            actualizarDireccion();
        }
        
        // Actualiza la posición en la dirección actual
        nuevoX = x + dx;
        nuevoY = y + dy;

        // Solo se mueve si no hay pared en la dirección actual
        if (esValido(nuevoX, nuevoY, mapa)) {
            x = nuevoX;
            y = nuevoY;
            
        }
    }
    private void actualizarDireccion() {
        if (dx == -1 && dy == 0) direccion = 180; // Izquierda
        if (dx == 1 && dy == 0) direccion = 0;    // Derecha
        if (dx == 0 && dy == -1) direccion = 90;  // Arriba
        if (dx == 0 && dy == 1) direccion = 270;  // Abajo
    }

    private boolean esValido(int x, int y, int[][] mapa) {
        return x >= 0 && x < mapa[0].length && y >= 0 && y < mapa.length && mapa[y][x] != 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getDireccion() { 
        return direccion; 
    }

}
