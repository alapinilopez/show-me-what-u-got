package edu.poniperro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.inject.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.poniperro.dominio.Item;
import edu.poniperro.dominio.Orden;
// import org.pingpong.onequarkusapp.dominio.Orden;
import edu.poniperro.dominio.Usuaria;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ServiceTest {

    @PersistenceContext
    EntityManager em;

    @Inject
    ServiceOlli servicio;

    /**
	 * MAPPINGS de la entidades a las tablas de la BBDD.
	 * 
	 * Observa el esquema de la base de datos que espera 
	 * la aplicacion en el fichero:
	 * schema.sql
	 */
	
	/**
	 * Completa la definicion y el mapping
	 * de la clase Item a la tabla t_items
	 */
    @Test
    public void test_mapping_normalItem() {
        Item elixir = em.find(Item.class, "Elixir of the Mongoose");
        Assertions.assertThat(elixir).isNotNull();
        Assertions.assertThat(elixir.getNombre()).isEqualTo("Elixir of the Mongoose");
		Assertions.assertThat(elixir.getQuality()).isEqualTo(7);
        Assertions.assertThat(elixir.getTipo()).isEqualTo("NormalItem");
    }


	/**
	 * Completa la definicion y el mapping
	 * de la clase Usuaria a la tabla t_users
	 */
	@Test
	public void test_mapping_usuaria() {
		Usuaria elfo = em.find(Usuaria.class, "Doobey");
        Assertions.assertThat(elfo).isNotNull();
        Assertions.assertThat(elfo.getNombre()).isEqualTo("Doobey");
        Assertions.assertThat(elfo.getDestreza()).isEqualTo(15);
	}

    /**
	 * Completa la definicion y el mapping
	 * de la clase Orden a la tabla t_ordenes
	 * El id de esta clase ha de seguir una estrategia Identity
	 */

	    /**
	 * Completa la definicion y el mapping
	 * de la clase Orden a la tabla t_ordenes
	 * El id de esta clase ha de seguir una estrategia Identity
	 */
	@Test 
	public void test_mapping_orden() {
		Orden pedido = em.find(Orden.class, 1L);
        Assertions.assertThat(pedido).isNotNull();
        Assertions.assertThat(pedido.getUser().getNombre()).isEqualTo("Doobey");
		Assertions.assertThat(pedido.getItem().getNombre()).isEqualToIgnoringCase("Elixir of the Mongoose");
	}

	/** SERVICIO */

    /**
	 * Crea una clase llamada ServiceOlli e indica
	 * que es una dependencia Quarkus 
	 */

    @Test
	public void test_inyeccion_servicio() {
		Assertions.assertThat(servicio).isNotNull();
	}

	/**
	 * Implementa el metodo cargaUsuaria del servicio.
	 * Devuelve la usuaria con el nombre indicado, si existe.
	 * Si no existe, devuelve un objeto usuaria con sus propiedades
     * y valores como se indica en los casos test.
	 */

	@Test
	public void test_carga_usuaria() {
		Assertions.assertThat(servicio).isNotNull();
		Usuaria elfo = servicio.cargaUsuaria("Doobey");
		Assertions.assertThat(elfo).isNotNull();
		Assertions.assertThat(elfo.getNombre()).isEqualTo("Doobey");
        Assertions.assertThat(elfo.getDestreza()).isEqualTo(15);
	}

    @Test
	public void test_carga_usuaria_no_existe() {
		Assertions.assertThat(servicio).isNotNull();
		Usuaria profesor = servicio.cargaUsuaria("Severus");
		Assertions.assertThat(profesor).isNotNull();
		Assertions.assertThat(profesor.getNombre()).isEmpty();
        Assertions.assertThat(profesor.getDestreza()).isZero();
	}

	 /**
	 * Implementa el metodo cargaItem del servicio.
	 * Devuelve el item con el nombre indicado, si existe.
     * Si no existe, devuelve un objeto Item con sus propiedades
     * y valores como se indica en los casos test.
	 */

    @Test
	public void test_carga_item() {
        Assertions.assertThat(servicio).isNotNull();
		Item item = servicio.cargaItem("Elixir of the Mongoose");
		Assertions.assertThat(item).isNotNull();
		Assertions.assertThat(item.getNombre()).isEqualTo("Elixir of the Mongoose");
		Assertions.assertThat(item.getQuality()).isEqualTo(7);
	}

	@Test
	public void test_carga_item_no_existe() {
        Assertions.assertThat(servicio).isNotNull();
		Item item = servicio.cargaItem("Reliquias de la muerte");
		Assertions.assertThat(item).isNotNull();
		Assertions.assertThat(item.getNombre()).isEmpty();
		Assertions.assertThat(item.getQuality()).isZero();
	}

	/**
	 * Implementa el metodo cargaOrden del servicio.
	 * Devuelve una lista con los pedidos de la usuaria 
	 * con el nombre indicado, si existe.
     * Si no existe, devuelve una lista vacía.
	 */

    @Test
	public void test_carga_orden() {
        Assertions.assertThat(servicio).isNotNull();
		List<Orden> ordenes = servicio.cargaOrden("Hermione");
		Assertions.assertThat(ordenes).isNotNull();
		Assertions.assertThat(ordenes).hasSize(1);
		Assertions.assertThat(ordenes.get(0).getUser().getNombre()).isEqualToIgnoringCase("Hermione");
		Assertions.assertThat(ordenes.get(0).getItem().getNombre()).isEqualTo("+5 Dexterity Vest");
		// Assertions.assertThat(ordenes).allMatch(orden -> orden.getUser().getNombre().equalsIgnoreCase("Hermione"));
		// Assertions.assertThat(ordenes).allMatch(orden -> orden.getItem().getNombre().equalsIgnoreCase("+5 Dexterity Vest"));
	}
}