public class Forma2 {
    Lista matrizDefinitiva;

    public void crear(int[][] matriz, int fila, int columna) {
        matrizDefinitiva = new Lista();
        nodoF2 posicion = null;
        int k = 0;
        nodoF2 cabeza = new nodoF2(0, columna, fila);
        matrizDefinitiva.insertar(cabeza);
        posicion = cabeza;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (matriz[i][j] != 0) {

                    nodoF2 nuevo = new nodoF2(matriz[i][j], i, j);
                    matrizDefinitiva.insertar(nuevo);

                }
            }
        }
        posicion = matrizDefinitiva.punta.getLigaColumna();
        nodoF2 q = posicion.getLigaColumna();

        do {
            while (k < columna) {
                q = matrizDefinitiva.punta.getLigaColumna();
                while (q != matrizDefinitiva.punta) {
                    if (q.getFila() != k) {
                        q = q.getLigaColumna();
                    } else if (q.getFila() == k && posicion != q) {
                        posicion.setLigaFila(q);
                        posicion = q;
                        q = q.getLigaColumna();
                    } else if (posicion == q) {
                        q = q.getLigaColumna();
                    }
                }
                k++;
            }
            posicion.setLigaFila(matrizDefinitiva.punta);
            matrizDefinitiva.punta.setLigaFila(posicion);
            q = matrizDefinitiva.punta;
            posicion = q;

        } while (posicion != matrizDefinitiva.punta);
    }

    public String Mostrar(int fila, int columna) {
        int k=0,m=0;
        String s = " ";
        nodoF2 p = matrizDefinitiva.punta.getLigaColumna();
        do {
            s = s + "|" +p.getColumna() + "|" + p.getFila() + "|" + p.getDato() + "| \n ";
            p = p.getLigaColumna();
        } while (p != matrizDefinitiva.punta);
        return s;
    }
}