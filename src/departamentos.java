import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class departamentos implements Serializable{
   private int departamento; 
   private String nombre;
   private String localidad;

   public departamentos(int departamento, String nombre, String localidad){
       this.departamento = departamento;
       this.nombre = nombre;
       this.localidad = localidad;
   }

public static void main(String[] args) {
    departamentos d1 = new departamentos(1, "Atencion al cliente", "Sabadell");
    departamentos d2 = new departamentos(2, "Recurosos Humanos", "Madrid");
    departamentos d3 = new departamentos(3, "IT", "Málaga");
    departamentos d4 = new departamentos(4, "I+D+I", "Bilbao");

    try {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("departamentos.xml"));
        archivo.writeObject(d1);
        archivo.writeObject(d2);
        archivo.writeObject(d3);
        archivo.writeObject(d4);

        archivo.close();
        

    } catch (IOException ioe) {
     ioe.getStackTrace();

 }

}
   
}

