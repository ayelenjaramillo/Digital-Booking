package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.FeatureDTO;
import com.DH.DigitalBooking.models.entities.Feature;
import java.util.Set;

public interface IFeatureService {

    Feature addFeature(FeatureDTO featureDTO) throws ResourceNotFoundException;
    Set<FeatureDTO> listNonRepeatedFeatures();



}
