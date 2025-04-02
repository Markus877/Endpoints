package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.model.Proyect;

@Service
public class ProjectService {
    
    private HashMap<Long, Proyect> proyectos = new HashMap<>();
    
    public List<Proyect> cogerProyectos() {
        return new ArrayList<>(proyectos.values());
    }
    
    public Proyect createProject(Proyect project) {
        proyectos.put(project.getId(), project);
        return project;
    }
    
    public Optional<Proyect> getProjectById(Long id) {
        return Optional.ofNullable(proyectos.get(id));
    }
    
    public void deleteProject(Long id) {
        proyectos.remove(id);
    }
}
