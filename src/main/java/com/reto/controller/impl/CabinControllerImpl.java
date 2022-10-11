package com.reto.controller.impl;

import com.reto.controller.CabinAPI;
import com.reto.model.Cabin;
import com.reto.model.Client;
import com.reto.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabinControllerImpl implements CabinAPI {

    @Autowired
    private CabinService cabinService;

    @Override
    public ResponseEntity <?> getCabin(){
        List<Cabin> lista = cabinService.getCabin();
        ResponseEntity<?> response = new ResponseEntity(lista, HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postCabin(Cabin cabin) {
        ResponseEntity<?> response = new ResponseEntity(cabinService.postCabin(cabin), HttpStatus.CREATED);
        return response;
    }
    @Override
    public ResponseEntity<?> putCabin(Cabin cabin) {
        ResponseEntity<?> response = new ResponseEntity(cabinService.putCabin(cabin), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getCabinById(Integer idCabin) {
        ResponseEntity<?> response = new ResponseEntity(cabinService.getCabinById(idCabin), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteCabin(Integer idCabin) {
        ResponseEntity<?> response = new ResponseEntity(cabinService.deleteCabin(idCabin), HttpStatus.NO_CONTENT);
        return response;
    }

}
