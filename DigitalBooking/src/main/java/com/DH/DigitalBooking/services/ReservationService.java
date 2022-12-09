package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.models.entities.User;
import com.DH.DigitalBooking.models.dto.ReservationDTO;
import com.DH.DigitalBooking.repositories.*;
import com.DH.DigitalBooking.models.entities.Reservation;
import java.time.LocalDate;
import java.util.*;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
//import com.DH.DigitalBooking.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

    //protected final static Logger logger = Logger.getLogger(ReservationServices.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImp;

    @Autowired
    private ProductService productService;

    @Autowired
    private IUserService userService;


      /*@Autowired
    private ReservationProductDTO reservationProductDTO;*/

    @Autowired
    ObjectMapper mapper;

   // @Autowired
    //private MapperUtil mapperUtil;


    @Override
    public Reservation checkId(Long idReservation) throws ResourceNotFoundException {
        Optional<Reservation> reservation = reservationRepository.findById(idReservation);
        if(reservation.isPresent()){
            return reservation.get();
        }else{
            throw new ResourceNotFoundException("Could not find specified resource.");
        }
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException {
        List<Reservation> reservations = reservationRepository.findByDatesBetweenAndProductId(reservationDTO.getCheckInDate(), reservationDTO.getCheckOutDate(), reservationDTO.getProductId());
        if(reservations.size() > 0)
        {
            throw new ResourceNotFoundException("Esta fecha no está disponible");
        }

        Reservation reservation = mapper.convertValue(reservationDTO, Reservation.class);
        reservation.setProduct(productRepository.findById(reservationDTO.getProductId()).get());
        reservation.setUser(userRepository.findById(reservationDTO.getUserId()).get());
        reservation = reservationRepository.save(reservation);
        ReservationDTO reservationDTO1 = mapper.convertValue(reservation, ReservationDTO.class);
        reservationDTO1.setProductId(reservation.getProduct().getId());
        User user = userRepository.findById(reservationDTO.getUserId()).get();
        return reservationDTO;
    }

    @Override
    public ReservationDTO findById(Long id) throws ResourceNotFoundException {
        Reservation reservation = checkId(id);
        ReservationDTO reservationDTO = mapper.convertValue(reservation, ReservationDTO.class);
        reservationDTO.setProductId(reservation.getProduct().getId());
        //logger.info("La busqueda fue exitosa: id " + id);
        return reservationDTO;
    }


    @Override
    public List<ReservationDTO> findAll() {
        List<ReservationDTO> reservationsDTO = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findAll();
        for(Reservation reservation: reservations){
            ReservationDTO reservationDTO = mapper.convertValue(reservation, ReservationDTO.class);
            reservationDTO.setProductId(reservation.getProduct().getId());
            reservationsDTO.add(reservationDTO);
        }
        reservationsDTO .sort(Comparator.comparing(ReservationDTO::getId));
        //logger.info("La busqueda fue exitosa: "+ bookings);
        return reservationsDTO;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        reservationRepository.deleteById(id);
        //logger.info("Se elimino la reserva correctamente con el id("+id+")");
    }

    @Override
    public void saveReservations(List<Reservation> reservationList) {
        reservationRepository.saveAll(reservationList);
    }


    @Override
    public List <ReservationDTO> findBetweenTwoDates(LocalDate checkInDate, LocalDate checkInOut) throws ResourceNotFoundException {
        List <Reservation> reservations = reservationRepository.findByDatesBetween(checkInDate, checkInOut);
        List <ReservationDTO> reservationDTOList = new ArrayList<>();

        reservations.forEach(reservation ->
                reservationDTOList.add(mapper.convertValue(reservation, ReservationDTO.class)));

        for (ReservationDTO reservationDTO : reservationDTOList) {
            Reservation reservation = checkId(reservationDTO.getId());
            reservationDTO.setProductId(reservation.getProduct().getId());
        }

        return reservationDTOList;
    }

    @Override
    public List<ReservationDTO> findReservationByProductId(Long productId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ReservationDTO> findReservationByUserId(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ReservationDTO> findAllByProductId(Long productId) throws ResourceNotFoundException {
        return null;
    }


}
