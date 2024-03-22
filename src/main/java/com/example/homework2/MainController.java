package com.example.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    ContributionService contributionService;

    @GetMapping(value = {"v1/contribution", "v1/contribution/{all}"})
    public List<Contribution> getContributions(@PathVariable(value = "all" , required = false) boolean all){
        //IS ALWAYS REQUIRED IDK WHY
        if (all) return contributionService.getAllContributions();
        return contributionService.getVisibleContributions();
    }

    @PostMapping("v1/contribution")
    public ResponseEntity<String> createContribution(@RequestBody Contribution contribution) {
        try {
            contributionService.addContribution(contribution);
            return ResponseEntity.ok("Added contribution");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Failed to add contribution");
        }
    }

}