import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Automata {
    private static String[] estados;
    private static ArrayList<String> estadosFinales;
    private static String[] alfabeto;
    private static HashMap<String, String[]> tablaTransiciones;
    private static ArrayList<String> estadoActual;

    /* Función que divide el fichero y guarda cada linea en su lugar
     * correspondiente
     * archivo: El archivo donde esta la descripcion del automata
    */
    public void leerFichero(File archivo){
        String aux;
        tablaTransiciones = new HashMap<>();
        estadoActual = new ArrayList<>();
        estadosFinales = new ArrayList<>();
        String[] estFin;
        Scanner obj;
        
        try {
            obj = new Scanner(archivo);
            
            //Leemos los estados
            estados = obj.nextLine().trim().split(" ");
            
            //Leemos los estados finales
            estFin = obj.nextLine().trim().split(" ");
            
            //Metemos los estados finales en un ArrayList
            for(int i = 1; i<estFin.length; i++){
                estadosFinales.add(estFin[i].trim());
            }
            
            //Leemos el alfabeto
            alfabeto = obj.nextLine().trim().split(" ");

            //Saltamos la linea de titulo de la tabla
            obj.nextLine();
            
            //Leemos la linea de transiciones
            for(int i = 0; i<estados.length-1; i++){
                //Dividimos la linea leida por el simbolo # y la metemos en un array
                String[] linea = obj.nextLine().trim().split("#");
                
                //Dividimos cada uno de los elementos del array
                for(int j = 1; j < linea.length; j++){
                    //Establecemos la clave del HashMap que almacenara la tabla
                    //Clave "Estado,simbolo"
                    aux = estados[i+1] + ","+ alfabeto[j];
                    //Le quitamos los espacios que rodean a los elementos
                    linea[j-1] = linea[j-1].trim();
                    //Dividimos con el caracter espacio
                    String[] celdas = linea[j-1].split(" ");
                    
                    //Lo añadimos al HashMap
                    tablaTransiciones.put(aux, celdas);
                }
                
                //Añadimos la cadena vacía
                aux = estados[i+1] + ",lambda";
                linea[linea.length-1] = linea[linea.length-1].trim();
                String[] celdas = linea[linea.length-1].split(" ");
                tablaTransiciones.put(aux, celdas);
            }

            //En estado actual solo estara el estado inicial(el primero) y su clausura
            setEstadoInicial();
            
            obj.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: "+ex.getMessage());
        }

    }

    /* Función para actualizar estadoActual al estado al que pasa el programa
     * con un simbolo introducido
     * c: Simbolo que provoca la transicion
    */
    public void estadoSiguiente(char c) {
        String aux;
        ArrayList<String> lista = new ArrayList<>();
        
        //Analizamos que pasa con cada estado que esta en estado actual
        for (String estado : estadoActual){
            //Se busca la clave en la tabla
            aux = estado + "," + c;
            String[] transiciones = tablaTransiciones.get(aux);
            
            //Para cada el elemento del array resultado
            for (String transicion : transiciones) {
                //Si hay algun estado que aun no se haya añadido
                if (!transicion.equals("") && !lista.contains(transicion)) {
                    //Se añade a la lista
                    lista.add(transicion);
                }
            }
        }

        //Se vacia estadoAtual y se añade todo lo que hay en lista
        estadoActual.clear();
        estadoActual.addAll(lista);

        //Falta añadir la clausura de todos los estados que hay ahora en estadoActual
        for(String estado : estadoActual){
            for(String claus :clausura(estado)){
                if(!lista.contains(claus)){
                    lista.add(claus);
                }
            }
        }

        estadoActual = lista;
    }

    /* Función para calcular la clausura de un estado
     * estado: el estado del que se quiere calcular la clausura
     * return: ArrayList que contiene la clausura de estado
    */
    public ArrayList<String> clausura(String estado){
        String key, e;
        ArrayList<String> claus = new ArrayList<>();
        int contador = 1;

        //Añadimos el propio estado
        claus.add(estado);
        
        //Mientras haya elementos en la clausura, en principio hay 1.
        for(int i = 0; i<contador; i++){
            //Se busca ese elemento en la tabla con la transicion por la cadena vacía
            key = claus.get(i) + ",lambda";
            String[] s = tablaTransiciones.get(key);
            
            //Se añade a la clausura cada uno de los que se conecten a el por la cadena vacia
            if(s!=null&&!s[0].equals("")) {
                for (String item : s) {
                    e = item;
                    if (!claus.contains(e)) {
                        claus.add(e);
                        contador++;
                    }
                }
            }
        }

        return claus;
    }

    /*
     * Función para imprimir el/los estado/s actual/es
     * return: cadena que se quiere imprimir
    */
    public String imprimirEstadoActual(){
        ArrayList<String> estFin = new ArrayList<>();
        
        //Se imprimen el array de los estados actuales
        String s = "Estado actual: " + estadoActual +"\n";
        
        //Se comprueba se alguno de ellos es final
        for(String estado : estadoActual){
            if(estadosFinales.contains(estado))
                estFin.add(estado);
        }

        //Si hay alguno final se indica diciendo cuales
        if(!estFin.isEmpty()){
            s+="Es final ya que: " + estFin + " son finales.\n";
        }
        return s;
    }

    /*
     * Función que comprueba si un caracter esta en el alfabeto
     * c: caracter a comprobar
     * return: true esta en el alfabeto
     *         false no esta en el alfabeto
    */
    public boolean enAlfabeto(char c){
        for (int i = 1; i< alfabeto.length; i++){
            if(alfabeto[i].equals(Character.toString(c))){
                return true;
            }
        }
        return false;
    }

    /*
     * Función que establece el estado inicial
    */
    public void setEstadoInicial(){
        //Se vacia todo lo que haya en estado inicial
        estadoActual.clear();
        
        //Se añade el primer estado de la lista
        estadoActual.add(estados[1]);
        
        //Se calcula la clausura de ese primer estado
        for(String claus :clausura(estados[1])) {
            if (!estadoActual.contains(claus)) {
                estadoActual.add(claus);
            }
        }
    }
}
