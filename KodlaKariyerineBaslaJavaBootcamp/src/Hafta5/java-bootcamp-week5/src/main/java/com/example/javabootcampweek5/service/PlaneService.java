package com.example.javabootcampweek4.service;

import com.example.javabootcampweek4.converter.PlaneConverter;
import com.example.javabootcampweek4.entity.*;
import com.example.javabootcampweek4.repository.PlaneRepository;
import com.example.javabootcampweek4.requestDTO.PlaneSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//plane service katmanı
@Service
public class PlaneService {
    //autowired repository and converter
    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    PlaneConverter planeConverter;
    //thy uçağı kaydedip id'sini döndüren fonksiyon
    public Integer saveTHY(PlaneSaveRequestDTO planeSaveRequestDTO) {
        //dto'dan thy'ye convert et
        THY thyPlane = planeConverter.convertFromPlaneSaveRequestDTOToTHY(planeSaveRequestDTO);
        //kaydet
        thyPlane = planeRepository.save(thyPlane);
        //id'sini döndür
        return thyPlane.getPlaneId();

    }
    //pegasus uçağı kaydedip id'sini döndüren fonksiyon
    public Integer savePegasus(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto'dan pegasusa convert et
        Pegasus pegasusPlane = planeConverter.convertFromPlaneSaveRequestDTOToPegasus(planeSaveRequestDTO);
        //kaydet
        pegasusPlane = planeRepository.save(pegasusPlane);
        //id'sini döndür
        return pegasusPlane.getPlaneId();
    }
    //onur air uçağı kaydedip id'sini döndüren fonksiyon
    public Integer saveOnurAir(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto'dan onur aira convert et
        OnurAir onurAirPlane = planeConverter.convertFromPlaneSaveRequestDTOToOnurAir(planeSaveRequestDTO);
       //kaydet
        onurAirPlane = planeRepository.save(onurAirPlane);
        //id'sini döndür
        return onurAirPlane.getPlaneId();
    }
}
