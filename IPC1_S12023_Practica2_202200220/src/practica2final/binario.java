/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2final;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Paola
 */
public class binario {

private final String archivoProductos;
    
    public binario() {
        this.archivoProductos = "productos.bin";
    }

    public boolean guardarProductos(ArrayList<Pedido> lista) {
        try {
            FileOutputStream fos = new FileOutputStream(archivoProductos);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Pedido> cargarProductos() {
        ArrayList<Pedido> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(archivoProductos);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Pedido>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
    }
