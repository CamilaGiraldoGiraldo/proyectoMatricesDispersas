public class Lista {
    nodoF2 punta,cola;

    public Lista() {
        this.punta = null;
        this.cola=null;
    }

    void insertar(nodoF2 nuevo) {
        if (punta == null) {
            punta = nuevo;
            nuevo.setLigaColumna(punta);
            nuevo.setLigaColumna(punta);
            cola = nuevo;
        } else {
            cola.setLigaColumna(nuevo);
            nuevo.setLigaColumna(punta);
            cola = nuevo;
        }
    }

    

}
