package cl.uchile.dcc.scrabble.gui.MVC;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * Panel propio para modificar el arbol
 */
public class PanelArbol extends Pane {
    private Nodo tree;
    private final double radius=25;
    private final double vertical=50;



    protected PanelArbol(Nodo tree){
        this.tree=tree;

    }

    public void displayTree(){
        this.getChildren().clear();
        System.out.println("displayTree");
        if(tree.getRoot() != null){
            MostrarArbol(tree.getRoot(), getWidth() / 2, vertical, getWidth() / 4);
        }
    }

    protected void MostrarArbol(Nodo root,double x,double y,double h){



        if (root.getIzq()!=null && root.SaltaElemento()){

            getChildren().add(new Line(x-h,y+vertical,x,y));
            MostrarArbol(root.getIzq(),x-h,y+vertical,h/2);
        }


        if(root.getDer()!=null && root.SaltaInsertUnario() && root.SaltaElemento()){
            getChildren().add(new Line(x+h,y+vertical,x,y));
            MostrarArbol(root.getDer(),x+h,y+vertical,h/2);
        }

        Circle circle=new Circle(x,y,radius);
        circle.setFill(Color.GOLD);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,new Text(x-4,y+4,root.getInfo()+""));
    }


}