package org.serg;

import java.sql.*;

public class bd_h2 {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL_BD="jdbc:h2:~/test";
    private static final String USER_BD="sa";
    private static final String PASS_BD="";
    private static final String CREATE_SQL="DROP TABLE IF EXISTS ANIMALES;"+
            "CREATE TABLE ANIMALES(ID INT PRIMARY KEY, NOMBRE VARCHAR(50), EDAD INT ); ";
    private static final String SELECT_SQL="SELECT * FROM ANIMALES;";


    private static final String INSERT_SQL="INSERT INTO ANIMALES VALUES(?,?,?);" ;


    public static void main(String[] args)  {

        Perro perro= new Perro(1L,"Copito",3);
        Connection conexion=null;

        try{
            Class.forName(DRIVER);
            // se establece la coneccion
            conexion= DriverManager.getConnection(URL_BD,USER_BD,PASS_BD);
            Statement stmt= conexion.createStatement();// creamos una sentencia
            stmt.execute(CREATE_SQL);

            //insertamos un registro en la tabla
            PreparedStatement pstmt= conexion.prepareStatement(INSERT_SQL);
            pstmt.setLong(1,perro.getId());
            pstmt.setString(2,perro.getNombre());
            pstmt.setInt(3,perro.getEdad());


            if(pstmt.executeUpdate() > 0){
                System.out.println("Se guardo el registro");
            }

//traemos los registros de la tabla animales
            ResultSet resultadosAnimales= stmt.executeQuery(SELECT_SQL);
            while( resultadosAnimales.next()){


                System.out.println(resultadosAnimales.getLong(1)+
                        " el nombre que trae de la bd de datos es "+
                        resultadosAnimales.getString(2));
            }


        }catch (ClassNotFoundException | SQLException e) {
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


