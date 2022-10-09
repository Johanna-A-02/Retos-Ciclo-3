package com.reto.service.impl;

import com.reto.model.Message;
import com.reto.model.Score;
import com.reto.repository.ScoreRepository;
import com.reto.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        if(score.getIdScore() == null){
            scoreRepository.save(score);
        }else{
            Optional<Score> scoreOptional = scoreRepository.findById(score.getIdScore());
            if(scoreOptional.isEmpty()){
                score = scoreRepository.save(score);
            }else{
                score = scoreOptional.get();
            }
        }

        return score;
    }
}
