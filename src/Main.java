import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Mostrar perfiles de usuarios");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearNuevoUsuario(usuarios, scanner);
                    break;
                case 2:
                    mostrarPerfilesUsuarios(usuarios);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void crearNuevoUsuario(List<Usuario> usuarios, Scanner scanner) {
        System.out.println("Ingrese el nombre completo del usuario:");
        scanner.nextLine(); // Consumir la nueva línea pendiente
        String nombreCompleto = scanner.nextLine();

        System.out.println("Ingrese el correo electrónico del usuario:");
        String correoElectronico = scanner.nextLine();

        System.out.println("Ingrese el código de perfil (1: Administrador, 2: Cajero, 3: Cliente):");
        int codigoPerfil = scanner.nextInt();

        Usuario nuevoUsuario = new Usuario(nombreCompleto, correoElectronico, codigoPerfil);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario creado exitosamente.");
    }

    private static void mostrarPerfilesUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Perfiles de usuarios:");
            for (Usuario usuario : usuarios) {
                usuario.mostrarContenido();
            }
        }
    }
}

class Usuario {
    private String nombreCompleto;
    private String correoElectronico;
    private int codigoPerfil;

    public Usuario(String nombreCompleto, String correoElectronico, int codigoPerfil) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.codigoPerfil = codigoPerfil;
    }

    public void mostrarContenido() {
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Correo Electrónico: " + correoElectronico);
        System.out.println("Código de Perfil: " + codigoPerfil);
        System.out.println("Acciones para el perfil " + codigoPerfil + ":");
        if (codigoPerfil == 1) {
            System.out.println("- asignarCodigoAPerfil()");
            System.out.println("Información adicional: claveAdministrador");
        } else if (codigoPerfil == 2) {
            System.out.println("- registrarVenta()");
            System.out.println("Información adicional: claveCajero");
        } else if (codigoPerfil == 3) {
            System.out.println("- consultarProductos()");
            System.out.println("Información adicional: telefonoContacto, direccionContacto");
        }
        System.out.println("-------------------");
    }
}
