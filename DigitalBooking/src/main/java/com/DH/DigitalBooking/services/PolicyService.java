package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.Policy;
import com.DH.DigitalBooking.repositories.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;


    public List<Policy> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Policy findById(Long id) throws ResourceNotFoundException {
        Optional<Policy> result = policyRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("The specified policy could not be found");
        }
    }

    public Policy create(Policy policy) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet."); // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } //https://docs.oracle.com/javase/7/docs/api/java/lang/UnsupportedOperationException.html


    public Policy edit(Policy t) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Policy delete(Policy t) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Policy deleteById(Long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
