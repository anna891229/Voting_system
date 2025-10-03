package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Idol;
import com.example.demo.repository.IdolRepository;

@Service
public class IdolService {
     private final IdolRepository idolRepository;

     public IdolService(IdolRepository idolRepository) {
        this.idolRepository = idolRepository;
     }

     public List<Idol> findIdol() {
          return idolRepository.getIdol();
     }

     public void addIdol(String name) {
        idolRepository.insertIdol(name);
     }

     public void voteForIdol(String voterName, List<Integer> options) {
          for (Integer option : options) {
               idolRepository.addVote(voterName, option);
          }
     }
     public void removeIdol(List<Integer> options) {
          for (Integer id : options)
               idolRepository.deleteIdol(id);
          }
}
