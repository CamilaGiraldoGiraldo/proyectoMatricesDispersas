import javax.swing.JOptionPane;

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

                    nodoF2 nuevo = new nodoF2(matriz[i][j], j, i);
                    matrizDefinitiva.insertar(nuevo);

                }
            }
        }
        posicion = matrizDefinitiva.punta.getLigaFila();
        nodoF2 q = posicion.getLigaFila();

        do {
            while (k < columna) {
                q = matrizDefinitiva.punta.getLigaFila();
                while (q != matrizDefinitiva.punta) {
                    if (q.getColumna() != k) {
                        q = q.getLigaFila();
                    } else if (q.getColumna() == k && posicion != q) {
                        posicion.setLigaColumna(q);
                        posicion = q;
                        q = q.getLigaFila();
                    } else if (posicion == q) {
                        q = q.getLigaFila();
                    }
                }
                k++;
            }
            posicion.setLigaColumna(matrizDefinitiva.punta);
            matrizDefinitiva.punta.setLigaColumna(posicion);
            q = matrizDefinitiva.punta;
            posicion = q;

        } while (posicion != matrizDefinitiva.punta);
    }

    public String Mostrar(int columna, int fila) {
        int k = 0, m = 0;
        String s = " ";
        nodoF2 p = matrizDefinitiva.punta.getLigaFila();
        while (k < fila) {
            while (m < columna) {
                p = matrizDefinitiva.punta.getLigaFila();
                while (p != matrizDefinitiva.punta) {
                    if (p.getFila() == k && p.getColumna() == m) {
                        s = s + "|" + p.getFila() + "|" + p.getColumna() + "|" + p.getDato() + "|    ";
                    }
                    p = p.getLigaFila();
                }
                m++;
            }
            m = 0;
            s = s + "\n";
            k++;
        }
        return s;
    }

    public String sumaFilas(int columna, int fila) {
        int k = 0, m = 0, sumaFila = 0;
        String s = " ";
        nodoF2 p = matrizDefinitiva.punta.getLigaFila();
        while (k < fila) {
            while (m < columna) {
                p = matrizDefinitiva.punta.getLigaFila();
                while (p != matrizDefinitiva.punta) {
                    if (p.getFila() == k && p.getColumna() == m) {
                        sumaFila = sumaFila + p.getDato();
                    }
                    p = p.getLigaFila();
                }
                m++;
            }
            s = s + "|" + "fila: " + k + "|" + sumaFila + "|    ";
            m = 0;
            sumaFila = 0;
            s = s + "\n";
            k++;
        }
        return s;
    }

    public String sumaColumnas(int columna, int fila) {
        int k = 0, m = 0, sumaColumnas = 0;
        String s = " ";
        nodoF2 p = matrizDefinitiva.punta.getLigaColumna();
        while (k < columna) {
            while (m < fila) {
                p = matrizDefinitiva.punta.getLigaFila();
                while (p != matrizDefinitiva.punta) {
                    if (p.getFila() == m && p.getColumna() == k) {
                        sumaColumnas = sumaColumnas + p.getDato();
                    }
                    p = p.getLigaFila();
                }
                m++;
            }
            s = s + "|" + "Columna: " + k + "|" + sumaColumnas + "|    ";
            m = 0;
            sumaColumnas = 0;
            s = s + "\n";
            k++;
        }
        return s;
    }

    public Forma2 insertarDato(int d, int[][] matriz, int filas, int columnas) {
        Forma2 Nuevo = new Forma2();
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila en la que desea ingresar el dato: "));
        int columna = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese la columna en la que desea ingresar el dato: "));
        if (matriz[fila][columna] != 0) {
            JOptionPane.showMessageDialog(null, "Esta fila ya tiene datos");
        } else {
            matriz[fila][columna] = d;
            Nuevo.crear(matriz, filas, columnas);
            JOptionPane.showMessageDialog(null, "Dato ingresado con éxito");
        }
        return Nuevo;
    }

    public void EliminarFilas(Forma2 matriz, int filas, int columnas) {
        boolean encontrado = false;
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz que tienes\n"
                + matriz.Mostrar(columnas, filas) + "Ingrese la fila en la que desea eliminar el dato: "));
        int columna = Integer
                .parseInt(JOptionPane.showInputDialog("Esta es la matriz que tienes\n" + matriz.Mostrar(columnas, filas)
                        + "Ingrese la columna en la que desea eliminar el dato: "));
        nodoF2 p = matrizDefinitiva.punta.getLigaFila(), a = matrizDefinitiva.punta;
        p = matrizDefinitiva.punta.getLigaFila();
        while (p != matrizDefinitiva.punta && encontrado != true) {
            if (p.getFila() == fila && p.getColumna() == columna) {
                encontrado = true;
                a.setLigaFila(p.getLigaFila());
                p.setLigaFila(null);
            }
            p = p.getLigaFila();
            a = a.getLigaFila();
        }
        p = matrizDefinitiva.punta.getLigaFila();
        a = matrizDefinitiva.punta;
        encontrado = false;
        while (p != matrizDefinitiva.punta && encontrado != true) {
            if (p.getFila() == fila && p.getColumna() == columna) {
                encontrado = true;
                a.setLigaColumna(p.getLigaColumna());
                p.setLigaColumna(null);
            }
            if (a == matrizDefinitiva.punta) {
                a = a.getLigaFila();
            } else {
                a = a.getLigaColumna();
            }
            p = p.getLigaColumna();
        }

        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "Esta fila esta vacia");
        } else {
            JOptionPane.showMessageDialog(null, "Dato eliminado con exito");
        }
    }

    public void EliminarDato(Forma2 matriz, int filas, int columnas) {
        boolean encontrado = false;
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz que tienes\n"
                + matriz.Mostrar(columnas, filas) + "Ingrese el dato qie desea eliminar: "));
        nodoF2 p = matrizDefinitiva.punta.getLigaFila(), a = matrizDefinitiva.punta;
        p = matrizDefinitiva.punta.getLigaFila();
        while (p != matrizDefinitiva.punta && encontrado != true) {
            if (p.getDato() == dato) {
                encontrado = true;
                a.setLigaFila(p.getLigaFila());
                p.setLigaFila(null);
            }
            p = p.getLigaFila();
            a = a.getLigaFila();
        }
        p = matrizDefinitiva.punta.getLigaFila();
        a = matrizDefinitiva.punta;
        encontrado = false;
        while (p != matrizDefinitiva.punta && encontrado != true) {
            if (p.getDato() == dato) {
                encontrado = true;
                a.setLigaColumna(p.getLigaColumna());
                p.setLigaColumna(null);
            }
            if (a == matrizDefinitiva.punta) {
                a = a.getLigaFila();
            } else {
                a = a.getLigaColumna();
            }
            p = p.getLigaColumna();
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "Esta fila esta vacia");
        } else {
            JOptionPane.showMessageDialog(null, "Dato eliminado con exito");
        }
    }

    public Forma2 sumaMatrices(Forma2 matriz2) {
        boolean encontrado = false;
        Forma2 sumaMatrices = new Forma2();
        int[][] suma = new int[matrizDefinitiva.punta.getFila()][matrizDefinitiva.punta.getColumna()];
        nodoF2 p, s;
        if (matrizDefinitiva.punta.getColumna() == matriz2.matrizDefinitiva.punta.getColumna()
                && matrizDefinitiva.punta.getFila() == matriz2.matrizDefinitiva.punta.getFila()) {
            p = matrizDefinitiva.punta.getLigaFila();
            while (p != matrizDefinitiva.punta) {
                encontrado = false;
                s = matriz2.matrizDefinitiva.punta.getLigaFila();
                while (s != matriz2.matrizDefinitiva.punta && encontrado != true) {
                    if (p.getFila() == s.getFila() && p.getColumna() == s.getColumna()) {
                        suma[p.getFila()][p.getColumna()] = p.getDato() + s.getDato();

                        encontrado = true;
                    }
                    s = s.getLigaFila();
                }
                if (encontrado == false) {
                    suma[p.getFila()][p.getColumna()] = p.getDato();
                }
                p = p.getLigaFila();
            }
            s = matriz2.matrizDefinitiva.punta.getLigaFila();
            while (s != matriz2.matrizDefinitiva.punta) {
                encontrado = false;
                p = matrizDefinitiva.punta.getLigaFila();
                while (p != matrizDefinitiva.punta && encontrado != true) {
                    if (p.getFila() == s.getFila() && p.getColumna() == s.getColumna()) {
                        encontrado = true;
                    }
                    p = p.getLigaFila();
                }
                if (encontrado == false) {
                    suma[s.getFila()][s.getColumna()] = s.getDato();
                }
                s = s.getLigaFila();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Estas matrices no se pueden sumar");
        }
        sumaMatrices.crear(suma, suma.length, suma[0].length);
        return sumaMatrices;
    }

    public Forma2 multiplicar (Forma2 Multi){
        int f=0,c=0,k=0;
        int resultado=0;
        boolean encontrado=false;
        nodoF2 p,s;
        if (matrizDefinitiva.punta.getColumna()==Multi.matrizDefinitiva.punta.getFila()){
            int [][]multiplicacion = new int [matrizDefinitiva.punta.getFila()][Multi.matrizDefinitiva.punta.getColumna()];
            p=matrizDefinitiva.punta.getLigaFila();
            while (f < matrizDefinitiva.punta.getFila()){
                c=0;
                while (c < Multi.matrizDefinitiva.punta.getColumna()){
                        k=0;
                        while (k< matrizDefinitiva.punta.getColumna()){
                            s=Multi.matrizDefinitiva.punta.getLigaFila();
                            p=matrizDefinitiva.punta.getLigaFila();
                           while (s != Multi.matrizDefinitiva.punta && p != matrizDefinitiva.punta && encontrado != true){
                            if (s.getFila()==k && s.getColumna()==c && p.getFila()==f && p.getColumna() ==k){
                                resultado=resultado+p.getDato()*s.getDato();
                                encontrado = true;
                            }
                            s=s.getLigaColumna();
                            p=p.getLigaFila();
                            } 
                            k++;
                        }
                        multiplicacion[f][c]=resultado;
                        resultado=0;
                    c++;
                }
                f++;
            }
            Forma2 nueva = new Forma2();
            nueva.crear(multiplicacion, multiplicacion.length, multiplicacion[0].length);
            return nueva;
        }
        else{
            JOptionPane.showMessageDialog(null, "Estas matrices no se pueden multiplicar");
            return null;
        }
    }
}