package pedroleonez.calculos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedroleonez.calculos.entity.Entrada;
import pedroleonez.calculos.entity.Resultado;
import pedroleonez.calculos.service.CalculosService;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    private final CalculosService calculosService;

    public CalculosController(CalculosService calculosService) {
        this.calculosService = calculosService;
    }

    @GetMapping("/calcular")
    public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) {
        try {
            Resultado resultado = this.calculosService.calcular(entrada);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
