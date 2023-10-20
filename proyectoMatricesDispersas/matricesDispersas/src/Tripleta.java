
import javax.swing.JOptionPane;

public class Tripleta {
    int[][] matriz;

    public Tripleta() {
    }

    public Tripleta(int utiles) {
        matriz = new int[utiles + 1][3];
    }

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

    String mostrar() {
        String s = "";
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i][0] != matriz[i - 1][0]) {
                s = s + "\n";
            } else {
                s = s + " - ";
            }
            for (int j = 0; j < matriz[i].length; j++) {
                s = s + " | " + matriz[i][j] + " | ";
            }
        }
        return s;
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

        JOptionPane.showMessageDialog(null,
                "La matriz es: \n" + mostrar() + "\n\nY la suma de las filas es igual a: \n" + s);
    }

    void sumaColumna() {
        String s = "";
        int suma = 0;
        int j;
        for (j = 0; j < matriz[0][1]; j++) {

            for (int i = 1; i < matriz.length; i++) {
                if (matriz[i][1] == j) {
                    suma = suma + matriz[i][2];
                }
            }
            s = s + "Columna " + j + " = " + suma + "\n";
            suma = 0;
        }

        JOptionPane.showMessageDialog(null,
                "La matriz es: \n" + mostrar() + "\n\nY la suma de las Columnas es igual a: \n" + s);
    }

    void insertarDato() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                + "\nPor favor ingrese el numero de la fila donde desea ingresar el nuevo dato"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                + "\nPor favor ingrese el numero de la Columna donde desea ingresar el nuevo dato"));

        if (fila < matriz[0][0] && columna < matriz[0][1]) {
            int dato = 0;
            do {
                dato = Integer.parseInt(JOptionPane.showInputDialog(
                        "Esta es la matriz. \n" + mostrar() + "\nPor favor ingrese el dato que desea ingresar"));
            } while (dato == 0);

            boolean bandera = false;
            for (int i = 1; i < matriz.length && bandera == false; i++) {
                if (columna == matriz[i][1] && fila == matriz[i][0]) {
                    int opc = Integer.parseInt(JOptionPane.showInputDialog(
                            "La posicion donde desea almacenar el nuevo dato ya se encuentra ocupada, que desea hacer: \n"
                                    +
                                    "1. Reemplazar dato anterior\n" +
                                    "2. Sumar dato anterior con el nuevo"));
                    if (opc == 1) {
                        matriz[i][2] = dato;
                    } else {
                        matriz[i][2] = matriz[i][2] + dato;
                    }
                    JOptionPane.showMessageDialog(null, "La nueva matriz es: \n" + mostrar());
                    bandera = true;
                }
            }
            if (bandera == false) {
                ampliar_Insertar(fila, columna, dato);
                JOptionPane.showMessageDialog(null, "La nueva matriz es: \n" + mostrar());
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Numero de fila o columna asignado, no concuerdan con los asignados inicialmente");
        }
    }

    private void ampliar_Insertar(int fila, int columna, int dato) {
        int[][] copia = new int[matriz.length + 1][3];
        copia[0][0] = matriz[0][0];
        copia[0][1] = matriz[0][1];
        copia[0][2] = matriz[0][2] + 1;

        for (int i = 1; i < matriz.length; i++) {
            copia[i][0] = matriz[i][0];
            copia[i][1] = matriz[i][1];
            copia[i][2] = matriz[i][2];
        }
        int j = 1;
        while (copia[j][0] != fila) {
            j++;
        }
        boolean bandera = false;
        while (copia[j][0] == fila && bandera == false) {
            if (copia[j][1] < columna) {
                j++;
            } else {
                for (int i = j; i < copia.length; i++) {
                    int datoA = copia[i][2];
                    int filaA = copia[i][0];
                    int columnaA = copia[i][1];
                    copia[i][0] = fila;
                    copia[i][1] = columna;
                    copia[i][2] = dato;
                    fila = filaA;
                    columna = columnaA;
                    dato = datoA;
                }

                bandera = true;
            }

        }
        if (bandera == false) {
            for (int i = j; i < copia.length; i++) {
                int datoA = copia[i][2];
                int filaA = copia[i][0];
                int columnaA = copia[i][1];
                copia[i][0] = fila;
                copia[i][1] = columna;
                copia[i][2] = dato;
                fila = filaA;
                columna = columnaA;
                dato = datoA;
            }
        }

        matriz = copia;
    }

    void sumaMatrices(Tripleta entrada) {
        Tripleta suma = new Tripleta();
        suma.matriz = matriz.clone();

        for (int i = 1; i < entrada.matriz.length; i++) {
            boolean bandera = false;
            for (int j = 1; j < suma.matriz.length; j++) {
                if (entrada.matriz[i][0] == suma.matriz[j][0]) {
                    if (entrada.matriz[i][1] == suma.matriz[j][1]) {
                        suma.matriz[j][2] = entrada.matriz[i][2] + suma.matriz[j][2];
                        bandera = true;
                    }
                }
            }
            if (bandera == false) {
                suma.ampliar_Insertar(entrada.matriz[i][0], entrada.matriz[i][1], entrada.matriz[i][2]);
            }
        }

        JOptionPane.showMessageDialog(null, "La suma entre la matriz 1:\n" + mostrar() + "\nY la matriz 2: \n"
                + entrada.mostrar() + "\nEs igual a: \n" + suma.mostrar());

    }

    private void reducir() {
        int tam = matriz.length;
        for (int i = 1; i < tam; i++) {
            boolean bandera = false;
            if (matriz[i][0] == 0) {
                if (matriz[i][1] == 0) {
                    if (matriz[i][2] == 0) {
                        for (int j = i; j < matriz.length - 1; j++) {
                            matriz[j][0] = matriz[j + 1][0];
                            matriz[j][1] = matriz[j + 1][1];
                            matriz[j][2] = matriz[j + 1][2];
                        }
                        if (matriz[i][0]== 0 && matriz[i][1]==0 && matriz[i][2]==0){
                            i--;
                        }
                        bandera = true;
                    }
                }
            }
            if (bandera) {
                matriz[0][2] = matriz[0][2] - 1;
                tam--;
            }
        }
        int[][] copia = new int[matriz[0][2] + 1][3];
        for (int i = 0; i < matriz[0][2] + 1; i++) {
            copia[i][0] = matriz[i][0];
            copia[i][1] = matriz[i][1];
            copia[i][2] = matriz[i][2];
        }
        matriz = copia;
    }

    void eliminarDato() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion de la accion que desea realizar: \n"
                + "1. Eliminar por dato\n"
                + "2. Eliminar por posicion"));
        boolean datoEncontrado = false;
        if (opc == 1) {
            int dato = Integer.parseInt(JOptionPane
                    .showInputDialog("Esta es la matriz: \n" + mostrar() + "\nIngrese el dato que desea eliminar"));

            for (int i = 1; i < matriz.length; i++) {
                if (matriz[i][2] == dato) {
                    matriz[i][2] = 0;
                    matriz[i][1] = 0;
                    matriz[i][0] = 0;

                    datoEncontrado = true;
                }
            }

        } else if (opc == 2) {
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                    + "\nPor favor ingrese el numero de la fila donde desea eliminar el dato"));
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                    + "\nPor favor ingrese el numero de la Columna donde desea eliminar el  dato"));

            if (fila < matriz[0][0] && columna < matriz[0][1]) {
                for (int i = 1; i < matriz.length; i++) {
                    if (matriz[i][0] == fila && matriz[i][1] == columna) {
                        matriz[i][2] = 0;
                        matriz[i][1] = 0;
                        matriz[i][0] = 0;

                        datoEncontrado = true;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Numero de fila o columna asignado, no concuerdan con los asignados inicialmente");

            }
        }
        if (datoEncontrado) {
            reducir();
            JOptionPane.showMessageDialog(null, "La nuueva matriz es:\n" + mostrar());
        } else {
            JOptionPane.showMessageDialog(null, "Dato no encontrado");
        }

    }

    void multiplicarMatrices(Tripleta entrada) {
        int multiplicacion = 0;
        Tripleta resultado = new Tripleta(matriz[0][0] * entrada.matriz[0][1]);
        resultado.matriz[0][0] = matriz[0][0];
        resultado.matriz[0][1] = entrada.matriz[0][1];
        resultado.matriz[0][2] = matriz[0][0] * entrada.matriz[0][1]; 
        int re = 1;
        for (int k = 0; k < matriz[0][0]; k++) {
            for (int f = 0; f < entrada.matriz[0][1]; f++) {
                multiplicacion = 0;
                for (int i = 1; i < matriz.length; i++) {

                    
                    for (int j = 1; j < entrada.matriz.length; j++) {
                        if(matriz[i][1]== entrada.matriz[j][0]&& matriz[i][0] == k && entrada.matriz[j][1] == f){
                            multiplicacion = multiplicacion + (matriz[i][2]*entrada.matriz[j][2]);
                        }
                    }
                    
                }
                if (multiplicacion != 0) {
                        resultado.matriz[re][0] = k;
                        resultado.matriz[re][1] = f;
                        resultado.matriz[re][2] = multiplicacion;
                        re++;
                    }
            }
        }
        resultado.reducir();
        
        JOptionPane.showMessageDialog(null, "La multiplicacion entre la matriz 1:\n" + mostrar() + "\nY la matriz 2: \n"
                + entrada.mostrar() + "\nEs:\n" + resultado.mostrar());
    }
}
