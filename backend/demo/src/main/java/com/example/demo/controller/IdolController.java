package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.IdolRequest;
import com.example.demo.common.VoteRequest;
import com.example.demo.common.delRequest;
import com.example.demo.entity.Idol;
import com.example.demo.service.IdolService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/idol")
public class IdolController {
   private final IdolService idolService;

   public IdolController(IdolService idolService) {
      this.idolService = idolService;
   }
   // 查詢
   @GetMapping("/all")
   public List<Idol> getUser() {
      return idolService.findIdol();
   }

   // 新增 
   @PostMapping("/addidol")
   public String createUser(@RequestBody IdolRequest idolrequest) {
      idolService.addIdol(idolrequest.getIdolName());
      return "User inserted successfully!";
   }
   // 投票 
   @PostMapping("/vote")
   public String voteForIdol(@RequestBody VoteRequest voteRequest) {
       idolService.voteForIdol(voteRequest.getVoterName(), voteRequest.getOptions());
       return "Vote recorded successfully!";
   }
   // 刪除
   @PostMapping("/delete")
   public String deleteIdol(@RequestBody delRequest delrequest) {
       idolService.removeIdol(delrequest.getOptions());
       return "Idol deleted successfully!";
   }
     
}
