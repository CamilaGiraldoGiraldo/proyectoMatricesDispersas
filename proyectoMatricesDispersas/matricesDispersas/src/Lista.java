public class Lista {
    nodoF2 punta,cola;

    public Lista() {
        this.punta = null;
        this.cola=null;
    }

    void insertar(nodoF2 nuevo) {
        if (punta == null) {
            punta = nuevo;
            nuevo.setLigaFila(punta);
            nuevo.setLigaFila(punta);
            cola = nuevo;
        } else {
            cola.setLigaFila(nuevo);
            nuevo.setLigaFila(punta);
            cola = nuevo;
        }
    }

    

}
