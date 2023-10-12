/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2final;
import java.io.Serializable;

/**
 *
 * @author Paola
 */
public class historialPedido implements Serializable{
    String vehiculo;
    double distancia;
    double montoTotal;
    String FechaInicio;
    String FechaFinal;
    
    public historialPedido() {
    }

    public historialPedido(String vehiculo, double distancia, double montoTotal, String FechaInicio, String FechaFinal) {
        this.vehiculo = vehiculo;
        this.distancia = distancia;
        this.montoTotal = montoTotal;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }    
}
