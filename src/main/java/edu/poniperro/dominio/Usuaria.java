package edu.poniperro.dominio;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "t_users")
public class Usuaria extends PanacheEntityBase {


    @Id
    @Column(name = "user_nom")
    private String name;

    @Column(name = "user_prop")
    private int prop;

    public Usuaria() {} //Empty method to create instances of Usuaria

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public int getDestreza() {
        return prop;
    }

    public void setDestreza(int valor) {
        this.prop = valor;
    }
    
}
