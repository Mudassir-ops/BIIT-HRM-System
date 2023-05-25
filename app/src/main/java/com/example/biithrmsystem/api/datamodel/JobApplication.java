package com.example.biithrmsystem.api.datamodel; 
import com.fasterxml.jackson.annotation.JsonProperty;



public class JobApplication{
    @JsonProperty("User") 
    public User user;
    @JsonProperty("JobApplicationID") 
    public int jobApplicationID;
    @JsonProperty("Jid") 
    public int jid;
    @JsonProperty("Uid") 
    public int uid;
    public String name;
    public String status;
    public Object shortlist;
    @JsonProperty("DocumentPath") 
    public String documentPath;
    @JsonProperty("Job") 
    public Job job;
}
