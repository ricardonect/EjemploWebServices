package util;

/**
 *
 * @author Ricardo
 *
 */
import java.sql.*;
import javax.swing.*;

public class Conectardb {

    public Connection con;
    public ResultSet rs;

    /**
     * Cargar Driver de Sunpara ODBC
     */
    public void cargaDriver() {
        try { //Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra el Controlador");
        }
    }
    
    /**
     * conectar al DSN de ODBC
     *
     * @param dsn
     * @return True si hay conexión
     */
    public boolean conexion(String dsn) {
        //String url = "jdbc:odbc:"+dsn;
        try {   //  con = DriverManager.getConnection( url ,"","");
            //  String db = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Movil\\Agenda.mdb";
            // con = DriverManager.getConnection( db, "", "");

            con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoscolciencias", "root", "/123rmarin");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Imposible establecer la conexion con la BD");
            dsn = "";
            return false;
        }
        return true;
    }

    /**
     * metodo ejecutar ddl
     *
     * @param sql
     * @return True si pudo ejecutar la sentencia
     */
    public boolean ejecutar(String sql) {
        Statement st = null;
        rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * True si pudo ejecutar la sentencia
     *
     * @param sql
     * @return True si el ResultSet es diferente de vacio
     */
    public boolean ejecutarConsulta(String sql) {
        Statement st = null;
        rs = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * metodo ejecutardml
     *
     * @param sql
     * @return True si puede realizar la sentencia dml
     */
    public boolean ejecutarDml(String sql) {
        Statement st = null;
        rs = null;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * ejecuta sentencias dml
     *
     * @param sql
     * @return returna un valor mayor 0 si ejecuto la sentencia dml
     */
    public int ejecutarDmlInt(String sql) {
        Statement st = null;
        rs = null;
        try {
            st = con.createStatement();
            return (st.executeUpdate(sql));
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     *
     * cierra la conexion a la Base de datos
     */
    public void cerrarConexion() {
        try {
            con.close();
        } catch (Exception e) {
            e.toString();
        }
    }
}
