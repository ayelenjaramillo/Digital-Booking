package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.City;
import com.DH.DigitalBooking.models.Policy;
import com.DH.DigitalBooking.models.Product;
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
        return policyRepository.findAll();
    }


    public Policy findById(Long id) throws ResourceNotFoundException {
     /*   Optional<Policy> result = policyRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("The specified policy could not be found");
        }*/
        if(id == null){
            throw new ResourceNotFoundException("No ID received");
        }
        Optional<Policy> result = policyRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("Specified policy could not be found.");
        }
    }

    public Policy create(Policy policy) throws CreatingExistingEntityException {
        if (policy.getId() != null){
            throw new CreatingExistingEntityException("Policy' IDs are auto-generated, you cannot specify it");
        }
        return policyRepository.save(policy);
    }


    public Policy edit(Policy policy) throws ResourceNotFoundException, EmptyFieldException {
        if(policy.getId() == null){
            throw new EmptyFieldException("Policy must have an id to edit");
        }
        findById(policy.getId());
        return policyRepository.save(policy);
    }


    public Policy delete(Policy policy) throws EmptyFieldException {
        if(policy.getId() == null){
            throw new EmptyFieldException("City must have an id to delete");
        }
        policyRepository.delete(policy);
        return policy;
    }


    public Policy deleteById(Long id) throws ResourceNotFoundException {
        List<Product> productos = policyRepository.findAllByPolicyId(id);
        if(productos.size() != 0){
//            MODIFICAR CREANDO NUEVA EXCEPTION
            throw new ResourceNotFoundException("Cannot delete policies with associated products");
        }
        Policy result = findById(id);
        policyRepository.delete(result);
        return result;
    }
}
