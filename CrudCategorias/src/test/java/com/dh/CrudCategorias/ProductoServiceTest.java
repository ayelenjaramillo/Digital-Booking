package com.dh.CrudCategorias;
import com.dh.CrudCategorias.models.*;
//import com.dh.CrudCategorias.repositories.CaracteristicaRepository;
import com.dh.CrudCategorias.repositories.CategoriaRepository;
import com.dh.CrudCategorias.repositories.CiudadRepository;
import com.dh.CrudCategorias.repositories.ImagenRepository;
import com.dh.CrudCategorias.repositories.ProductoRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

//@AutoConfigureMockMvc //acordate de tirar las excepciones que pide

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest

    public class ProductoServiceTest {

        //@Autowired
        //private MockMvc mockMvc;

        private CategoriaRepository categoriaRepository;
        private CiudadRepository ciudadRepository;
        private ProductoRepository productoRepository;
        //private CaracteristicaRepository caracteristicaRepository;
        private ImagenRepository imagenesRepository;


       @Test
        public void crearProductoTest() {

            Categoria categoria= new Categoria("Hotel","Hermoso hotel");
            Ciudad ciudad= new Ciudad("Berazategui","Argentina");
            Imagen imagen = new Imagen("imagen1","www.hotel-aklsslkad.com/1");
            Imagen imagen1 = new Imagen("imagen2","www.hotel-aklsslkad.com/2");
            Producto producto = new Producto("hotel El Primero","Calle 148 Y 16", 3, "No dejamos hacer nada",true,categoria,Set.of(imagen1,imagen));
            productoRepository.save(producto);


        }


       /* @Test
        public void crearProductoSincategoriaTest(){

            Categoria categoria= new Categoria("Hotel", "Estos son los hoteles que tenemos para vos");
            categoriaRepository.save(categoria);
            Ciudad ciudad= new Ciudad("Berazategui","Argentina");
            ciudadRepository.save(ciudad);
            Caracteristica caracteristica = new Caracteristica("Apto mascota","/patita.png");
            caracteristicaRepository.save(caracteristica);
            Producto producto = new Producto(categoria,"Hotel Panamericano","calle 150 y 16",2);
            productoRepository.save(producto);
            Categoria categoria= new Categoria("Hotel", "Estos son los hoteles que tenemos para vos");
            categoriaRepository.save(categoria);
            Producto producto = new Producto("Hotel Estrellas", "calle 25 numero 2456",3);
            productoRepository.save(producto);
        }
        */

         /*
        @Test
        public void crearProductoConCategoriaTest(){
            Categoria categoria= new Categoria("Hotel", "Estos son los hoteles que tenemos para vos");
            categoriaRepository.save(categoria);
            Producto producto = new Producto(categoria,"Hotel Panamericano","calle 150 y 16",2);
            //productoRepository.save(producto)
        }


        @Test
        public void buscarProductoSinCateforiaTest(){
            Categoria categoria= new Categoria("Hostel", "Estos son los hostels que te ofrecemos");
            categoriaRepository.save(categoria);
            Producto producto = new Producto("Hotel Luces","Av.Lisandro de la Torre 2906",2);
            //productoRepository.findById(1);
        }
        */


    }



