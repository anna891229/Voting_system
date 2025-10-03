package com.example.demo.common;
import java.util.List;
public class VoteRequest {
     private String voterName;
     private List<Integer> options;

    // Getter & Setter
    public String getVoterName() { return voterName; }
    public void setVoterName(String voterName) { this.voterName = voterName; }

    public List<Integer> getOptions() { return options; }
    public void setOptions(List<Integer> options) { this.options = options; }
}
