package com.dh.CrudCategorias;
import com.dh.CrudCategorias.models.City;
import com.dh.CrudCategorias.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CiudadServiceTest {

    @Autowired
    private CityRepository ciudadRepository;

    //@Test
    public void crearCiudadTest() {
        City city = new City("Quilmes", "Argentina");
        ciudadRepository.save(city);
    }



}
