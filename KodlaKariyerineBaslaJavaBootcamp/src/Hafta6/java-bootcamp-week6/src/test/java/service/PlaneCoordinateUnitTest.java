package service;

import com.example.javabootcampweek6.converter.PlaneConverter;
import com.example.javabootcampweek6.entity.*;
import com.example.javabootcampweek6.requestDTO.PlaneSaveRequestDTO;
import com.example.javabootcampweek6.responseDTO.PlaneResponseDTO;
import com.example.javabootcampweek6.service.PlaneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


//test classım
@ExtendWith(MockitoExtension.class)
public class PlaneCoordinateUnitTest {

    //asıl mock
    @InjectMocks
    PlaneService planeService;

    //diğer kullanılacak mocklar
    @Mock
    PlaneConverter planeConverter;

    //pegasus plane save testing
    @Test
    void savePagasusTest() {
        //atamalar
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
        //kontrol
        Assertions.assertEquals(1,planeSaveSuccess);
    }
    //thy plane save testing
    @Test
    void saveTHYTest() {
        //atamalar
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
        //kontrol
        Assertions.assertEquals(1,planeSaveSuccess);
    }
    //onur air plane save testing
    @Test
    void saveOnurAirTest() {
        //atamalar
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
        //kontrol
        Assertions.assertEquals(1,planeSaveSuccess);
    }

    //onur air uçakta kalan yeri test eden fonksiyon
    @Test
    void remainderCapacityOnurAirTest(){
        //instaces oluştur
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        OnurAir onurAirPlane = planeConverter.convertFromPlaneResponseDTOToOnurAir(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = onurAirPlane.getCapacity() - onurAirPlane.getPassengerCount();
        int result = planeService.remainderCapacityOnurAir(planeResponseDTO);
        //kontrol
        Assertions.assertEquals(remainder, result);

    }
    //pegasus uçakta kalan yeri test eden fonksiyon
    @Test
    void remainderCapacityPegasusTest(){
        //instance
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        Pegasus pegasusPlane = planeConverter.convertFromPlaneResponseDTOToPegasus(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = pegasusPlane.getCapacity() - pegasusPlane.getPassengerCount();
        int result = planeService.remainderCapacityTHY(planeResponseDTO);
        //kontrol
        Assertions.assertEquals(remainder, result);

    }

    //thy uçakta kalan yeri test eden fonksiyon
    @Test
    void remainderCapacityTHYTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        THY thyPlane = planeConverter.convertFromPlaneResponseDTOToTHY(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = thyPlane.getCapacity() - thyPlane.getPassengerCount();
        int result = planeService.remainderCapacityTHY(planeResponseDTO);
        //kontrol
        Assertions.assertEquals(remainder, result);

    }

    //uçak dolu mu testi - başarısız
    @Test
    void isItFullNonTest( ){
        //bu kadar boş yer var
        int remainder = 20;
        boolean result = planeService.isItFull(remainder);
        //true dönmeli
        Assertions.assertTrue(result);
    }

    //uçak dolu mu testi - başarılı
    @Test
    void isItFullTest( ){
        //boş yer yok
        int remainder = 0;
        boolean result = planeService.isItFull(remainder);
        //false dönmeli
        Assertions.assertFalse(result);
    }

    //bilet almak isteyen yolcu sayısı kadar yer var mı test pegasus- başarılı
    @Test
    void isThereEnoughSeatPegasusTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatPegasus(personCount,planeResponseDTO);
        //yeterli alan var 1 dönmeli
        Assertions.assertEquals(1,result);

    }
    //bilet almak isteyen yolcu sayısı kadar yer var mı test pegasus- başarısız
    @Test
    void isThereEnoughSeatPegasusNonTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(95);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatPegasus(personCount,planeResponseDTO);
        //yeterli alan yok -1 dönmeli
        Assertions.assertEquals(-1,result);

    }
    //bilet almak isteyen yolcu sayısı kadar yer var mı test thy- başarılı
    @Test
    void isThereEnoughSeatTHYTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatTHY(personCount,planeResponseDTO);
        //yeterli alan var 1 dönmeli
        Assertions.assertEquals(1,result);

    }
    //bilet almak isteyen yolcu sayısı kadar yer var mı test thy- başarısız
    @Test
    void isThereEnoughSeatTHYNonTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(100);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatTHY(personCount,planeResponseDTO);
       //yeterli alan yok -1 dönmeli
        Assertions.assertEquals(-1,result);

    }
    //bilet almak isteyen yolcu sayısı kadar yer var mı test onur air- başarılı
    @Test
    void isThereEnoughSeatOnurAirTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(80);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatOnurAir(personCount,planeResponseDTO);
        //yeterli alan var 1 dönmeli
        Assertions.assertEquals(1,result);

    }
    //bilet almak isteyen yolcu sayısı kadar yer var mı test onur air- başarısı
    @Test
    void isThereEnoughSeatOnurAirNonTest(){
        //instances
        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();
        planeResponseDTO.setCapacity(100);
        planeResponseDTO.setPassengerCount(92);
        int personCount = 10;
        int result = planeService.isThereEnoughSeatOnurAir(personCount,planeResponseDTO);
        //yeterli alan yok -1 dönmeli
        Assertions.assertEquals(-1,result);
    }

    //uçak yolcusu ek ücretlendirme için business ve age koşullarını sağlar
    @Test
    void ticketFarePegasusBussinessAndAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(5);
        passenger.setBusiness(true);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        //310 dönmeli
        Assertions.assertEquals(310, result);

    }
    //uçak yolcusu ek ücretlendirme için age koşullarını sağlar
    @Test
    void ticketFarePegasusNonBusinessAndAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(5);
        passenger.setBusiness(false);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        //180 dönmeli
        Assertions.assertEquals(180, result);


    }
    //uçak yolcusu ek ücretlendirme için business koşullarını sağlar
    @Test
    void ticketFarePegasusBusinessAndNonAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(20);
        passenger.setBusiness(true);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        //330 dönmeli
        Assertions.assertEquals(330, result);

    }
    //uçak yolcusu ek ücretlendirme için business ve age koşullarını sağlamaz
    @Test
    void ticketFarePegasusNonBussinessAndNonAgeTest(){
        Passenger passenger = new Passenger();
        passenger.setAge(20);
        passenger.setBusiness(false);
        double fare = 200;
        double result = planeService.ticketFarePegasus(fare,passenger);
        //200 dönmeli
        Assertions.assertEquals(200, result);

    }

    //uçak yolcusu ek ücretlendirme için business ve suitcase weight koşullarını sağlar
    @Test
    void ticketFareOnurAirBussinessAndWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(true);
        passenger.setSuitcaseWeight(30);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        //425 dönmeli
        Assertions.assertEquals(425, result);

    }
    //uçak yolcusu ek ücretlendirme için suitcase weight koşullarını sağlar
    @Test
    void ticketFareOnurAirNonBusinessAndWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(false);
        passenger.setSuitcaseWeight(30);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        //225 dönmeli
        Assertions.assertEquals(225, result);

    }
    //uçak yolcusu ek ücretlendirme için business koşullarını sağlar
    @Test
    void ticketFareOnurAirBusinessAndNonWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(true);
        passenger.setSuitcaseWeight(20);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        //350 dönmeli
        Assertions.assertEquals(350, result);

    }
    //uçak yolcusu ek ücretlendirme için business ve suitcase weight koşullarını sağlamaz
    @Test
    void ticketFareOnurAirNonBussinessAndNonWeightTest(){
        Passenger passenger = new Passenger();
        passenger.setBusiness(false);
        passenger.setSuitcaseWeight(20);
        double fare = 150;
        double result = planeService.ticketFareOnurAir(fare,passenger);
        //150 dönmeli
        Assertions.assertEquals(150, result);

    }

}
