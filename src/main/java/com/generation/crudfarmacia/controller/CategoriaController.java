package com.generation.crudfarmacia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import com.generation.crudfarmacia.model.Categoria;
import com.generation.crudfarmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable(name = "id") Long id) {
        return categoriaRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<Categoria>> getByNome(@Valid @PathVariable(name = "nome") String nome) {
        return ResponseEntity.ok(categoriaRepository.findByNomeCategoriaContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria newCategoria) {
        Categoria postCategoria = categoriaRepository.save(newCategoria);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postCategoria);
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria updateCategoria) {
        Categoria putCategoria = categoriaRepository.save(updateCategoria);
        return categoriaRepository.findById(updateCategoria.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(putCategoria))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        Optional<Categoria> newCategoria = categoriaRepository.findById(id);

        if(newCategoria.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        categoriaRepository.deleteById(id);
    }
}
