package com.dh.CrudCategorias;

import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //@Test
    public void crearCategoriaTest() {
        Categoria categoria= new Categoria("Hotel", "Estos son los hoteles que tenemos para vos");
        categoriaRepository.save(categoria);
    }


}
