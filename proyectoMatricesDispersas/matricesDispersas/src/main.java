import java.util.Random;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args)  {
        
        int [][]matriz = generadorMatriz();

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
                                        + "5. Salir"));

                        switch (opcion) {
                            case 1:
                                funcional.mostrar();
                                break;
                            case 2:
                                mostrarOriginal(matriz);
                                break;
                            case 3:
                                funcional.sumaFila();
                                break;

                            case 4:
                                break;
                            case 5:
                                controlMenu = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                                break;
                        }

                    } while (controlMenu);
                    break;

                case 2: 
                    boolean ControlMenu2 = true;
                        while (ControlMenu2)
                        ;
                        break;
                
                    

                case 3:
                    boolean controlMenu3 = true;
                    Forma2 dispersForma2 = new Forma2();
                    dispersForma2.crear(matriz, matriz.length, matriz[0].length);
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
                                JOptionPane.showMessageDialog(null, dispersForma2.Mostrar(matriz.length, matriz[0].length));
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, dispersForma2.sumaFilas(matriz.length, matriz[0].length));
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, dispersForma2.sumaColumnas(matriz.length, matriz[0].length));
                                break;
                            case 4:
                                int d=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato nuevo:"));
                                dispersForma2=dispersForma2.insertarDato(d, matriz, matriz.length,matriz[0].length);
                            break;
                            case 5:
                            boolean control=false;
                            do{
                                int eleccion=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al menú eliminar: \n"
                                                            + "1.Eliminar por dato\n"
                                                            + "2. Eliminar por fila y columna\n"))  ; 
                                                            
                                switch(eleccion){
                                    case 1:
                                        dispersForma2.EliminarDato(dispersForma2, matriz.length, matriz[0].length);
                                    break;
                                    case 2:
                                        dispersForma2.EliminarFilas(dispersForma2,matriz.length,matriz[0].length);
                                    break;
                                }
                            }while (control);
                            break;
                            case 6:
                                int [][]matrizNueva = generadorMatriz();
                                Forma2 matrizSuma = new Forma2();
                                Forma2 mForma2= new Forma2();
                                mForma2.crear(matrizNueva, matrizNueva.length, matrizNueva[0].length);
                                matrizSuma=dispersForma2.sumaMatrices(mForma2);
                                JOptionPane.showMessageDialog(null, matrizSuma.Mostrar(matriz.length, matriz[0].length));
                                break;
                            case 8:
                                controlMenu = false;
                                JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema");
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
        JOptionPane.showMessageDialog(null, s);
    }
    public static int[][] generadorMatriz(){
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
}
