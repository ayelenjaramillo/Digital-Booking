package com.dh.CrudCategorias;

import com.dh.CrudCategorias.models.Category;
import com.dh.CrudCategorias.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    //@Test
    public void crearCategoriaTest() {
        Category category = new Category("Hotel", "Estos son los hoteles que tenemos para vos");
        categoryRepository.save(category);
    }


}
