package pedroleonez.calculos.service;

import org.springframework.stereotype.Service;
import pedroleonez.calculos.entity.Entrada;
import pedroleonez.calculos.entity.Resultado;

@Service
public class CalculosService {

    public Resultado calcular(Entrada entrada) {
        Resultado resultado = new Resultado();
        Integer soma = 0;

        if (entrada.getLista() != null) {
            for (int i = 0; i < entrada.getLista().size(); i++) {
                soma += entrada.getLista().get(i);
            }
        }

        resultado.setSoma(soma);

        if (entrada.getLista().size() > 0) {
            resultado.setMedia(soma.doubleValue() / entrada.getLista().size());
        } else {
            resultado.setMedia(0.0);
        }

        resultado.setMax(entrada.getLista().stream().max(Integer::compare).orElse(0));
        resultado.setMin(entrada.getLista().stream().min(Integer::compare).orElse(0));
        resultado.setQuantidade(entrada.getLista().size());

        return resultado;
    }
}
