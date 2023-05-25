package com.example.biithrmsystem.api.datamodel; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class Job{
    @JsonProperty("JobApplications") 
    public ArrayList<JobApplication> jobApplications;
    @JsonProperty("Jid") 
    public int jid;
    @JsonProperty("Title") 
    public String title;
    public String qualification;
    @JsonProperty("Salary") 
    public String salary;
    public String experience;
    @JsonProperty("LastDateOfApply") 
    public String lastDateOfApply;
    @JsonProperty("Location") 
    public String location;
    @JsonProperty("Description") 
    public String description;
    public int noofvacancie;
}
