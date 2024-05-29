/**
 * Aplicación JavaFX
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.shape.Line;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) {
        // Si utiliza las bibliotecas de JavaFX, acá debe recrear
        // la interfaz gráfica.
        Mascota mascota = new Mascota("Pollita");

        MenuBar menuBar = new MenuBar();
        Menu menuInicio = new Menu("Inicio");
        Menu menuAcciones = new Menu("Acciones");
        Menu menuHelp = new Menu("Help");
        menuBar.getMenus().addAll(menuInicio, menuAcciones, menuHelp);

        HBox hBox = new HBox(15);
        VBox vBox = new VBox(10);
        VBox vBox2 = new VBox();
        VBox vBox3 = new VBox();

        Pane paneLT = new Pane();
            Text textNombre = new Text(20, 20, "Nombre: ");
            Text textEdad = new Text(20, 40, "Edad: ");
            Text textN = new Text(100,20,mascota.getNombre());
            Text textE = new Text(100,40,""+mascota.getEdad());

            Line linea = new Line();
        
            linea.setStartX(10);
            linea.setStartY(70);
            linea.setEndX(250);
            linea.setEndY(70);
            
            linea.setStroke(Color.BLACK);
            linea.setStrokeWidth(2);

            paneLT.getChildren().addAll(textNombre, textEdad, textN,textE, linea);


        Pane paneLM = new Pane();
            final int anchoBarra = 150;
            final int altoBarra = 30;
            ProgressBar progressBarS = new ProgressBar();
            Text textSalud = new Text(anchoBarra/2,40,"Salud");
            textSalud.setFill(Color.RED);
            progressBarS.setProgress((mascota.getSalud())/100);
            progressBarS.setPrefWidth(anchoBarra);
            progressBarS.setPrefHeight(altoBarra);
            progressBarS.setLayoutX(20);
            progressBarS.setLayoutY(50);

            ProgressBar progressBarE = new ProgressBar();
            Text textEnergia = new Text(anchoBarra/2,110,"Energia");
            textEnergia.setFill(Color.GREEN);
            progressBarE.setProgress((mascota.getEnergia())/100);
            progressBarE.setPrefWidth(anchoBarra);
            progressBarE.setPrefHeight(altoBarra);
            progressBarE.setLayoutX(20);
            progressBarE.setLayoutY(120);

            ProgressBar progressBarF = new ProgressBar();
            Text textFelicidad = new Text(anchoBarra/2,180,"Felicidad");
            textFelicidad.setFill(Color.BLUE);
            progressBarF.setProgress((mascota.getFelicidad())/100);
            progressBarF.setPrefWidth(anchoBarra);
            progressBarF.setPrefHeight(altoBarra);
            progressBarF.setLayoutX(20);
            progressBarF.setLayoutY(190);

            //Se cambia energia, salud y felicidad al presionar los botones. Los progress bars deberían coresponder
            //al valor correcto al actualizarlos cada step de tiempo (ya no implementado)

            paneLM.getChildren().addAll(textSalud,progressBarS,
                                        textEnergia,progressBarE, 
                                        textFelicidad,progressBarF);

        Pane paneLB = new Pane();
            Text textEstadoE = new Text(70,100, "Estado");
            textEstadoE.setFont(Font.font(15));
            Text textEstado = new Text(60,170, mascota.getEstado());
            textEstado.setFont(Font.font(20));
            paneLB.getChildren().addAll(textEstadoE, textEstado);

        Pane paneRT = new Pane();
            Image back = new Image("background.png");
            Image pet = new Image("mascota.png");
            ImageView imageView = new ImageView(back);
            ImageView imageView2 = new ImageView(pet);
            imageView.setFitHeight(400);
            imageView.setFitWidth(400);
            imageView2.setFitHeight(50);
            imageView2.setFitWidth(50);
            imageView.setX(180);
            imageView2.setX(350);
            imageView2.setY(280);
            paneRT.getChildren().addAll(imageView,imageView2);

        
        Pane paneRB = new Pane();
            Comida Leche = new Comida(1,5,"Leche");
            Comida Carne = new Comida(1,4,"Carne");
            Comida Arroz = new Comida(1,1,"Arroz");
            Medicina Jarabe = new Medicina(2, 3, "Jarabe");
            Medicina Pastilla = new Medicina(2, 2, "Pastilla");
            Juguete Pelota = new Juguete(1, 1, "Pelota", new Image("ball.png"));
            Juguete Hueso = new Juguete(1, 1, "Hueso", new Image("bone.png"));
            HBox sectionLeche = Leche.seccionComida(mascota);
            HBox sectionCarne = Carne.seccionComida(mascota);
            HBox sectionArroz = Arroz.seccionComida(mascota);
            HBox sectionJarabe = Jarabe.seccionMedicina(mascota);
            HBox sectionPastilla = Pastilla.seccionMedicina(mascota);

            Button botonJuguete = Pelota.crearBoton();
            Button botonJuguete2 = Hueso.crearBoton();
            botonJuguete.setOnAction(event -> {
                mascota.setFelicidad(mascota.getFelicidad() + 30);
            });
            botonJuguete2.setOnAction(event -> {
                mascota.setFelicidad(mascota.getFelicidad() + 30);
            });

            Text textInventario = new Text(20, 40, "Inventario");
            Text textAlimentos = new Text(20, 40, "Alimentos");
            Text textMedicina = new Text(20, 40, "Medicina");
            Text textJuguetes = new Text(20, 40, "Juguetes");

            HBox root0 = new HBox(textAlimentos, textMedicina, textJuguetes);
            HBox root1 = new HBox(sectionLeche,sectionCarne,sectionJarabe,sectionPastilla, botonJuguete, botonJuguete2);
            HBox root2 = new HBox(sectionArroz);
            root0.setSpacing(140);
            root1.setSpacing(30);
            root0.setAlignment(Pos.CENTER);
            VBox root3 = new VBox(textInventario,root0,root1,root2);
            root3.setAlignment(Pos.CENTER);
            root3.setSpacing(5);
            paneRB.getChildren().addAll(root3);
            root3.setLayoutX(50);
            root3.setLayoutY(70);
        

        vBox2.getChildren().addAll(paneLT, paneLM, paneLB);
        vBox3.getChildren().addAll(paneRT, paneRB);

        hBox.getChildren().addAll(vBox2, vBox3);

        vBox.getChildren().addAll(menuBar, hBox);
        Scene scene = new Scene(vBox, 900, 700);
        stage.setTitle("MV"); // Set the window title
        stage.setScene(scene); // Place the scene in the window
        stage.show(); // Display the window
        
        // Handle menu actions

    }

    public static void main(String[] args) {
        launch(args);
    }

}

