package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.models.dto.RoleDTO;

import java.util.List;

public interface IRoleService {

    public List<RoleDTO> findAll();

    public RoleDTO save(RoleDTO role);

    public RoleDTO update(RoleDTO role);

    public RoleDTO delete(RoleDTO role);
}
