package com.lindah.exercise.controller;

import com.lindah.exercise.model.ExerciseModel;
import com.lindah.exercise.repository.ExerciseRepository;
import com.lindah.exercise.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "http://localhost:3000")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<ExerciseModel> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @PostMapping
    public ExerciseModel createExercise(@RequestBody ExerciseModel exercise){
        return exerciseService.createExercise(exercise);
    }

    @GetMapping("/{id}")
    public ExerciseModel getExerciseById(@PathVariable Long id){
        return exerciseService.getExerciseById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteExerciseById(@PathVariable Long id){
        exerciseService.deleteExerciseById(id);
    }

    @PutMapping("/{id}")
    public ExerciseModel updateExercise(@PathVariable Long id, @RequestBody ExerciseModel exerciseDetails){
        exerciseDetails.setId(id);
        return exerciseService.updateExercise(id, exerciseDetails);
    }

}
