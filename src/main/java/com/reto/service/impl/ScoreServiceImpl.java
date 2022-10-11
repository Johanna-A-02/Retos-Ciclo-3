package com.reto.service.impl;

import com.reto.model.Client;
import com.reto.model.Message;
import com.reto.model.Score;
import com.reto.repository.ReservationRepository;
import com.reto.repository.ScoreRepository;
import com.reto.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Score> getScore(){
        List<Score> response = new ArrayList<>();
        scoreRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public Score postScore(Score score) {

        if(score.getIdScore() == null){
            final Score scoreResponse = scoreRepository.save(score);
            reservationRepository.findById(score.getReservation().getIdReservation()).map(reservation -> {
                reservation.setScore(scoreResponse);
                reservationRepository.save(reservation);
                return true;
            });
        }else{
            Optional<Score> scoreOptional = scoreRepository.findById(score.getIdScore());
            if(scoreOptional.isEmpty()){
                final Score scoreResponse = scoreRepository.save(score);
                reservationRepository.findById(score.getReservation().getIdReservation()).map(reservation -> {
                    reservation.setScore(scoreResponse);
                    reservationRepository.save(reservation);
                    return true;
                });
            }else{
                score = scoreOptional.get();
            }
        }

        return score;
    }
    @Override
    public Score putScore(Score score){
        if(score.getIdScore() != null){
            Optional<Score> scoreOptional = scoreRepository.findById(score.getIdScore());
            if(scoreOptional.isPresent()){
                Score scoreUpdate = scoreOptional.get();
                scoreUpdate.setMessageText(score.getMessageText() != null ? score.getMessageText(): scoreUpdate.getMessageText());
                scoreUpdate.setStars(score.getStars() != null ? score.getStars(): scoreUpdate.getStars());
                scoreUpdate.setReservation(score.getReservation() != null ? score.getReservation(): scoreUpdate.getReservation());


                //clientUpdate.setMessages(client.getMessages() != null ? client.getMessages(): clientUpdate.getMessages());


                //score = scoreRepository.save(scoreUpdate);
                final Score scoreResponse = scoreRepository.save(score);
                reservationRepository.findById(score.getReservation().getIdReservation()).map(reservation -> {
                    reservation.setScore(scoreResponse);
                    reservationRepository.save(reservation);
                    return true;
                });
                return scoreResponse;
            }

        }
        return score;
    }

    @Override
    public Optional<Score> getScoreById(Integer idScore){
        return scoreRepository.findById(idScore);
    }

    @Override
    public boolean deleteScore(Integer idScore){
        Boolean flag = scoreRepository.findById(idScore).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);

        return flag;
    }
}
