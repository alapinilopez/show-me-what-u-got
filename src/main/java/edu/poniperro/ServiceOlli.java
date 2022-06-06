package edu.poniperro;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import edu.poniperro.dominio.Item;
import edu.poniperro.dominio.Orden;
import edu.poniperro.dominio.Usuaria;

@ApplicationScoped
public class ServiceOlli {

    public ServiceOlli () {}

    
    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre);
        return usuaria.isPresent()? usuaria.get(): new Usuaria();
    }

    public Item cargaItem(String nombre) {
        Optional<Item> item = Item.findByIdOptional(nombre);
        return item.isPresent()? item.get(): new Item();
    }

    public List<Orden> cargaOrden(String nombre) {
        return null;
    }

    @Transactional
    public Orden comanda(String usuaria_nombre, String item_nombre) {
        Orden orden = null;
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(usuaria_nombre);
        Optional<Item> item = Item.findByIdOptional(item_nombre);
        if (usuaria.isPresent() && item.isPresent() && usuaria.get().getDestreza() >= item.get().getQuality()) {
            orden = new Orden(usuaria.get(), item.get());
            orden.persist();
        }
        return orden;
    }
}
