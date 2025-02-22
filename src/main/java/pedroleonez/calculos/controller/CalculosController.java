package pedroleonez.calculos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedroleonez.calculos.entity.Entrada;
import pedroleonez.calculos.entity.Resultado;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    public ResponseEntity<Resultado> somar(Entrada entrada) {
        try {
            Resultado resultado = new Resultado();
            resultado.setSoma(entrada.getLista().stream().mapToInt(Integer::intValue).sum());
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
