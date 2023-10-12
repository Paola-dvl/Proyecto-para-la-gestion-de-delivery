/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2final;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Paola
 */
class historialBinario {

private final String archivoHistorial;

    public historialBinario() {
        this.archivoHistorial = "C:\\Users\\Paola\\Documents\\NetBeansProjects\\Practica2final\\src\\DatosAlmacenados\\historial.bin";
        verificarArchivoHistorial();
    }

    
     private void verificarArchivoHistorial() {
        File file = new File(archivoHistorial);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Archivo historial.bin creado con éxito.");
                } else {
                    System.err.println("No se pudo crear el archivo historial.bin.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean guardarHistorial(ArrayList<historialPedido> lista) {
        try {
            FileOutputStream fos = new FileOutputStream(archivoHistorial);
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

    public ArrayList<historialPedido> cargarHistorial() {
        ArrayList<historialPedido> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(archivoHistorial);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<historialPedido>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
}