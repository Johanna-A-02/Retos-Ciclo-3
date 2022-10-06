package com.reto.service;

import com.reto.model.Client;
import com.reto.model.Score;

import java.util.List;

public interface ScoreService {

    List<Score> getScore();

    String postScore(Score score);
}
