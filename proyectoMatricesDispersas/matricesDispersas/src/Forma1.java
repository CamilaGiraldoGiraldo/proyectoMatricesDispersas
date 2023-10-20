import javax.swing.JOptionPane;

public class Forma1 {
    Nodo punta;

    public Forma1(int fila, int columna) {
        this.punta = new Nodo();
        this.punta.setFila(fila);
        this.punta.setColumna(columna);

        int mayor;
        if (punta.getColumna() >= punta.getFila()) {
            mayor = punta.getColumna();
        } else {
            mayor = punta.getFila();
        }
        Nodo p = punta;
        for (int i = 0; i < mayor; i++) {
            Nodo nuevo = new Nodo();
            nuevo.setColumna(i);
            nuevo.setFila(i);
            p.setLigaPrincipal(nuevo);
            p = p.getLigaPrincipal();
        }
        p.setLigaPrincipal(punta);
    }

    public Forma1(int[][] matriz) {
        this.punta = new Nodo();
        this.punta.setFila(matriz.length);
        this.punta.setColumna(matriz[0].length);

        int mayor;
        if (punta.getColumna() >= punta.getFila()) {
            mayor = punta.getColumna();
        } else {
            mayor = punta.getFila();
        }
        Nodo p = punta;
        for (int i = 0; i < mayor; i++) {
            Nodo nuevo = new Nodo();
            nuevo.setColumna(i);
            nuevo.setFila(i);
            p.setLigaPrincipal(nuevo);
            p = p.getLigaPrincipal();
        }
        p.setLigaPrincipal(punta);
        p = punta.getLigaPrincipal();
        Nodo k;
        while (p != punta) {
            k = p;
            for (int i = 0; i < punta.getColumna(); i++) {
                if (p.getFila() < matriz.length) {
                    if (matriz[p.getFila()][i] != 0) {
                        Nodo fila = new Nodo();
                        fila.setFila(p.getFila());
                        fila.setColumna(i);
                        fila.setDato(matriz[p.getFila()][i]);
                        k.setLigaFila(fila);
                        k = k.getLigaFila();
                    }
                } else {
                    i = punta.getColumna();
                }
            }
            k.setLigaFila(p);
            p = p.getLigaPrincipal();
        }

        ligarColumnas();

    }

    private void ligarColumnas() {
        Nodo p = punta.getLigaPrincipal();
        Nodo espera, avanza;
        while (p != punta) {
            espera = p;
            avanza = punta.getLigaPrincipal().getLigaFila();
            while (avanza != punta) {
                if (avanza.getColumna() == p.getColumna() && avanza.getDato() != 0) {
                    espera.setLigaColumna(avanza);
                    espera = espera.getLigaColumna();
                    avanza = avanza.getLigaFila();
                } else if (avanza.getColumna() != p.getColumna() && avanza.getDato() != 0) {
                    avanza = avanza.getLigaFila();
                } else if (avanza.getDato() == 0 && avanza.getLigaPrincipal() != punta) {
                    avanza = avanza.getLigaPrincipal().getLigaFila();
                } else if (avanza.getLigaPrincipal() == punta) {
                    avanza = punta;
                }

            }
            espera.setLigaColumna(p);
            p = p.getLigaPrincipal();
        }
    }

    String mostrar() {
        String s = "";
        Nodo p = punta.getLigaPrincipal();
        Nodo k;
        while (p != punta) {

            k = p.getLigaFila();
            while (k != p) {
                s = s + "|" + k.getFila() + "|" + k.getColumna() + "|" + k.getDato() + "|";
                k = k.getLigaFila();
                if (k != p) {
                    s = s + " - ";
                } else {
                    s = s + "\n";
                }
            }
            p = p.getLigaPrincipal();
        }
        return s;
    }

    void sumaFila() {
        Nodo p = punta.getLigaPrincipal();
        String s = "";
        Nodo k;
        while (p != punta) {
            int suma = 0;
            k = p.getLigaFila();
            while (k != p) {
                suma = suma + k.getDato();
                k = k.getLigaFila();
            }
            s = s + "Fila " + p.getFila() + ": " + suma + "\n";
            p = p.getLigaPrincipal();
        }
        JOptionPane.showMessageDialog(null, "Matriz: \n " + mostrar() + "\nY la suma de las filas es: \n" + s);
    }

    void sumaColumna() {
        Nodo p = punta.getLigaPrincipal();
        String s = "";
        Nodo k;
        while (p != punta) {
            int suma = 0;
            k = p.getLigaColumna();
            while (k != p) {
                suma = suma + k.getDato();
                k = k.getLigaColumna();
            }
            s = s + "Columna " + p.getColumna() + ": " + suma + "\n";
            p = p.getLigaPrincipal();
        }
        JOptionPane.showMessageDialog(null, "Matriz: \n " + mostrar() + "\nY la suma de las Columnas es: \n" + s);
    }

    void sumaMatrices(int[][] ent) {
        Forma1 entrada = new Forma1(ent);
        Forma1 suma = new Forma1(entrada.punta.getFila(), entrada.punta.getColumna());

        Nodo pEntrada = entrada.punta.getLigaPrincipal().getLigaFila();
        Nodo pOriginal = punta.getLigaPrincipal().getLigaFila();
        Nodo pSuma = suma.punta.getLigaPrincipal();

        Nodo kSuma = pSuma;
        ;

        while (pSuma != suma.punta) {

            if (pEntrada.getDato() != 0 && pOriginal.getDato() != 0) {
                if (pEntrada.getColumna() < pOriginal.getColumna()) {
                    Nodo nuevo = new Nodo();
                    nuevo.setColumna(pEntrada.getColumna());
                    nuevo.setDato(pEntrada.getDato());
                    nuevo.setFila(pEntrada.getFila());
                    kSuma.setLigaFila(nuevo);
                    kSuma = kSuma.getLigaFila();
                    pEntrada = pEntrada.getLigaFila();
                } else if (pEntrada.getColumna() > pOriginal.getColumna()) {
                    Nodo nuevo = new Nodo();
                    nuevo.setColumna(pOriginal.getColumna());
                    nuevo.setDato(pOriginal.getDato());
                    nuevo.setFila(pOriginal.getFila());
                    kSuma.setLigaFila(nuevo);
                    kSuma = kSuma.getLigaFila();
                    pOriginal = pOriginal.getLigaFila();
                } else {
                    Nodo nuevo = new Nodo();
                    nuevo.setColumna(pOriginal.getColumna());
                    nuevo.setDato(pOriginal.getDato() + pEntrada.getDato());
                    nuevo.setFila(pOriginal.getFila());
                    kSuma.setLigaFila(nuevo);
                    kSuma = kSuma.getLigaFila();
                    pOriginal = pOriginal.getLigaFila();
                    pEntrada = pEntrada.getLigaFila();
                }

            } else if (pEntrada.getDato() != 0 && pOriginal.getDato() == 0) {
                Nodo nuevo = new Nodo();
                nuevo.setColumna(pEntrada.getColumna());
                nuevo.setDato(pEntrada.getDato());
                nuevo.setFila(pEntrada.getFila());
                kSuma.setLigaFila(nuevo);
                kSuma = kSuma.getLigaFila();
                pEntrada = pEntrada.getLigaFila();
            } else if (pEntrada.getDato() == 0 && pOriginal.getDato() != 0) {
                Nodo nuevo = new Nodo();
                nuevo.setColumna(pOriginal.getColumna());
                nuevo.setDato(pOriginal.getDato());
                nuevo.setFila(pOriginal.getFila());
                kSuma.setLigaFila(nuevo);
                kSuma = kSuma.getLigaFila();
                pOriginal = pOriginal.getLigaFila();
            } else {
                kSuma.setLigaFila(pSuma);
                pSuma = pSuma.getLigaPrincipal();
                kSuma = pSuma;
                pEntrada = pEntrada.getLigaPrincipal().getLigaFila();
                pOriginal = pOriginal.getLigaPrincipal().getLigaFila();
            }
        }
        suma.ligarColumnas();
        JOptionPane.showMessageDialog(null, "La suma de la matriz 1: \n" + mostrar() + "\nY la matriz 2: \n"
                + entrada.mostrar() + "\n es: \n " + suma.mostrar());

    }

    void insertarDato() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                + "\nPor favor ingrese el numero de la fila donde desea ingresar el nuevo dato"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz. \n" + mostrar()
                + "\nPor favor ingrese el numero de la Columna donde desea ingresar el nuevo dato"));

        if (fila < punta.getFila() && columna < punta.getColumna()) {
            int dato=0;
           do {  dato = Integer.parseInt(JOptionPane.showInputDialog(
                    "Esta es la matriz. \n" + mostrar() + "\nPor favor ingrese el dato que desea ingresar"));
           }while(dato == 0);
                    Nodo p = punta.getLigaPrincipal();
            while (p.getFila() != fila) {
                p = p.getLigaPrincipal();
            }
            Nodo k = p.getLigaFila();
            boolean bandera = true;
            Nodo f = p;
            while (k != p && bandera) {

                if (k.getColumna() == columna) {
                    int op = Integer.parseInt(JOptionPane.showInputDialog(
                            "La posicion donde desea ingresar el nuevo dato ya se encuentra ocupada, Que desea realizar: \n"
                                    +
                                    "1. Sobreescribir dato\n" +
                                    "2. Sumar dato nuevo con el anterior"));
                    if (op == 1) {
                        k.setDato(dato);
                    } else if (op == 2) {
                        k.setDato(k.getDato() + dato);
                    }

                    bandera = false;
                } else if (columna < k.getColumna()) {
                    Nodo nuevo = new Nodo();
                    nuevo.setColumna(columna);
                    nuevo.setDato(dato);
                    nuevo.setFila(fila);
                    f.setLigaFila(nuevo);
                    nuevo.setLigaFila(k);
                    bandera = false;
                } else {
                    f = k;
                    k = k.getLigaFila();
                }
            }
            if (bandera == true && k == p) {
                Nodo nuevo = new Nodo();
                nuevo.setColumna(columna);
                nuevo.setDato(dato);
                nuevo.setFila(fila);
                f.setLigaFila(nuevo);
                nuevo.setLigaFila(k);

            }

            ligarColumnas();
            JOptionPane.showMessageDialog(null, "La nueva matriz es: \n" + mostrar());

        } else {
            JOptionPane.showMessageDialog(null,
                    "Numero de fila o columna asignado, no concuerdan con los asignados inicialmente");
        }
    }

    void eliminarDato() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("Que desea relaizar: \n "
                + "1. Eliminar por dato \n"
                + "2. Eliminar por posicion"));

        if (opc == 1) {
            int dato = Integer.parseInt(JOptionPane
                    .showInputDialog("Esta es la matriz \n" + mostrar() + "\nIngrese el dato que desea eliminar:"));
            Nodo p = punta.getLigaPrincipal();

            boolean bandera = true;
            while (p != punta) {
                Nodo k = p.getLigaFila();
                Nodo f = p;
                while (k != p) {
                    if (k.getDato() == dato) {
                        f.setLigaFila(k.getLigaFila());
                        k.setLigaFila(null);
                        k = f.getLigaFila();
                        bandera = false;
                    } else {
                        f = k;
                        k = k.getLigaFila();
                    }
                }
                p = p.getLigaPrincipal();
            }
            if (bandera == false) {
                JOptionPane.showMessageDialog(null,
                        "Dato encontrado y eliminado con exito \nLa nueva matriz es: \n" + mostrar());
                ligarColumnas();
            } else {
                JOptionPane.showMessageDialog(null, "Dato no encontrado");
            }
        } else if (opc == 2) {
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz: \n" + mostrar()
                    + "\nIngrese la fila de la posicion del dato que desea eliminar"));
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Esta es la matriz: \n" + mostrar()
                    + "\nIngrese la columna de la posicion del dato que desea eliminar"));

            if (fila < punta.getFila() && columna < punta.getColumna()) {
                Nodo p = punta.getLigaPrincipal();
                while (p.getFila() != fila) {
                    p = p.getLigaPrincipal();
                }
                Nodo k= p.getLigaFila();
                boolean bandera = true;
                Nodo f = p;
                while(bandera && k != p){
                    if (k.getColumna()== columna){
                        bandera= false;
                        f.setLigaFila(k.getLigaFila());
                        k.setLigaFila(null);
                    }else{
                        f = k;
                        k = k.getLigaFila();
                    }
                }
                if(bandera == false){
                    JOptionPane.showMessageDialog(null, "Dato encontrado y eliminado con exito \nLa nueva matriz es: \n" + mostrar());
                    ligarColumnas();
                }else {
                JOptionPane.showMessageDialog(null, "Dato no encontrado");
            }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Numero de fila o columna asignado, no concuerdan con los asignados inicialmente");
            }
        }

    }

        void multiplicarMatrices(Forma1 entrada){
            Forma1 resultado = new Forma1(punta.getFila(), entrada.punta.getColumna());
            Nodo pResultado = resultado.punta.getLigaPrincipal();
            Nodo p = punta.getLigaPrincipal();
            Nodo pEntrada = entrada.punta.getLigaPrincipal();
            int multiplicacion =0;
            Nodo kResultado = pResultado;
            Nodo k = p.getLigaFila();
            Nodo kEntrada = pEntrada.getLigaColumna();

            while(p.getFila()< resultado.punta.getFila()){
                while(pEntrada.getColumna()<resultado.punta.getColumna()){
                    multiplicacion =0;
                    k = p.getLigaFila();
                    while(k != p){
                        kEntrada =  pEntrada.getLigaColumna();
                        while (kEntrada!= pEntrada){
                            if (kEntrada.getColumna() == pEntrada.getColumna() && k.getFila()==p.getFila()&& k.getColumna()==kEntrada.getFila()){
                                multiplicacion = multiplicacion+ (kEntrada.getDato()*k.getDato());
                            }
                            kEntrada = kEntrada.getLigaColumna();
                        }
                        k = k.getLigaFila();
                    }
                    if(multiplicacion!=0){
                        Nodo nuevo = new Nodo();
                        nuevo.setFila(p.getFila());
                        nuevo.setColumna(pEntrada.getColumna());
                        nuevo.setDato(multiplicacion);
                        kResultado.setLigaFila(nuevo);
                        kResultado = kResultado.getLigaFila();
                    }
                    pEntrada= pEntrada.getLigaPrincipal();
                }
                kResultado.setLigaFila(pResultado);
                p = p.getLigaPrincipal();
                k = p;
                pResultado= pResultado.getLigaPrincipal();
                kResultado= pResultado;
                pEntrada = entrada.punta.getLigaPrincipal();
                kEntrada = pEntrada.getLigaColumna();

            }

            resultado.ligarColumnas();
            JOptionPane.showMessageDialog(null,
                    "La multiplicacion entre la matriz 1:\n" + mostrar() + "\nY la matriz 2: \n"
                            + entrada.mostrar() + "\nEs:\n" + resultado.mostrar());

    }
}
