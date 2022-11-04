package com.dh.CrudCategorias;
import com.dh.CrudCategorias.models.Ciudad;
import com.dh.CrudCategorias.repositories.CiudadRepository;
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
public class CiudadServiceTest {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Test
    public void crearCiudadTest() {
        Ciudad ciudad= new Ciudad("Quilmes", "Argentina");
        ciudadRepository.save(ciudad);
    }



}
