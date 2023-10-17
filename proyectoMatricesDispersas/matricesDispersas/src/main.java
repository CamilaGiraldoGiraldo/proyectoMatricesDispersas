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
                    } while (controlMenu);
                    break;
                case 2: {

                }

                    break;

                case 3:
                    Forma2 dispersForma2 = new Forma2();
                    dispersForma2.crear(matriz, fila, columna);
                    do {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                "   ***** Bienvenido al Menu de matrices dispersas Forma 2 *****   \n         Que accion desea ejecutar?          \n"
                                        + "1. Mostrar matriz en forma 2 \n"
                                        + "2. Suma fila\n"
                                        + "3. Suma Columnas\n"
                                        + "4. Insertar dato\n"
                                        + "5. Eliminar dato\n"
                                        + "6. Sumar dos matrices\n"
                                        + "7. Multiplicar dos matrices\n"
                                        + "8. Salir"));
                        switch (opcion) {
                            case 1:
                                JOptionPane.showMessageDialog(null, dispersForma2.Mostrar(columna, fila));
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, dispersForma2.sumaFilas(columna, fila));
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, dispersForma2.sumaColumnas(columna, fila));
                                break;
                            case 4:
                                int d=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato nuevo:"));
                                dispersForma2=dispersForma2.insertarDato(d, matriz, fila, columna);
                            break;
                            case 5:
                            boolean control=false;
                            do{
                                int eleccion=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú eliminar: \n"
                                                            + "1.Eliminar por dato\n"
                                                            + "2. Eliminar por fila y columna\n"))  ; 
                                                            
                                switch(eleccion){
                                    case 1:
                                        dispersForma2.EliminarDato(dispersForma2, fila, columna);
                                    break;
                                    case 2:
                                        dispersForma2.EliminarFilas(dispersForma2,fila,columna);
                                    break;
                                }
                            }while (control);
                            break;
                            case 6:
                                controlMenu = false;
                                JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");

                        }
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
