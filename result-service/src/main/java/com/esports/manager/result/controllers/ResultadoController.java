package com.esports.manager.result.controllers;


import com.esports.manager.result.exceptions.ResultadoNotFoundException;
import com.esports.manager.result.models.Resultado;
import com.esports.manager.result.models.dto.ResultadoDTO;
import com.esports.manager.result.services.ResultadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Controlador REST que expone los endpoints de resultados
@RestController
@RequestMapping("/api/resultados")
@RequiredArgsConstructor

public class ResultadoController {
    private final ResultadoService resultadoService;

    //cREA UN NUEVO RESULTADO
    @PostMapping
    public ResponseEntity<Resultado> crearResultado(@Valid @RequestBody ResultadoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(resultadoService.crearResultado(dto));
    }

    //retorna todos los resutlados
    @GetMapping
    public ResponseEntity<List<Resultado>> listarResultados(){
        return ResponseEntity.ok(resultadoService.listarResultados());
    }

    //retorna todos los resultados de una partida
    @GetMapping("/partida/{partidaId}")
    public ResponseEntity<List<Resultado>> listarPorPartida(@PathVariable("partidaId") Long partidaId){
        return ResponseEntity.ok(resultadoService.listarPorPartida(partidaId));
    }


    // Actualiza un resultado existente
    @PutMapping("/{id}")
    public ResponseEntity<Resultado> actualizarResultado(@PathVariable Long id, @Valid @RequestBody ResultadoDTO dto) {
        return ResponseEntity.ok(resultadoService.actualizarResultado(id, dto));
    }

    //anula un resultado marcandolo como 'inactivo'
    @PatchMapping("/{id}/anular")
    public ResponseEntity<Resultado> anularResultado(@PathVariable Long id) {
        return ResponseEntity.ok(resultadoService.anularResultado(id));
    }

    //maneja los errores cuando no se encuentre un resultado
    @ExceptionHandler(ResultadoNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResultadoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
