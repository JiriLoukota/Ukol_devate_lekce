package com.example.homework2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContributionService {
    private final List<Contribution> contributions = new ArrayList<>();

    public void addContribution(Contribution contribution) throws Exception{
        if(!idExists(contribution.getContributionId())) contributions.add(contribution);
        else throw new Exception("Contribution with this id already exists.");
    }

    public List<Contribution> getVisibleContributions(){
        List<Contribution> visibleContributions = new ArrayList<>();
        for(Contribution contribution: contributions){
            if(contribution.isVisible()) visibleContributions.add(contribution);
        }
        return visibleContributions;
    }
    public List<Contribution> getAllContributions(){
        return contributions;
    }

    private boolean idExists(int id){
        for (Contribution contribution : contributions){
            if(contribution.getContributionId()==id) return true;
        }
        return false;
    }
}
