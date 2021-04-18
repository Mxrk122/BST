import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    // Driver Code
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        // Este iterador asignara el valor de key a cada nodo del arbol
        int i=0;


        // Generar arboles
        BinarySearchTree treeEs = new BinarySearchTree();
        BinarySearchTree treeEn = new BinarySearchTree();
        BinarySearchTree treeFr = new BinarySearchTree();
        // llenar el arbol con el documento de texto
        try {
            FileReader f = new FileReader(
                    "Diccionario.txt");
            BufferedReader r = new BufferedReader(f);

            String cadena;

            
            while ((cadena = r.readLine()) != null) {
                // separando la cadena y guardando las traducciones
                String[] separado = cadena.split(",");

                String palabraEn = separado[0];
                String palabraEs = separado[1];
                String palabraFr = separado[2];

                // Generar los objetos association para cada nodo
                // ingles
                String[] traduccionesIngles = new String[2];
                traduccionesIngles[0] = palabraEs;
                traduccionesIngles[1] = palabraFr;

                //Español
                String[] traduccionesEspañol = new String[2];
                traduccionesEspañol[0] = palabraEn;
                traduccionesEspañol[1] = palabraFr;

                //Frances
                String[] traduccionesFrances = new String[2];
                traduccionesFrances[0] = palabraEn;
                traduccionesFrances[1] = palabraEs;

                // Insertar estas palabras
                Association<String, String[]> ingles = new Association<String, String[]>(palabraEn, traduccionesIngles);
                treeEn.insert(i, ingles);

                Association<String, String[]> español = new Association<String, String[]>(palabraEs, traduccionesEspañol);
                treeEs.insert(i, español);

                Association<String, String[]> frances = new Association<String, String[]>(palabraFr, traduccionesIngles);
                treeFr.insert(i, frances);

                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido abrir el archivo");
        }

        // Preguntar al usuario como quiere realizar la traduccion
        int lenguajeElegido=0;
        int lenguajeDestino=0;
        
        //Menu
        while(lenguajeElegido == 0){
            System.out.println("Elige el lenguaje de entrada (El lenguaje en el que esta escrito el Texto a traducir)");
            System.out.println("(si no eliges el lenguaje correcto, no obtendras la traduccion correcta)");
            System.out.println("1. Ingles");
            System.out.println("2. Español");
            System.out.println("3. Frances");

            lenguajeElegido = scan.nextInt();

            // Instrucciones super claras btw
            System.out.println("Elige el lenguaje de salida, solo puede ingresar 1 y 2");
            System.out.println("Es decir, si elegiste español, al elegir 1 seleccionaras ingles y 2 seleccionaras frances");

            lenguajeDestino = scan.nextInt();
        }

        try {
            FileReader f = new FileReader(
                    "Texto.txt");
            BufferedReader r = new BufferedReader(f);

            String cadena;

            //Iniciar el String que se mostrara en pantalla
            String textofinal="";

            while ((cadena = r.readLine()) != null) {
                // Traducir
                String[] separado = cadena.split(" ");

                // Recorrer las palabras
                for (int j = 0; j < separado.length; j++) {

                    // Extraer la palabra actual
                    String palabraEncontrada = separado[j];

                    // Generar la palabra traducida para agregarla al String
                    String palabraTraducida = null;

                    // Recorrer el arbol
                    for (int word = 0; word < i; word++) {

                        Node nodo;

                        // Recorrer el arbol elegido por el usuario
                        if(lenguajeElegido-1==0){
                            nodo = treeEn.search(treeEn.getRoot(), word);
                        } else if(lenguajeElegido-1==1){
                            nodo = treeEs.search(treeEn.getRoot(), word);
                        } else{
                            nodo = treeFr.search(treeEn.getRoot(), word);
                        }
                        
                        String palabra = nodo.getTraduccion().getKey();

                        // Si hay coinciendica en una de las pañabras aplciar la tracuccion
                        if(palabra.equalsIgnoreCase(palabraEncontrada)){
                            palabraTraducida = nodo.getTraduccion().getValue()[lenguajeDestino-1];
                        }
                    }

                    if(palabraTraducida!=null){
                        textofinal += palabraTraducida;
                        textofinal += " ";
                    } else{
                        textofinal += "*";
                        textofinal += palabraEncontrada;
                        textofinal += "*";
                        textofinal += " ";
                    }
                }

                System.out.println(textofinal);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido abrir el archivo de texto");
        }
    }
}
// This code is contributed by Ankur Narain Verma