import org.campeonato.model.Campeonato;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Ingrese el nombre del campeonato");
        String nombre = sc.nextLine();
        System.out.println("Desea agregar una descripcion? (S/N)");
        String respuesta = sc.nextLine();
        Campeonato campeonato;
        if(respuesta.equals("S") || respuesta.equals("s")){
            System.out.println("Ingrese la descripcion del campeonato");
            String descripcion = sc.nextLine();
            campeonato = new Campeonato(nombre, descripcion);
            campeonato.crearRegistro();
        }else{
            campeonato = new Campeonato(nombre);
            campeonato.crearRegistro();
        }
        campeonato.agregarTemporada();
        System.out.println(campeonato);
    }
}