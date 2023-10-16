public class nodoF2{
    private int Dato;
    private int columna;
    private int fila;
    private nodoF2 ligaColumna;
    private nodoF2 ligaFila;

    // Contructor del nodo
    

    //getter y setter
    public int getDato() {
        return Dato;
    }

    public nodoF2(int dato, int columna, int fila) {
        Dato = dato;
        this.columna = columna;
        this.fila = fila;
        this.ligaColumna = null;
        this.ligaFila = null;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public nodoF2 getLigaColumna() {
        return ligaColumna;
    }

    public nodoF2 getLigaFila() {
        return ligaFila;
    }

    public void setDato(int dato) {
        Dato = dato;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setLigaColumna(nodoF2 ligaColumna) {
        this.ligaColumna = ligaColumna;
    }

    public void setLigaFila(nodoF2 ligaFila) {
        this.ligaFila = ligaFila;
    }
}