package cl.uchile.dcc.scrabble.gui.MVC;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




/**
 * JavaFX App
 */
public class App extends Application {
    Controller controller=new Controller();

    @Override
    public void start(Stage stage) {
        Nodo arbol=new Nodo("");
        BorderPane pane=new BorderPane();
        PanelArbol view=new PanelArbol(arbol.getRoot());
        view.setOnKeyPressed(keyEvent -> controller.Informacion(keyEvent));
        setPane(pane,view,arbol.getRoot());
        setStage(pane, stage, "Calculadora Arbol");

    }





    public void setStage(BorderPane pane, Stage primaryStage, String title){
        Scene scene = new Scene(pane, 500,500);
        scene.setOnKeyPressed(keyEvent -> controller.Informacion(keyEvent));
        primaryStage.setTitle(title);
        primaryStage.getIcons().add(new Image("tree.png"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setPane(BorderPane pane, PanelArbol view, Nodo tree){
        pane.setCenter(view);
        TextField textField = new TextField();
        textField.setPrefColumnCount(3);
        textField.setAlignment(Pos.BASELINE_RIGHT);
        Button insert = new Button("Inserta operación o elemento");
        Button delete = new Button("Borrar Todo");
        Button calculate=new Button("Calcular");
        BuilderFunctions(textField, insert, delete,calculate, tree, view);
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Operacion o elemento"), textField, insert, calculate,delete);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        pane.setBottom(hBox);
    }

    /**
     * Setea los botones y funcionamiento de la aplicacion
     * @param textField Recibido del input del usuario
     * @param insert Boton para insertar informacion
     * @param C Boton para borrar el arbol
     * @param Calcular Boton para calcular y mostrar resultado
     * @param tree Arbol en que se va a guardar la información
     * @param view Panel que contiene toda la información
     */
    public void BuilderFunctions(TextField textField, Button insert, Button C, Button Calcular, Nodo tree, PanelArbol view) {

        insert.setOnAction(e -> {
                    if (textField.getText().length() == 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingrese algo porfavor", ButtonType.OK);
                        alert.setTitle("Input");
                        alert.setHeaderText("Falta Información");
                        alert.getDialogPane().setMinHeight(80);
                        alert.show();
                    }
                    else {
                        if(tree.getRoot().getInfo().equals("")){
                            tree.getRoot().setInfo(textField.getText());

                        }
                        else{
                            controller.insert(tree.getRoot(),textField.getText());


                        }
                        view.displayTree();

                    }
                    textField.clear();
                });
        C.setOnAction(e->{
            System.out.println("Borrar");
            controller.Borrar(tree);
            view.displayTree();


        });
        Calcular.setOnAction(e->{

            try {
            System.out.println("Calcular");

            String resultado=controller.Calcular(tree);

            System.out.println("Resultado es = "+resultado);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, resultado, ButtonType.OK);
            alert.setTitle("Resultado");
            alert.setHeaderText("Resultado");

            alert.getDialogPane().setMinHeight(80);
            alert.show();

            }
            catch (Exception as){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Operaciones Invalidas", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("No se pudo procesar el input, porfavor borre todo e intentelo de nuevo");
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            }

        });

    }


    public static void main(String[] args) {
        launch();
    }

}