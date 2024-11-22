package org.serg;

import java.sql.*;

public class ConexionEmpleados_h2 {

    private static final String DRIVER="org.h2.Driver";
    private static final String URL_BD="jdbc:h2:~/test";
    private static final String USER_BD="sa";
    private static final String PASS_BD="";
    private static final String CREATE_SQL="DROP TABLE IF EXISTS EMPLEADOS;"+
            "CREATE TABLE EMPLEADOS(ID INT PRIMARY KEY, NOMBRE VARCHAR(50), EDAD INT , FECHA VARCHAR(50), SUELDOBASICO DOUBLE, SUELDOTOTAL DOUBLE); ";
    private static final String SELECT_SQL="SELECT * FROM EMPLEADOS;";

    private static final String INSERT_SQL="INSERT INTO EMPLEADOS VALUES(?,?,?,?,?,?);" ;

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado(1L,"Sebastian",34,"12/6/2024",500000.0,550000.0);
        Empleado empleado2 = new Empleado(2L,"Silvio",33,"14/7/2024",400000.0,440000.0);
        Empleado empleado3 = new Empleado(3L,"Sabrina",35,"18/8/2024",600000.0,660000.0);
        Connection conexion=null;

        try {
            Class.forName(DRIVER);
            // se establece la coneccion
            conexion = DriverManager.getConnection(URL_BD, USER_BD, PASS_BD);
            Statement stmt = conexion.createStatement();// creamos una sentencia
            stmt.execute(CREATE_SQL);

            //insertamos un registro en la tabla
            PreparedStatement pstmt = conexion.prepareStatement(INSERT_SQL);
            pstmt.setLong(1, empleado1.getId());
            pstmt.setString(2, empleado1.getNombre());
            pstmt.setInt(3, empleado1.getEdad());
            pstmt.setString(4, empleado1.getFecha());
            pstmt.setDouble(5,empleado1.getSueldoBasico());
            pstmt.setDouble(6,empleado1.getSueldoTotal());
            pstmt.setLong(1, empleado2.getId());
            pstmt.setString(2, empleado2.getNombre());
            pstmt.setInt(3, empleado2.getEdad());
            pstmt.setString(4, empleado2.getFecha());
            pstmt.setDouble(5,empleado2.getSueldoBasico());
            pstmt.setDouble(6,empleado2.getSueldoTotal());
            pstmt.setLong(1, empleado3.getId());
            pstmt.setString(2, empleado3.getNombre());
            pstmt.setInt(3, empleado3.getEdad());
            pstmt.setString(4, empleado3.getFecha());
            pstmt.setDouble(5,empleado3.getSueldoBasico());
            pstmt.setDouble(6,empleado3.getSueldoTotal());
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Se guardo el registro");
            }

            ResultSet empleados = pstmt.executeQuery(SELECT_SQL);
            while (empleados.next()){
                System.out.println(empleados.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {


            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.getMessage();
            }
        }

        }
}
