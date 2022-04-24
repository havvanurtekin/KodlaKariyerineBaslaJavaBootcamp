package service;

import com.example.javabootcampweek6.converter.PlaneConverter;
import com.example.javabootcampweek6.entity.*;
import com.example.javabootcampweek6.repository.PassengerRepository;
import com.example.javabootcampweek6.repository.PlaneRepository;
import com.example.javabootcampweek6.requestDTO.PlaneSaveRequestDTO;
import com.example.javabootcampweek6.responseDTO.PlaneResponseDTO;
import com.example.javabootcampweek6.service.PlaneService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.IntegerAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlaneCoordinateUnitTest {

    @InjectMocks
    PlaneService planeService;

    @Mock
    PlaneRepository planeRepository;

    @Mock
    PlaneConverter planeConverter;

    @Mock
    PassengerRepository passengerRepository;

    @Test
    void savePagasusTest() {
        PlaneSaveRequestDTO planeSaveRequestDTO = new PlaneSaveRequestDTO();
        planeSaveRequestDTO.setBusinessCapacity(100);
        planeSaveRequestDTO.setCapacity(200);
        planeSaveRequestDTO.setFare(250);
        LocalDate localdate = LocalDate.parse("2020-01-08");
        planeSaveRequestDTO.setTicketPurchaseDate(localdate);
        LocalDate date = LocalDate.parse("2020-01-11");
        planeSaveRequestDTO.setFlightDate(date);

        Plane planeMock = mock(Plane.class);
        //httpStatus.created
        Mockito.when(planeService.savePegasus(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
       //httpStatus.bad_request
        Mockito.when(planeService.savePegasus(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
        Integer planeSaveSuccess = planeService.savePegasus(planeSaveRequestDTO);
        Assertions.assertEquals(1,planeSaveSuccess);
    }

    @Test
    void saveTHYTest() {
        PlaneSaveRequestDTO planeSaveRequestDTO = new PlaneSaveRequestDTO();
        planeSaveRequestDTO.setBusinessCapacity(100);
        planeSaveRequestDTO.setCapacity(200);
        planeSaveRequestDTO.setFare(250);
        LocalDate localdate = LocalDate.parse("2020-01-08");
        planeSaveRequestDTO.setTicketPurchaseDate(localdate);
        LocalDate date = LocalDate.parse("2020-01-11");
        planeSaveRequestDTO.setFlightDate(date);

        Plane planeMock = mock(Plane.class);
        //httpStatus.created
        Mockito.when(planeService.saveTHY(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
        //httpStatus.bad_request
        Mockito.when(planeService.saveTHY(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
        Integer planeSaveSuccess = planeService.saveTHY(planeSaveRequestDTO);
        Assertions.assertEquals(1,planeSaveSuccess);
    }

    @Test
    void saveOnurAirTest() {
        PlaneSaveRequestDTO planeSaveRequestDTO = new PlaneSaveRequestDTO();
        planeSaveRequestDTO.setBusinessCapacity(100);
        planeSaveRequestDTO.setCapacity(200);
        planeSaveRequestDTO.setFare(250);
        LocalDate localdate = LocalDate.parse("2020-01-08");
        planeSaveRequestDTO.setTicketPurchaseDate(localdate);
        LocalDate date = LocalDate.parse("2020-01-11");
        planeSaveRequestDTO.setFlightDate(date);

        Plane planeMock = mock(Plane.class);
        //httpStatus.created
        Mockito.when(planeService.saveOnurAir(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
        //httpStatus.bad_request
        Mockito.when(planeService.saveOnurAir(Mockito.any(PlaneSaveRequestDTO.class))).thenReturn(planeMock.getPlaneId());
        Integer planeSaveSuccess = planeService.saveOnurAir(planeSaveRequestDTO);
        Assertions.assertEquals(1,planeSaveSuccess);
    }

    @Test
    void remainderCapacityOnurAirTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        OnurAir onurAirPlane = planeConverter.convertFromPlaneResponseDTOToOnurAir(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = onurAirPlane.getCapacity() - onurAirPlane.getPassengerCount();
        int result = planeService.remainderCapacityOnurAir(planeResponseDTO);
        Assertions.assertEquals(remainder, result);

    }

    @Test
    void remainderCapacityPegasusTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        Pegasus pegasusPlane = planeConverter.convertFromPlaneResponseDTOToPegasus(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = pegasusPlane.getCapacity() - pegasusPlane.getPassengerCount();
        int result = planeService.remainderCapacityTHY(planeResponseDTO);
        Assertions.assertEquals(remainder, result);

    }

    @Test
    void remainderCapacityTHYTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        THY thyPlane = planeConverter.convertFromPlaneResponseDTOToTHY(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = thyPlane.getCapacity() - thyPlane.getPassengerCount();
        int result = planeService.remainderCapacityTHY(planeResponseDTO);
        Assertions.assertEquals(remainder, result);

    }

    @Test
    void isItFullTest( ){
        int remainder = 20;
        boolean result = planeService.isItFull(remainder);
        Assertions.assertTrue(result);
    }

    @Test
    void isItFullNonTest( ){
        int remainder = 0;
        boolean result = planeService.isItFull(remainder);
        Assertions.assertFalse(result);
    }

    @Test
    void isThereEnoughSeatPegasusTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatPegasus(personCount,planeResponseDTO);
        Assertions.assertEquals(1,result);

    }
    @Test
    void isThereEnoughSeatPegasusNonTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(95);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatPegasus(personCount,planeResponseDTO);
        Assertions.assertEquals(-1,result);

    }
    @Test
    void isThereEnoughSeatTHYTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatTHY(personCount,planeResponseDTO);
        Assertions.assertEquals(1,result);

    }
    @Test
    void isThereEnoughSeatTHYNonTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(100);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatTHY(personCount,planeResponseDTO);
        Assertions.assertEquals(-1,result);

    }
    @Test
    void isThereEnoughSeatOnurAirTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatOnurAir(personCount,planeResponseDTO);
        Assertions.assertEquals(1,result);

    }
    @Test
    void isThereEnoughSeatOnurAirNonTest(){
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(92);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatOnurAir(personCount,planeResponseDTO);
        Assertions.assertEquals(-1,result);
    }

    @Test
    void ticketFarePegasusBussinessAndAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(5);
        passenger.setBusiness(true);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        Assertions.assertEquals(310, result);

    }
    @Test
    void ticketFarePegasusNonBusinessAndAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(5);
        passenger.setBusiness(false);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        Assertions.assertEquals(180, result);


    }
    @Test
    void ticketFarePegasusBusinessAndNonAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(20);
        passenger.setBusiness(true);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        Assertions.assertEquals(330, result);

    }
    @Test
    void ticketFarePegasusNonBussinessAndNonAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(20);
        passenger.setBusiness(false);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        Assertions.assertEquals(200, result);

    }

    @Test
    void ticketFareOnurAirBussinessAndWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(true);
        passenger.setSuitcaseWeight(30);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        Assertions.assertEquals(425, result);

    }
    @Test
    void ticketFareOnurAirNonBusinessAndWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(false);
        passenger.setSuitcaseWeight(30);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        Assertions.assertEquals(225, result);

    }
    @Test
    void ticketFareOnurAirBusinessAndNonWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(true);
        passenger.setSuitcaseWeight(20);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        Assertions.assertEquals(350, result);

    }
    @Test
    void ticketFareOnurAirNonBussinessAndNonWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(false);
        passenger.setSuitcaseWeight(20);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        Assertions.assertEquals(150, result);

    }

}
