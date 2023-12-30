package br.com.gotop.ap1_beneficiarios.service;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 23:58:56
 */
@Service
public class MapService {

	public Map<String, String> construirMapa(String[][] dados) {
        Map<String, String> mapa = Stream.of(dados).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        return mapa;
    }

    public Map<String, Integer> construirMapaSI(String[][] dados) {
        Map<String, Integer> mapa = Stream.of(dados).collect(Collectors.toMap(data -> data[0], data -> Integer.parseInt(data[1],10)));
        return mapa;
    }
}
