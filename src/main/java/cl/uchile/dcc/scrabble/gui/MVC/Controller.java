package cl.uchile.dcc.scrabble.gui.MVC;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {

    /**
     * Borra el arbol
     * @param tree arbol a borrar
     */
    public void Borrar(Nodo tree){
        tree.setRoot(new Nodo(""));
        tree.getRoot().setDer(null);
        tree.getRoot().setIzq(null);
    }

    /**
     * Calcula el resultado del arbol y lo devuelvo como String
     * @param tree Arbol a calcular resultado
     * @return String con resultado
     * @throws Exception Si el usuario hace una operacino invalida.
     */
    public String Calcular(Nodo tree) throws Exception {
        String resultado=tree.getRoot().Resultado();
        return resultado;
    }

    /**
     * Resalta informacion útil al usiario(operaciones y como funciona la aplicación)
     * @param keyEvent, Evento de tecla a analizar
     */
    public void Informacion(KeyEvent keyEvent){
        String Mensaje="Esta aplicación añade nodos en orden de nivel de izquierda a derecha"+'\n'+'\n'+"Todas las operaciones y elementos que se pueden ingresar deben escribirse tal cual como escritas a continuación"+'\n'+'\n'+
                "Operaciones que se pueden ingresar"+'\n'+
                "Operaciones Binarias disponibles: Add,Sub,Div,Mult,Add,Or" +'\n'+
                "Operaciones Unarias disponibles: Negacion,ToInt,ToString,ToBool,ToFloat,ToBinary"+'\n'+'\n'+
                "Elementos que se pueden ingresar:"+'\n'
                +"Numeros enteros: Cualquier digito valido sin puntos"+'\n'+
                "Numeros decimales: Cualquier digito valido con punto"+'\n'+
                "Numeros binarios: Cualquier digito de 0 y 1 que empiece con bx. Ejemplo: bx1011"+ '\n'+
                "Strings: Cualquier secuencia de caracteres que empieze con \" y termine con \". Ejemplo \"Nancy es lo mejor que existe 1234\" "+'\n'+
                "Booleanos: Dos opciones. booltrue o boolfalse"+'\n'+'\n'+

                "Si alguna operacion es incorrecta, usted debera borrar todo y intentarlo nuevamente"+'\n'+
                "Para las operaciones Unarias o Elementos que no tengan hijos, debe ingresar cualquier cosa en los espacios vacios el numero de veces correspondiente hasta llegar al nodo deseado";

        if (keyEvent.getCode() == KeyCode.I) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setTitle("Información");
            alert.setHeaderText("Información");
            alert.getDialogPane().setContent(new Label(Mensaje));
            alert.show();
        }


    }

    /**
     * Inserta Nodo al arbol con la informacion obtenida de textField
     * @param tree Arbol a cual que se le ingresa
     * @param textField String con informacion para nuevo nodo a ingresar
     */
    public void insert(Nodo tree, String textField) {
        tree.getRoot().insertG(tree.getRoot(),textField);
    }
}
