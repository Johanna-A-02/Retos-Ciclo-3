package com.reto.service;

import com.reto.model.Cabin;

import java.util.List;

public interface CabinService {
    List<Cabin> getCabin();

    String postCabin(Cabin cabin);
}
