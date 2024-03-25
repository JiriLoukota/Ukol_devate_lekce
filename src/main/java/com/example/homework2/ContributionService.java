package com.example.homework2;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContributionService {
    private final List<Contribution> contributions = new ArrayList<>();

    public void addContribution(Contribution contribution) throws Exception{
        if(!idExists(contribution.getContributionId())){
            contributions.add(contribution);
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""))){
                bufferedWriter.append(contribution.toSavingFormat());
            }catch (Exception ignored){}

        }
        else throw new Exception("Contribution with this id already exists.");
    }

    public List<Contribution> getVisibleContributions(){
        loadFile();
        List<Contribution> visibleContributions = new ArrayList<>();
        for(Contribution contribution: contributions){
            if(contribution.isVisible()) visibleContributions.add(contribution);
        }
        return visibleContributions;
    }
    public List<Contribution> getAllContributions(){
        loadFile();
        return contributions;
    }

    private void loadFile(){
        contributions.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(""))) {
            String line;
            while(( line= bufferedReader.readLine()) != null){
                String[] parts = line.split("\t");
                boolean visible = parts[3].equals("true");
                contributions.add(new Contribution(parts[0], parts[1], Integer.parseInt(parts[2]), visible));
            }
        }catch (Exception ignored){}
    }

    private boolean idExists(int id){
        for (Contribution contribution : contributions){
            if(contribution.getContributionId()==id) return true;
        }
        return false;
    }
}
