
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Toshiba-PC
 */
public class MetodosSql {

//-------------------------------------------------------------------------------------------------------------------------------------        
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "CATALOGOS"
    public ArrayList<Catalogos>ListaCatalogos(){
    ArrayList<Catalogos> list=new ArrayList<Catalogos>();
    PreparedStatement ps;
    ResultSet rs;    
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM catalogos");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
        Catalogos vo=new Catalogos();
        vo.setId(rs.getString(1));
        vo.setNombre(rs.getString(2));
        vo.setFoto(rs.getBytes(3));
        list.add(vo);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
        
}
        return list;
}
    
 
    
    public void InsertarCatalogo(Catalogos vo){      
      
        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO catalogos(id_Catalogo,nombre,imagen) VALUES (?,?,?)");
        ps.setString(1, vo.getId());
        ps.setString(2, vo.getNombre());
        ps.setBytes(3, vo.getFoto());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void ModificarCatalogo(Catalogos vo){   
        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE catalogos SET nombre=?,imagen=? WHERE id_Catalogo=?");
        ps.setString(1, vo.getNombre());
        ps.setBytes(2, vo.getFoto());
        ps.setString(3, vo.getId());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Modificado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
        
    }
    
    public void EliminarCatalogo(Catalogos vo){        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM catalogos WHERE id_Catalogo=?");
        ps.setString(1, vo.getId());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void buscarUCatalogo(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM catalogos WHERE id_Catalogo LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
     public void buscarCatalogo(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM calzado WHERE id_Catalogo LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }

//-------------------------------------------------------------------------------------------------------------------------------------        
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "CLIENTES"
    public void cargarTablaClientes(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();    
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM cliente");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    t.setModel(m);
    t.setRowHeight(100);
    }
    
    public void ModificarCliente(String nombre,String apellidoP,String apellidoM,String tel,String fechaN,String codigo,String calle,int idCliente){   
        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE cliente SET nombre=?,apellido_P=?,apellido_M=?,telefono=?,fecha_nacimiento=?,codigo_postal=?,calle=? WHERE id_Cliente=?");
        ps.setString(1, nombre);
        ps.setString(2, apellidoP);
        ps.setString(3, apellidoM);
        ps.setString(4, tel);
        ps.setString(5, fechaN);
        ps.setString(6,codigo);
        ps.setString(7, calle);
        ps.setInt(8, idCliente);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Modificado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
        
    }
    
    public void EliminarCliente(int idCliente){        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM cliente WHERE id_Cliente=?");
        ps.setInt(1, idCliente);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void InsertarCliente(String nombre,String apellidoP,String apellidoM,String calle,String tel,String fechaN,String CP){      
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO cliente(nombre,apellido_P,apellido_M,telefono,fecha_nacimiento,codigo_postal,calle) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, nombre);
        ps.setString(2, apellidoP);
        ps.setString(3, apellidoM);
        ps.setString(4, tel);
        ps.setString(5, fechaN);
        ps.setString(6, CP);
        ps.setString(7, calle);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------------        
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "PEDIDOS"    
    public void cargarTablaPedidos(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM pedido");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    t.setModel(m);
    t.setRowHeight(60);
    }
    
    public void ModificarPedido(String nombre,String apellidoP,String apellidoM,String color,float talla,String tipoCalz,int idPedido){
        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE pedido SET nombre=?,apellido_P=?,apellido_M=?,color=?,talla=?,tipo_calzado=? WHERE id_Pedido=?");
        ps.setString(3, nombre);
        ps.setString(4, apellidoP);
        ps.setString(5, apellidoM);
        ps.setString(6, color);
        ps.setFloat(7, talla);
        ps.setString(11, tipoCalz);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Modificado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
        
        public void EliminarPedido(int idPedido){     
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM pedido WHERE id_Pedido=?");
        ps.setInt(1, idPedido);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
        }
    
        
    public void InsertarPedido(int idCliente,String idCalzado,String nombre,String apellidoP,String apellidoM,String color,float talla,float precio, String f,String h,String tipoCalz,String usuario){
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO pedido(id_Cliente,id_Calzado,nombre,apellido_P,apellido_M,color,talla,precio,fecha,hora,tipo_calzado,usuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, idCliente);
        ps.setString(2, idCalzado);        
        ps.setString(3, nombre);
        ps.setString(4, apellidoP);
        ps.setString(5, apellidoM);
        ps.setString(6, color);
        ps.setFloat(7, talla);
        ps.setFloat(8, precio);        
        ps.setString(9, f);
        ps.setString(10, h);
        ps.setString(11, tipoCalz);
        ps.setString(12, usuario);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }    
    
//-------------------------------------------------------------------------------------------------------------------------------------        
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "ABONOS"    
    public void cargarTablaAbonos(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM abonos");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
     public void InsertarAbono(int idCliente,int idPedido,String nombre,String apellidoP,String apellidoM,float cantidad,String fecha,String hora){
    try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO abonos(id_Cliente,id_Pedido,nombre,apellido_P,apellido_M,cantidad,fecha,hora) VALUES (?,?,?,?,?,?,?,?)");
        ps.setInt(1, idCliente);
        ps.setInt(2, idPedido);
        ps.setString(3, nombre);
        ps.setString(4, apellidoP);
        ps.setString(5, apellidoM);
        ps.setFloat(6, cantidad);
        ps.setString(7, fecha);
        ps.setString(8, hora);
        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }    
    }
    
    public void EliminarAbonos(int idPedido){
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM abonos WHERE id_Pedido=?");
        ps.setInt(1, idPedido);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------        
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "ESTATUS"    
    public void cargarTablaEstatus(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM estatus");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    t.setModel(m);
    t.setRowHeight(60);
    }
    
    public void ModificarEstatus(){   
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE estatus SET estatus.estatus='Pagado'\n" +
                                                    "WHERE pagos>=precio\n" +
                                                    "\n" +
                                                    "UPDATE estatus SET estatus.estatus='Adeudado'\n" +
                                                    "WHERE pagos<precio");       
        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void ModificarEstatusAbonos(){     
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE estatus SET estatus.pagos=(SELECT SUM(cantidad) FROM abonos WHERE abonos.id_Pedido=estatus.id_Pedido)");        
        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void EliminarEstatus(int idPedido){
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM estatus WHERE id_Pedido=?");
        ps.setInt(1, idPedido);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    
    
    public void InsertarEstatus(int idPedido,int idCliente,String nombre,String apellidoP,String apellidoM,float precio, float pagos){
        
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO estatus(id_Pedido,id_Cliente,nombre,apellido_P,apellido_M,precio,pagos,estatus,entrega) VALUES (?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, idPedido);
        ps.setInt(2, idCliente);
        ps.setString(3, nombre);
        ps.setString(4, apellidoP);
        ps.setString(5, apellidoM);
        ps.setFloat(6, precio);
        ps.setFloat(7, pagos);
        ps.setString(8, "Adeudado");
        ps.setString(9, "Espera");

        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }

//-------------------------------------------------------------------------------------------------------------------------------------    
    //METODOS DE CARGAR TABLA--ELIMINAR--MODIFICAR--INSERTAR "CALZADOS"    
     public void cargarTablaCalzados(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM calzado");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    t.setModel(m);
    t.setRowHeight(60);
    }
     
    public void InsertarCalzado(String idCatalogo,String idCalzado,int pag,String marca,String color,String genero,String corrida,int precioC,int precioP,String tipoC){
    try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO calzado(id_Catalogo,id_Calzado,pag,marca,color,genero,corrida,precio_contado,precio_pagos,tipo_calzado) VALUES (?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, idCatalogo);
        ps.setString(2, idCalzado);
        ps.setInt(3, pag);
        ps.setString(4, marca);
        ps.setString(5, color);
        ps.setString(6, genero);
        ps.setString(7, corrida);
        ps.setInt(8, precioC);
        ps.setInt(9, precioP);
        ps.setString(10, tipoC);
        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }    
    }
    
     public void ModificarCalzado(int pag,String marca,String color,String genero,String corrida,int precioC,int precioP,String tipoC,String idCalzado){     
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("UPDATE pedido SET pag=?,marca=?,color=?,genero=?,corrida=?,precio_contado=?,precio_pagos=?,tipo_calzado=? WHERE id_Calzado=?");        
        ps.setInt(1, pag);
        ps.setString(2, marca);
        ps.setString(3, color);
        ps.setString(4, genero);
        ps.setString(5, corrida);
        ps.setInt(6, precioC);
        ps.setInt(7, precioP);
        ps.setString(8, tipoC);
        ps.setString(9, idCalzado);
        
        ps.executeUpdate();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public void EliminarCalzado(String idCalzado){
        try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("DELETE FROM calzado WHERE id_Calzado=?");
        ps.setString(1, idCalzado);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Eliminado");
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }
    }
     
//---------------------------------------------------------------------------------------------------------------------------------------------------
    //METODOS PARA USUAIOS
    
    public void cargarTablaUsuarios(JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM usuarios");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    t.setModel(m);
    t.setRowHeight(60);
    }
    
    public void InsertarUsuario(String usuario,String contra,String nombre,String apellidoP,String apellidoM,String tel){
    try{
        Connection con=ConexionBD.getConetion();
        PreparedStatement ps=con.prepareStatement("INSERT INTO usuarios(usuario,contraseña,nombre,apellidoP,apellidoM,telefono) VALUES (?,?,?,?,?,?)");
        ps.setString(1, usuario);
        ps.setString(2, contra);
        ps.setString(3, nombre);
        ps.setString(4, apellidoP);
        ps.setString(5, apellidoM);
        ps.setString(6, tel);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Exitoso");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
        }    
    }
    
    public int BuscarUsuario(String usuario,String contra){ 
        int encontrado=0;
        PreparedStatement ps;
        ResultSet rs;
        try{
        Connection con=ConexionBD.getConetion();
        ps=con.prepareStatement("select * from usuarios where usuario="+usuario+" and contraseña="+contra+""); 
        rs=ps.executeQuery();
        while(rs.next()){
        rs.last();
        encontrado=rs.getRow();
            
        }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
                
        }
        return encontrado;
    }
    
//-------------------------------------------------------------------------------------------------------------------------------------    
     
    //METODOS PARA HACER BUSQUEDAS A LAS BASE DE DATOS
    public DefaultTableModel buscarNTablaClientes(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM cliente WHERE nombre LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    return m;
    }
    
    
    public void buscarCTablaClientes(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM cliente WHERE id_Cliente LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarCTablaPedidos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM pedido WHERE id_Cliente LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarPTablaPedidos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM pedido WHERE id_Pedido LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarNTablaPedidos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM pedido WHERE nombre LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarPTablaEstatus(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM estatus WHERE id_Pedido LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarCTablaEstatus(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM estatus WHERE id_Cliente LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarNTablaEstatus(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM estatus WHERE nombre LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarPTablaAbonos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM abonos WHERE id_Pedido LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarCTablaAbonos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM abonos WHERE id_Cliente LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    public void buscarNTablaAbonos(String buscar,JTable t){
    DefaultTableModel m=(DefaultTableModel) t.getModel();
    m.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    int columnas;
    
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT * FROM abonos WHERE nombre LIKE '%"+buscar+"%'");
    rs=ps.executeQuery();
    rsmd=rs.getMetaData();
    columnas=rsmd.getColumnCount();
    while(rs.next()){
    Object[] fila=new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        m.addRow(fila);
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    }
    
    
    public String BuscarPrecioContado(String idCalzado){    
    String concepto="";
    PreparedStatement ps;
    ResultSet rs;
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT precio_contado FROM calzado WHERE id_Calzado = '"+idCalzado+"'");
    rs=ps.executeQuery();
    while(rs.next()){
    concepto=rs.getString("precio_contado");
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    return concepto;
    }
    
    public String BuscarPrecioCredito(String idCalzado){
    String concepto="";
    PreparedStatement ps;
    ResultSet rs;
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT precio_pagos FROM calzado WHERE id_Calzado = '"+idCalzado+"'");
    rs=ps.executeQuery();
    while(rs.next()){
    concepto=rs.getString("precio_pagos");
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    return concepto;
    }
    
    public int BuscarIdPedido(){
    String concepto="";
    int pedido=0;
    PreparedStatement ps;
    ResultSet rs;
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT id_Pedido as 'Pedido' FROM pedido WHERE id_Pedido = (SELECT MAX(id_Pedido) from pedido) ");
    rs=ps.executeQuery();
    while(rs.next()){
    pedido=rs.getInt("Pedido");
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    return pedido;
    }
    
    public int BuscarIdCliente(){
    String concepto="";
    int cliente=0;
    PreparedStatement ps;
    ResultSet rs;
    try{
    Connection con=ConexionBD.getConetion();
    ps=con.prepareStatement("SELECT id_Cliente as 'Cliente' FROM cliente WHERE id_Cliente = (SELECT MAX(id_Cliente) from cliente) ");
    rs=ps.executeQuery();
    while(rs.next()){
    cliente=rs.getInt("Cliente");
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e.toString() );
    }
    return cliente;
    }
    
    
      
    public int BuscarEstatus(String buscarId){ 
        int creditos=0;
        PreparedStatement ps;
        ResultSet rs;
        try{
        Connection con=ConexionBD.getConetion();
        ps=con.prepareStatement("select COUNT(*) as 'Debe' from estatus\n" +
                                                  "where estatus='Adeudado' and id_Cliente=?"); 
        ps.setString(1, buscarId);
        rs=ps.executeQuery();
        while(rs.next()){
        creditos=rs.getInt("Debe");
        }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
                
        }
        return creditos;
    }
    
    public void mostrarF(String idCatalogo,JLabel icono) throws IOException{
    PreparedStatement ps;
        ResultSet rs;
        try{
        Connection con=ConexionBD.getConetion();
        ps=con.prepareStatement("select imagen from catalogos where id_Catalogo='"+idCatalogo+"'");
        rs=ps.executeQuery();
        while(rs.next()){
        Blob fotos=rs.getBlob(1);
        byte[]recuperar=fotos.getBytes(1, (int)fotos.length());
        BufferedImage img= ImageIO.read(new ByteArrayInputStream(recuperar));
        
        Image imagenes=img.getScaledInstance(icono.getWidth(), icono.getHeight(), 0);
        icono.setIcon(new ImageIcon(imagenes));
        }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.toString());
                
        }
    }
}


    