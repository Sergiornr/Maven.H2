package org.serg;

public class Empleado {
    private Long id;
    private String nombre;
    private Integer edad;
    private String fecha;
    private Double sueldoBasico;
    private Double sueldoTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(Double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public Empleado(Long id, String nombre, Integer edad, String fecha, Double sueldoBasico, Double sueldoTotal) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = fecha;
        this.sueldoBasico = sueldoBasico;
        this.sueldoTotal = sueldoTotal;
    }

}
