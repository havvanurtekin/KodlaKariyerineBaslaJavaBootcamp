package com.example.javabootcampweek4.service;

import com.example.javabootcampweek4.converter.PlaneConverter;
import com.example.javabootcampweek4.entity.*;
import com.example.javabootcampweek4.repository.PlaneRepository;
import com.example.javabootcampweek4.requestDTO.PlaneSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaneService {

    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    PlaneConverter planeConverter;

    public Integer saveTHY(PlaneSaveRequestDTO planeSaveRequestDTO) {
        THY thyPlane = planeConverter.convertFromPlaneSaveRequestDTOToTHY(planeSaveRequestDTO);
        thyPlane = planeRepository.save(thyPlane);
        return thyPlane.getPlaneId();

    }
    public Integer savePegasus(PlaneSaveRequestDTO planeSaveRequestDTO){
        Pegasus pegasusPlane = planeConverter.convertFromPlaneSaveRequestDTOToPegasus(planeSaveRequestDTO);
        pegasusPlane = planeRepository.save(pegasusPlane);
        return pegasusPlane.getPlaneId();
    }
    public Integer saveOnurAir(PlaneSaveRequestDTO planeSaveRequestDTO){
        OnurAir onurAirPlane = planeConverter.convertFromPlaneSaveRequestDTOToOnurAir(planeSaveRequestDTO);
        onurAirPlane = planeRepository.save(onurAirPlane);
        return onurAirPlane.getPlaneId();
    }
}
