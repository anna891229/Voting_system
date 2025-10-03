package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Idol;

public interface IdolRepository extends JpaRepository<Idol, Integer> {
     // 查詢 
     @Query(value = "CALL SelectIdol()", nativeQuery = true)
     List<Idol> getIdol();

     // 新增idol
     @Procedure(procedureName = "insertIdol")
     void insertIdol(@Param("IdolName") String name);
     // 增加票數
     @Procedure(procedureName = "AddVoteRecord")
     void addVote(@Param("voter") String voter, @Param("votedidolid") Integer votedidolid);
     // 刪除idol
     @Procedure(procedureName = "DeleteIdol")
     void deleteIdol(@Param("idol_id") Integer idol_id);
}
