public class PacMan {
    private int x, y;
    private final int tamaño; 

    public PacMan(int posicionx, int posiciony, int tamaño){
        this.x = posicionx;
        this.y = posiciony;
        this.tamaño = tamaño;
    }

    public void moverPacman(int dx, int dy){
        x += dx;
        y += dy;
    }

    public int getX(){
        return  x;
    }

    public int getY(){
        return y; 
    }
}
