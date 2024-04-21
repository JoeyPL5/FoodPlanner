package com.foodplanner.project;

@RestController
public class PlannerController {
    
    private final PlannerService service;

    public PlannerController(PlannerService plannerService) {
        this.service = plannerService;
    }

    @GetMapping("/login")
    public void login(@RequestParam user, @RequestParam pass) {
        
    }
}
