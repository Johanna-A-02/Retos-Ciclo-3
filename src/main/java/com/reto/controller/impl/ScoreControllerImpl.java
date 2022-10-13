package com.reto.controller.impl;

import com.reto.controller.ScoreAPI;
import com.reto.model.Score;
import com.reto.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreControllerImpl implements ScoreAPI {

    @Autowired
    private ScoreService scoreService;

    @Override
    public ResponseEntity<?> getScore(){
        ResponseEntity<?> response = new ResponseEntity(scoreService.getScore(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postScore(Score score) {
        ResponseEntity<?> response = new ResponseEntity(scoreService.postScore(score), HttpStatus.CREATED);
        return response;
    }
    @Override
    public ResponseEntity<?> putScore (Score score) {
        ResponseEntity<?> response = new ResponseEntity(scoreService.putScore(score), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getScoreById(Integer idScore) {
        ResponseEntity<?> response = new ResponseEntity(scoreService.getScoreById(idScore), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteScore(Integer idScore) {
        ResponseEntity<?> response = new ResponseEntity(scoreService.deleteScore(idScore), HttpStatus.NO_CONTENT);
        return response;
    }
}
