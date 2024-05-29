// Clase que define a la mascota
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mascota {
    public Mascota(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleDoubleProperty(0.0);
        this.salud = new SimpleFloatProperty(10);
        this.energia = new SimpleFloatProperty(10);
        this.felicidad = new SimpleFloatProperty(10);
        this.estadoText = new SimpleStringProperty("Cansado");
    }

    
    // Ejemplos de métodos que podrían ser de utilidad.
    
    // Aplicar un item en la Mascota
    public void useItem(Item item){
        if (item instanceof Comida){
            this.energia.setValue(this.energia.getValue()+20);
            if(this.energia.getValue()>=100){
                this.energia.setValue(100);
                this.salud.setValue(this.energia.getValue()+20);
            if(this.salud.getValue()>=100){this.salud.setValue(100);}
        } else if (item instanceof Medicina){
            this.salud.setValue(this.salud.getValue()+40);
            if(this.salud.getValue()>=100){this.salud.setValue(100);}
        } else if (item instanceof Juguete){
            this.felicidad.setValue(this.felicidad.getValue()+30);
            if(this.felicidad.getValue()>=100){this.felicidad.setValue(100);}
            }   
        }
    }

    // Método encargado de los efectos de dormir en la Mascota
    public void sleep(){
    }

    // Método encargado de modificar los indicadores por cada aumento de tiempo
    public void timeStep(){
        //llamar update cada step para cambiar estado
    }


    public void updateEstado() {
        if (this.felicidad.get() >= 60) {
            this.estadoText.set("Feliz");
        } if (this.felicidad.get() <= 20) {
            this.estadoText.set("Trizte");
        } if (this.salud.get() <= 20 && this.edad.get() <= 5 ) {
            this.estadoText.set("Hambriento");
        } if (this.salud.get() <= 50 && 5 <= this.edad.get()) {
            this.estadoText.set("Hambriento");
        } if (this.edad.get() > 5 && this.salud.get() <= 30 && this.energia.get() <= 30) {
            this.estadoText.set("Enojado");
        } if (this.energia.get() <= 15) {
            this.estadoText.set("Cansado");
        } if (this.edad.get() == EDAD_MAXIMA || this.salud.get() == SALUD_MINIMA || this.energia.get() == ENERGIA_MINIMA) {
            this.estadoText.set("Muerto");
        }
    }


    public String getNombre() {
        return nombre.get();
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getEstado() {
        return estadoText.get();
    }

    public Double getEdad() {
        return edad.get();
    }

    public Float getSalud() {
        return salud.get();
    }

    public Float getEnergia() {
        return energia.get();
    }

    public Float getFelicidad() {
        return felicidad.get();
    }

    public void setSalud(Float salud) {
        this.salud.set(salud);
    }

    public void setEnergia(Float energia) {
        this.energia.set(energia);
    }

    public void setFelicidad(Float felicidad) {
        this.felicidad.set(felicidad);
    }
    
    

    
    // Atributos de tipo Property, para ser conectados con la interfaz
    private StringProperty nombre;
    private StringProperty estadoText;
    private DoubleProperty edad;
    private FloatProperty salud;
    private FloatProperty energia;
    private FloatProperty felicidad;

    // Máximos valores para los indicadores
    public final int SALUD_MAXIMA = 100;
    public final int ENERGIA_MAXIMA = 100;
    public final int FELICIDAD_MAXIMA = 100;
    public final int EDAD_MAXIMA = 15;

    // Minimos valores para los indicadores
    public final int SALUD_MINIMA = 0;
    public final int ENERGIA_MINIMA = 0;
}
