package com.reto.service;

import com.reto.model.Client;
import com.reto.model.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreService {

    List<Score> getScore();

    Score postScore(Score score);
    Score putScore(Score score);

    Optional<Score> getScoreById(Integer idScore);

    boolean deleteScore(Integer idScore);
}
