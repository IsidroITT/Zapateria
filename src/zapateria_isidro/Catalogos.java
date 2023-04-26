/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Toshiba-PC
 */
public class Catalogos {
    String id;
    String nombre;
    private byte[] foto;

public Catalogos(){}

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
