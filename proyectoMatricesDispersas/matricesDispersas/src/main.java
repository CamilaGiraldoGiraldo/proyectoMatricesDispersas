import java.util.Random;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {

        int[][] matriz = generadorMatriz();

        boolean Control = true;

        do {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "   ***** Bienvenido al Menu de  Matrices *****   \n         Que accion desea ejecutar?          \n"
                            + "1. Tripletas \n"
                            + "2. Forma 1\n"
                            + "3. Forma 2\n"
                            + "4. Salir"));

            switch (opc) {
                case 1:
                    boolean controlMenu = true;
                    Tripleta funcional = new Tripleta(matriz);
                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de tripletas *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar tripleta \n"
                                        + "2. Mostrar matriz Original\n"
                                        + "3. Suma fila\n"
                                        + "4. Suma Columnas\n"
                                        + "5. Suma entre matrices\n"
                                        + "6. Insertar nuevo dato\n"
                                        + "7. Eliminar dato\n"
                                        + "8. Multiplicar entre matrices\n"
                                        + "9. Salir"));

                        switch (opcion) {
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "La matriz en forma tripleta es: \n" + funcional.mostrar());
                                break;
                            case 2:
                                mostrarOriginal(matriz);
                                break;
                            case 3:
                                funcional.sumaFila();
                                break;

                            case 4:
                                funcional.sumaColumna();
                                break;
                            case 5:
                                Tripleta entrada = new Tripleta(generadorMatriz(matriz.length, matriz[0].length));
                                funcional.sumaMatrices(entrada);
                                break;
                            case 6:
                                funcional.insertarDato();
                                break;
                            case 7:
                                funcional.eliminarDato();
                                break;
                            case 8:
                                Tripleta entrada2 = new Tripleta(generadorMatriz(matriz[0].length));

                                funcional.multiplicarMatrices(entrada2);
                                break;

                            case 9:
                                controlMenu = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }

                    } while (controlMenu);
                    break;

                case 2:
                    Forma1 definitiva = new Forma1(matriz);
                    boolean controlMenu2 = true;

                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de forma 1 *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar matriz en forma 1 \n"
                                        + "2. Mostrar matriz Original\n"
                                        + "3. Suma fila\n"
                                        + "4. Suma Columnas\n"
                                        + "5. Suma entre matrices\n"
                                        + "6. Insertar Nuevo dato\n"
                                        + "7. Eliminar dato\n"
                                        + "8. Multiplicar entre matrices\n"
                                        + "9. Salir"));
                        switch (opcion) {
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "La matriz en Forma1 es: \n" + definitiva.mostrar());
                                break;
                            case 2:
                                mostrarOriginal(matriz);
                                break;
                            case 3:
                                definitiva.sumaFila();
                                break;
                            case 4:
                                definitiva.sumaColumna();
                                break;

                            case 5:
                                definitiva.sumaMatrices(generadorMatriz(matriz.length, matriz[0].length));
                                break;

                            case 6:
                                definitiva.insertarDato();
                                break;
                            case 7:
                                definitiva.eliminarDato();
                                break;
                                case 8:
                                Forma1 entrada = new Forma1(generadorMatriz(matriz[0].length));
                                definitiva.multiplicarMatrices(entrada);
                                break;
                            case 9:
                                controlMenu2 = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }

                    } while (controlMenu2);
                    break;

                case 3:
                    boolean controlMenu3 = true;
                    Forma2 dispersForma2 = new Forma2();
                    dispersForma2.crear(matriz, matriz.length, matriz[0].length);
                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de forma 2 *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar matriz en forma 2 \n"
                                        + "2. Mostrar matriz Original\n"
                                        + "3. Suma fila\n"
                                        + "4. Suma Columnas\n"
                                        + "5. Salir"));
                        switch (opcion) {
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        dispersForma2.Mostrar(matriz.length, matriz[0].length));
                                break;
                            case 5:
                                controlMenu3 = false;

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }

                    } while (controlMenu3);
                    break;

                case 4:
                    Control = false;
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                    break;
            }
        } while (Control);
    }

    public static void mostrarOriginal(int[][] matriz) {
        String s = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                s = s + " | " + matriz[i][j] + " | ";
            }
            s = s + "\n";
        }
        JOptionPane.showMessageDialog(null, "La matriz Original es: \n" + s);
    }

    public static int[][] generadorMatriz() {
        Random ran = new Random();
        int[][] matriz;
        boolean componentes = true;
        int fila, columna;
        do {
            fila = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de filas que va a contener la matriz (*Igual o superior a 3*)"));
            columna = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de columnas que va a contener la matriz (*Igual o superior a 3*)"));
            if (fila >= 3 && columna >= 3) {
                componentes = false;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese de nuevo los datos");
            }
        } while (componentes);

        matriz = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matriz[i][j] = ran.nextInt(1, 1000);
            }
        }

        int canDatos = fila * columna;
        int canDatosCeros = ran.nextInt((canDatos * 50) / 100, (canDatos * 70) / 100);
        int cont = 0;

        while (cont <= canDatosCeros) {
            int f = ran.nextInt(0, fila);
            int c = ran.nextInt(0, columna);
            if (matriz[f][c] != 0) {
                matriz[f][c] = 0;
                cont++;
            }
        }
        return matriz;
    }

    public static int[][] generadorMatriz(int fila, int columna) {
        Random ran = new Random();
        int[][] matriz;

        matriz = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matriz[i][j] = ran.nextInt(1, 1000);
            }
        }

        int canDatos = fila * columna;
        int canDatosCeros = ran.nextInt((canDatos * 50) / 100, (canDatos * 70) / 100);
        int cont = 0;

        while (cont <= canDatosCeros) {
            int f = ran.nextInt(0, fila);
            int c = ran.nextInt(0, columna);
            if (matriz[f][c] != 0) {
                matriz[f][c] = 0;
                cont++;
            }
        }
        return matriz;
    }

    public static int[][] generadorMatriz(int fila) {
        Random ran = new Random();
        int[][] matriz;
        boolean componentes = true;
        int columna;
        do {
            columna = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de columnas que va a contener la matriz que se usara para la multiplicacion (*Igual o superior a 3*)"));
            if (fila >= 3 && columna >= 3) {
                componentes = false;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese de nuevo los datos");
            }
        } while (componentes);

        matriz = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matriz[i][j] = ran.nextInt(1, 1000);
            }
        }

        int canDatos = fila * columna;
        int canDatosCeros = ran.nextInt((canDatos * 50) / 100, (canDatos * 70) / 100);
        int cont = 0;

        while (cont <= canDatosCeros) {
            int f = ran.nextInt(0, fila);
            int c = ran.nextInt(0, columna);
            if (matriz[f][c] != 0) {
                matriz[f][c] = 0;
                cont++;
            }
        }
        return matriz;
    }

}
