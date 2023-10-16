import java.util.Random;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        Random ran = new Random();
        int[][] matriz;
        boolean componentes = true;
        int fila, columna;
        do {
            fila = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de filas que va a contener la matriz (*Igual o superior a 10*)"));
            columna = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de columnas que va a contener la matriz (*Igual o superior a 10*)"));
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
        int canDatosCeros = ran.nextInt((canDatos * 51) / 100, (canDatos * 70) / 100);
        int cont = 0;

        while (cont <= canDatosCeros) {
            int f = ran.nextInt(0, fila);
            int c = ran.nextInt(0, columna);
            if (matriz[f][c] != 0) {
                matriz[f][c] = 0;
                cont++;
            }
        }

        boolean controlMenu = true, Control = true, ControlMenu2 = true, controlMenu3 = true;

        do {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "   ***** Bienvenido al Menu de  Matrices *****   \n         Que accion desea ejecutar?          \n"
                            + "1. Tripletas \n"
                            + "2. Forma 1\n"
                            + "3. Forma 2\n"
                            + "4. Salir"));

            switch (opc) {
                case 1:
                    Tripleta funcional = new Tripleta(matriz);
                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de tripletas *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar tripleta \n"
                                        + "2. Mostrar matriz Original\n"
                                        + "3. Suma fila\n"
                                        + "4. Suma Columnas\n"
                                        + "5. Salir"));

                        switch (opcion) {
                            case 1:
                                funcional.mostrar();
                                break;
                            case 2:
                                mostrarOriginal(matriz, fila, columna);
                                break;
                            case 3:
                                funcional.sumaFila();
                                break;

                            case 4:
                                break;
                            case 5:
                                controlMenu = false;
                                JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }
                        break;
                    } while (controlMenu);

                case 2: {

                }
                    while (ControlMenu2)
                        ;
                    break;

                case 3:
                    Forma2 dispersForma2 = new Forma2();
                    dispersForma2.crear(matriz, fila, columna);
                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de tripletas *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar matriz en forma 2 \n"
                                        + "2. Mostrar matriz Original\n"
                                        + "3. Suma fila\n"
                                        + "4. Suma Columnas\n"
                                        + "5. Salir"));
                        switch (opcion) {
                            case 1:
                                JOptionPane.showMessageDialog(null, dispersForma2.Mostrar(columna, fila));
                                break;
                            case 5:
                                controlMenu = false;
                                JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");

                        }
                        break;
                    } while (controlMenu);
                    break;

                case 4:
                    Control = false;
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            }
        } while (Control);
    }

    public static void mostrarOriginal(int[][] matriz, int fila, int columna) {
        String s = "";
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                s = s + " " + matriz[i][j] + " ";
            }
            s = s + "\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }
}
