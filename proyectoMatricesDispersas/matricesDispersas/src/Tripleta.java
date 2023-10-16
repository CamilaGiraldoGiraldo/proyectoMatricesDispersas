import javax.swing.JOptionPane;

public class Tripleta {
    int[][] matriz;

    public Tripleta(int[][] entrada) {
        this.matriz = new int[contarDiferenteCero(entrada) + 1][3];
        llenado(entrada);

    }

    int contarDiferenteCero(int[][] entrada) {
        int cont = 0;
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].length; j++) {
                if (entrada[i][j] != 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    void llenado(int[][] entrada) {
        matriz[0][0] = entrada.length;
        matriz[0][1] = entrada[0].length;
        matriz[0][2] = matriz.length - 1;

        int k = 1;
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].length; j++) {
                if (entrada[i][j] != 0) {
                    matriz[k][0] = i;
                    matriz[k][1] = j;
                    matriz[k][2] = entrada[i][j];
                    k++;
                }
            }
        }
    }

    void mostrar() {
        String s = "";
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i][0] != matriz [i-1][0]){
                s = s + "\n";
            }else{
               s = s + " - "; 
            }      
            for (int j = 0; j < matriz[i].length; j++) {
                s = s + " | " + matriz[i][j] + " | ";
            }
        }
        JOptionPane.showMessageDialog(null, s);;
    }

    void sumaFila() {
        int j = 0;
        String s = "";
        int suma = 0;
        for (int i = 1; i < matriz.length; i++) {
            if (j < matriz[0][0]) {
                if (matriz[i][0] == j) {
                    suma = suma + matriz[i][2];
                } else {
                    s = s + "Fila " + j + " = " + suma + "\n";
                    suma = 0;
                    suma = matriz[i][2];
                    j++;
                }
            }
        }
        s = s + "Fila " + j + " = " + suma + "\n";

        JOptionPane.showMessageDialog(null, s);;
    }

    void sumaColumna(){
        
    }
}
