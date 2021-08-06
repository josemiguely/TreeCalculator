package cl.uchile.dcc.scrabble.gui.MVC;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase para generar un nodo (arbol) que tiene informacion, un nodo a la derecha y uno a la izquierda. Tambien tiene un nodo raiz. Es el modelo de la aplicacion.
 */

public class Nodo {
    private String info;
    private Nodo der;
    private Nodo izq;
    private Nodo root;

    private ArbolFactory arbolfact = new ArbolFactory();


    public Nodo(String info){
        this.info=info;
        this.der=null;
        this.izq=null;
        this.root=this;

    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public String getInfo() {
        return info;
    }

    public Nodo getDer() {
        return der;
    }

    public Nodo getIzq() {
        return izq;
    }

    /**
     * Algoritmo adaptado para insertar en Clase Nodo por nivel (es decir de izquierda a derecha mientras se llenan los niveles del arbol). Autoria de https://www.geeksforgeeks.org/
     * @param temp Nodo recibido
     * @param info Informacion que va a contener el nodo
     */


    void insertG(Nodo temp, String info)
    {

        if (temp == null) {
            root = new Nodo(info);
            return;
        }
        Queue<Nodo> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.izq == null) {
                temp.izq = new Nodo(info);
                break;
            }
            else
                q.add(temp.izq);

            if (temp.der == null) {
                temp.der = new Nodo(info);
                break;
            }
            else
                q.add(temp.der);
        }
    }

    /**
     * Indica si un nodo debe contener un solo hijo(el izquierdo) y saltarse el derecho. Esto sirve para funciones Unarias
     * @return verdadero si no se debe saltar,falso en caso contrario
     */
    public boolean SaltaInsertUnario(){

        String[] Unarios ={"ToInt","ToFloat","ToString","ToBinary","ToBool","Negacion",""};


        System.out.println("Informacion en cuestion"+this.info);


        if (Arrays.asList(Unarios).contains(this.info) ){
            System.out.println("Es unario y tira false");
            return false;}

        else{
            return true;
        }

    }

    /**
     * Indica si un nodo es un elemento (lo que no es operaacion) por lo que no se le pueden agregar nodos
     * @return Falso si es un elemento, Verdadero en caso contrario
     */

    public boolean SaltaElemento(){
        String[] Operadores ={"And","Or","Sub","Div","Mult","Add","ToInt","ToFloat","ToBinary","ToString","ToBool"};
        if(!(Arrays.asList(Operadores).contains(this.info))){
            System.out.println("Es elemento la raiz y tira false");
            return false;
        }

        return true;
    }


    /**
     * Funcion Recursiva que devuelve el Operador o elemento que contiene el resultado del arbol
     * @return Operador (que puede ser un elemento)
     * @throws Exception Si el usuario ingresa un dato no valida, o realiza una operacion inadecuada
     */
    public Operador TreeSType() throws Exception {
        String patternString="\".*\"";
        String patternBinary="bx([0-1]*)";
        String patternBoolean="bool(true|false)";


        try {

        //Caso es operador

            switch (this.root.info) {
                case "Add":
                    return arbolfact.Add(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "Div":
                    return arbolfact.Div(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "Mult":
                    return arbolfact.Mult(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "Sub":
                    return arbolfact.Sub(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "And":
                    return arbolfact.And(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "Or":
                    return arbolfact.Or(this.root.izq.TreeSType(), this.root.der.TreeSType());
                case "ToInt":
                    return arbolfact.ToInt(this.root.izq.TreeSType());
                case "ToString":
                    return arbolfact.ToString(this.root.izq.TreeSType());
                case "ToFloat":
                    return arbolfact.ToFloat(this.root.izq.TreeSType());
                case "ToBinary":
                    return arbolfact.ToBinary(this.root.izq.TreeSType());
                case "ToBool":
                    return arbolfact.ToBool(this.root.izq.TreeSType());
                case "Negacion":
                    return arbolfact.Negacion(this.root.izq.TreeSType());



                // Es un Elemento (Int,Float,String,Binario o Bool) y veo si cumple algun patron
                default:

                    if (root.info.matches(patternString)) {
                        root.info = root.info.substring(1, root.info.length() - 1);
                        return new Element(STypeFactory.getSString(root.info));
                    } else if (root.info.matches(patternBinary)) {
                        root.info = root.info.substring(2);
                        return new Element(STypeFactory.getSBinary(root.info));
                    } else if (root.info.contains(".")) {
                        return new Element(STypeFactory.getSFloat(Double.parseDouble(root.info)));
                    } else if (root.info.matches(patternBoolean)) {
                        root.info = root.info.substring(4);
                        return new Element(STypeFactory.getSBool(Boolean.parseBoolean(root.info)));
                    } else {
                        return new Element(STypeFactory.getSInt(Integer.parseInt(root.info)));
                    }

            }


        }
        catch (Exception E){
            throw new Exception("Operacion Invalida");
        }
    }

    /**
     * Retorna el resultado de utilizar TreeSType (de evaluar el arbol) en un String
     * @return String que es el resultado del arbol evaluado
     * @throws Exception Si alguna operacion falla.
     */
    public String Resultado() throws Exception {
        return this.TreeSType().resultado().getInfoAsString();

    }

    public Nodo getRoot(){
        return root;
    }

}
