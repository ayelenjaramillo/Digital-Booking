package com.dh.CrudCategorias;
import com.dh.CrudCategorias.models.*;
//import com.dh.CrudCategorias.repositories.CaracteristicaRepository;
import com.dh.CrudCategorias.repositories.CategoriaRepository;
import com.dh.CrudCategorias.repositories.CiudadRepository;
import com.dh.CrudCategorias.repositories.ProductoRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
    public class ProductoServiceTest {

        @Autowired
        /*private CategoriaRepository categoriaRepository;
        private CiudadRepository ciudadRepository;*/
        private ProductoRepository productoRepository;
        //private CaracteristicaRepository caracteristicaRepository;


       @Test
        public void crearProductoTest() {
           /* Categoria categoria= new Categoria("Hotel", "Estos son los hoteles que tenemos para vos");
            categoriaRepository.save(categoria);
            Ciudad ciudad= new Ciudad("Berazategui","Argentina");
            ciudadRepository.save(ciudad);*/
            //Caracteristica caracteristica = new Caracteristica("Apto mascota","/patita.png");
            //caracteristicaRepository.save(caracteristica);
            Producto producto = new Producto("hotel","Calle 148 Y 16", 3);
            productoRepository.save(producto);

        }

    }



