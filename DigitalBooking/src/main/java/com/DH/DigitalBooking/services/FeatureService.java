package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.FeatureDTO;
import com.DH.DigitalBooking.models.entities.Feature;
import com.DH.DigitalBooking.repositories.FeatureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FeatureService implements IFeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    ObjectMapper mapper;

    //@Autowired
    //private static final Logger logger = Logger.getLogger(CaracteristicaService.class);

    @Override
    public Feature addFeature(FeatureDTO featureDTO) throws ResourceNotFoundException {
        if(featureDTO.getDescription()==null || featureDTO.getIcon() == null)
            throw  new ResourceNotFoundException("Intenta crear una caracteristica incompleta. Todos los datos son requeridos");
        Feature feature = mapper.convertValue(featureDTO, Feature.class);
        //logger.info("La caracteristica se agregó correctamente");
        return featureRepository.save(feature);
    }


    @Override
    public Set<FeatureDTO> listNonRepeatedFeatures() {
        List<Feature> features = featureRepository.findAll();
        List<Feature> nonRepeatedFeatures = new ArrayList<>();
        Set<FeatureDTO> featureDTO = new HashSet<>();


        for (Feature featureToCompare : features) {
            Integer flag = 1;
            if(nonRepeatedFeatures.isEmpty()){
                nonRepeatedFeatures.add(featureToCompare);
            }else{
                for (int i = 0; i < nonRepeatedFeatures.size(); i++) {
                    if(featureToCompare.getDescription().equals(nonRepeatedFeatures.get(i).getDescription())){
                        flag=0;
                    }
                }

                if(flag==1){
                    nonRepeatedFeatures.add(featureToCompare);
                }
            }
        }


        for(Feature feature : nonRepeatedFeatures) {
            featureDTO.add(mapper.convertValue(feature, FeatureDTO.class));
        }


        //logger.info("Las caracteristicas se listaron correctamente");
        return featureDTO;
    }



}



