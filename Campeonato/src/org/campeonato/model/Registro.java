package org.campeonato.model;

import java.util.HashMap;
import java.util.Scanner;

public class Registro {
    //Relaciones
    private HashMap<String, Usuario> usuarioList;
    private Campeonato campeonato;

    //Constructor
    public Registro(Campeonato campeonato) {
        this.usuarioList = new HashMap<>();
        this.campeonato = campeonato;
    }
    public void crearUsuario(){
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("POR FAVOR INGRESE LOS USUARIOS DEL CAMPEONATO " + this.campeonato.getNombre());
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Apellido: ");
            String apellido = sc.nextLine();
            System.out.println("Correo: ");
            String correo = sc.nextLine();
            System.out.println("Contraseña:");
            String contrasenia = sc.nextLine();
            String contrasenia2;
            do {
                System.out.println("Confirme la contraseña: ");
                contrasenia2 = sc.nextLine();
                if (!contrasenia.equals(contrasenia2)) {
                    System.out.println("Las contraseñas no coinciden");
                }else {
                    Usuario usuario = new Usuario(nombre, apellido, correo, contrasenia,this);
                    registrarUsuario(usuario);
                    break;
                }
            } while (!contrasenia.equals(contrasenia2));
            System.out.println("Desea crear otro usuario? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")){
                break;
            }
        }while (true);
    }
    public void registrarUsuario(Usuario usuario){
        do {
            if (usuarioList.containsKey(usuario.getCorreo())){
                Scanner sc = new Scanner(System.in);
                System.out.println("El correo ya esta registrado");
                System.out.println("Por favor ingrese otro correo");
                String correo = sc.nextLine();
                usuario.setCorreo(correo);
            }else {
                usuarioList.put(usuario.getCorreo(), usuario);
                System.out.println("Usuario creado y registrado con éxito");
                break;
            }
        } while (true);
    }

    public boolean verificarUsuario(String correo){
        if (usuarioList.containsKey(correo)){
            return true;
        }else {
            return false;
        }
    }
    //Getters and Setters
    public HashMap<String, Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(HashMap<String, Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    //ToString
    @Override
    public String toString() {
        return "Registro(" +
                ", Usuarios Registrados: " + usuarioList +
                ')';
    }
}
