package com.reto.service;

import com.reto.model.Cabin;

import java.util.List;
import java.util.Optional;

public interface CabinService {
    List<Cabin> getCabin();

    Cabin postCabin(Cabin cabin);

    Cabin putCabin(Cabin cabin);

    Optional<Cabin> getCabinById(Integer idCabin);

    boolean deleteCabin(Integer idCabin);
}
