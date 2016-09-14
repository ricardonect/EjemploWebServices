package services;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONObject;

import util.*;

/**
 *
 * @author Ricardo Web Services Colciencias
 */
@WebService(serviceName = "utilidades")
public class utilidades {

    /**
     * Web service operation
     *
     * @param usuario
     * @param clave
     * @return objeto json
     */
    @WebMethod(operationName = "iniciarSesion")
    public String SignIn(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        //TODO write your implementation code here:
        JSONObject json = new JSONObject();

        Conectardb con = new Conectardb();
        con.cargaDriver();
        con.conexion("proyectoscolciencias");
        String sql = "SELECT * FROM proyectoscolciencias.usuarios WHERE usuario = '" + usuario + "' AND clave = '" + clave + "' ";

        try {
            if (con.ejecutarConsulta(sql)) {
                json.put("resultado", "1");
                System.out.println(json.toString());
                return (json.toString());

            } else {
                json.put("resultado", "0");
                System.out.println(json.toString());
                return (json.toString());

            }
        } catch (Exception e) {
            json.put("resultado", "0");
            System.out.println(json.toString());
            return (json.toString());
        }

    }

    /**
     * Web service operation
     *
     * @param documento
     * @param titulo
     * @param nombre
     * @param descripcion
     * @param email
     * @param telefono
     * @return
     */
    @WebMethod(operationName = "registrarProyecto")
    public String registrarProyecto(@WebParam(name = "documento") String documento, @WebParam(name = "titulo") String titulo, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "email") String email, @WebParam(name = "telefono") String telefono) {
        //TODO write your implementation code here:
        JSONObject json = new JSONObject();

        Conectardb con = new Conectardb();
        con.cargaDriver();
        con.conexion("proyectoscolciencias");
        String sql = "SELECT * FROM proyectoscolciencias.proyectos WHERE documento = '" + documento + "' AND titulo = '" + titulo + "' ";

        String insert = "INSERT INTO proyectoscolciencias.proyectos(documento,\n"
                + " titulo,\n"
                + " nombre,\n"
                + " descripcion,\n"
                + " email,\n"
                + " telefono\n)"
                + " VALUES('" + documento + "',\n"
                + " '" + titulo + "',\n"
                + " '" + nombre + "',\n"
                + " '" + descripcion + "',\n"
                + " '" + email + "',\n"
                + " '" + telefono + "' );";

        try {
            if (con.ejecutarConsulta(sql)) {
                json.put("resultado", "2");
                System.out.println(json.toString());
                return (json.toString());

            } else if (con.ejecutarDmlInt(insert) > 0) {
                json.put("resultado", "1");
                System.out.println(json.toString());
                return (json.toString());
            } else {
                json.put("resultado", "0");
                System.out.println(json.toString());
                return (json.toString());
            }
        } catch (Exception e) {
            json.put("resultado", "0");
            System.out.println(json.toString());
            return (json.toString());
        }

    }

    /**
     * Web service operation
     *
     * @param documento
     * @param titulo
     * @param nombre
     * @return string 1 si se ejecuto la accion 0 si no
     */
    @WebMethod(operationName = "borrarProyecto")
    public String borrarProyecto(@WebParam(name = "documento") String documento, @WebParam(name = "titulo") String titulo, @WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        JSONObject json = new JSONObject();

        Conectardb con = new Conectardb();
        con.cargaDriver();
        con.conexion("proyectoscolciencias");
        String sql = "SELECT * FROM proyectoscolciencias.proyectos WHERE documento = '" + documento + "' AND titulo = '" + titulo + "' AND nombre = '" + nombre + "' ";

        String del = "DELETE FROM proyectoscolciencias.proyectos WHERE documento = '" + documento + "' AND titulo = '" + titulo + "' AND nombre = '" + nombre + "' ";

        try {
            if (con.ejecutarConsulta(sql)) {
                if (con.ejecutarDmlInt(del) > 0) {
                    json.put("resultado", "1");
                    System.out.println(json.toString());
                    return (json.toString());
                } else {
                    json.put("resultado", "0");
                    System.out.println(json.toString());
                    return (json.toString());
                }
            } else {
                json.put("resultado", "0");
                System.out.println(json.toString());
                return (json.toString());
            }
        } catch (Exception e) {
            json.put("resultado", "0");
            System.out.println(json.toString());
            return (json.toString());
        }

    }

    /**
     * Web service operation
     *
     * @param usuario
     * @param clave
     * @param nombre
     * @param apellido
     * @param documento
     * @return
     */
    @WebMethod(operationName = "registrarUsuario")
    public String SignUp(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "documento") String documento) {
        //TODO write your implementation code here:
        JSONObject json = new JSONObject();

        Conectardb con = new Conectardb();
        con.cargaDriver();
        con.conexion("proyectoscolciencias");
        String sql = "SELECT * FROM proyectoscolciencias.usuarios WHERE usuario = '" + documento + "' ";

        String insert = "INSERT INTO proyectoscolciencias.usuarios(usuario,\n"
                + " clave,\n"
                + " nombre,\n"
                + " apellido,\n"
                + " documento\n)"
                + " VALUES('" + usuario + "',\n"
                + " '" + clave + "',\n"
                + " '" + nombre + "',\n"
                + " '" + apellido + "',\n"
                + " '" + documento + "');";

        try {
            if (!con.ejecutarConsulta(sql)) {
                if (con.ejecutarDmlInt(insert) > 0) {
                    json.put("resultado", "1");
                    System.out.println(json.toString());
                    return (json.toString());
                } else {
                    json.put("resultado", "0");
                    System.out.println(json.toString());
                    return (json.toString());
                }
            } else {
                json.put("resultado", "0");
                System.out.println(json.toString());
                return (json.toString());
            }

        } catch (Exception e) {
            json.put("resultado", "0");
            System.out.println(json.toString());
            return (json.toString());
        }

    }

    /**
     * Web service operation
     *
     * @return objeto json
     */
    @WebMethod(operationName = "listarProyectos")
    @SuppressWarnings({"UnusedAssignment", "UseSpecificCatch"})
    public String listarProyectos() {
        JSONObject json = new JSONObject();
        Gson gson = new Gson();
        Conectardb con = new Conectardb();
        con.cargaDriver();
        con.conexion("proyectoscolciencias");
        String sql = "SELECT titulo FROM proyectoscolciencias.proyectos";
        ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();
        Proyectos p;
        //String d="", t="", n="", de="", e="", te="";
        String t="";
        Integer i=0;
        try {
            if (con.ejecutar(sql)) {
                while (con.rs.next()) {
//                    i = Integer.parseInt(con.rs.getString("id_proyecto"));
//                    d = con.rs.getString("documento");
//                    t = con.rs.getString("titulo");
//                    n = con.rs.getString("nombre");
//                    d = con.rs.getString("descripcion");
//                    e = con.rs.getString("email");
//                    te = con.rs.getString("telefono");
                    t = con.rs.getString("titulo");
                    //p = new Proyectos(i, d, t, n, de, e, te);
                    p = new Proyectos(t);
                    proyectos.add(p);
                }
                System.out.println(gson.toJson(proyectos));
                return (gson.toJson(proyectos));
            } else {
                json.put("resultado", "1");
                return (json.toString());
            }
        } catch (Exception ex) {
            json.put("resultado", "2");
            return (json.toString());
        }
    }

}
