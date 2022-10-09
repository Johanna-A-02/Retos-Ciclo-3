package com.reto.service.impl;

import com.reto.model.Score;
import com.reto.repository.ScoreRepository;
import com.reto.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<Score> getScore(){
        List<Score> response = new ArrayList<>();
        scoreRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public Score postScore(Score score) {
        scoreRepository.save(score);
        return score;
    }
}
