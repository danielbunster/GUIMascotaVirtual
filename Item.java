import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

public abstract class Item {
    protected int id;
    protected int cantidad;
    protected String nombre;

    public Item(int id, int cantidad, String nombre){
        this.id =id;
        this.cantidad=cantidad;
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getId(){
        return id;
    }

}

class Comida extends Item{
    public Comida (int id, int cantidad, String nombre){
        super(id, cantidad, nombre);
    }

    public HBox seccionComida(Mascota mascota){
        
        HBox seccion = new HBox();
        seccion.setSpacing(20);

        Label cantidadLabel = new Label(Integer.toString(getCantidad()));

        Button comidaBoton = new Button(getNombre());
        comidaBoton.setOnAction(event -> {
            mascota.setEnergia(mascota.getEnergia() + 20);
            mascota.setSalud(mascota.getSalud() + 20);
        });

        seccion.getChildren().addAll(cantidadLabel, comidaBoton);

        seccion.setAlignment(javafx.geometry.Pos.CENTER);

        return seccion;
    }
}

class Medicina extends Item{
    public Medicina(int id, int cantidad, String nombre){
        super(id, cantidad, nombre);
    }

    public HBox seccionMedicina(Mascota mascota){
        
        HBox seccion = new HBox();
        seccion.setSpacing(20);

        Label cantidadLabel = new Label(Integer.toString(getCantidad()));

        Button medicinaBoton = new Button(getNombre());
        medicinaBoton.setOnAction(event -> {
            mascota.setSalud(mascota.getSalud() + 40);
        });

        seccion.getChildren().addAll(cantidadLabel, medicinaBoton);

        seccion.setAlignment(javafx.geometry.Pos.CENTER);

        return seccion;
    }
}

class Juguete extends Item{
    private Image imagen;
    
    public Juguete(int id, int cantidad, String nombre, Image imagen){
        super(id, cantidad, nombre);
        this.imagen = imagen;
    }

    public Button crearBoton() {
        Button boton = new Button();
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(35); 
        imageView.setFitHeight(25); 
        boton.setGraphic(imageView);
        return boton;
    }

    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int getId(){
        return id;
    }

}


