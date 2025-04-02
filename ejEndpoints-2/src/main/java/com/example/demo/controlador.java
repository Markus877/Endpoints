package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Proyect;
import com.example.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/projects")
public class controlador {
    
    @Autowired
    private ProjectService projectService;
    
    @Operation(summary = "Muestra los proyectos", description = "Devuelve todos los nombres de los proyectos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
        @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
    @GetMapping
    public ResponseEntity<List<Proyect>> getProyectos() {
        return ResponseEntity.ok(projectService.cogerProyectos());
    }
    
    @PostMapping
    public ResponseEntity<Proyect> createProject(@RequestBody Proyect project) {
        Proyect createdProject = projectService.createProject(project);
        return ResponseEntity.ok(createdProject);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Proyect> getProjectById(@PathVariable Long id) {
        Optional<Proyect> project = projectService.getProjectById(id);
        return project.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
