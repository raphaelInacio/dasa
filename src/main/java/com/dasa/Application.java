package com.dasa;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dasa.domain.Campanha;
import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.Sexo;
import com.dasa.domain.TipoCampanha;
import com.dasa.repository.CampanhasRepository;
import com.dasa.repository.DadosPopulacionaisRepository;
import com.dasa.utils.DatasetReader;

@SpringBootApplication
public class Application {

	@Autowired
	DadosPopulacionaisRepository dadosPopulacionaisRepository;

	@Autowired
	CampanhasRepository campanhasRepository;

	@PostConstruct
	public void init() {

		final Path path = Paths.get("src/main/resources/datasets", "dados_populacionais.csv");

		try {
			Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			DatasetReader datasetReader = new DatasetReader(reader);

			final List<DadoPopulacional> dadoPopulacionals = datasetReader.readDataset();

			dadosPopulacionaisRepository.deleteAll();

			for (DadoPopulacional d : dadoPopulacionals) {
				dadosPopulacionaisRepository.save(d);
			}

			Campanha participanesHomens = null;
			Campanha participanesMulher = null;
			
			for (int i = 0; i < 360; i++) {
				participanesMulher = new Campanha(TipoCampanha.MAMA, Sexo.F, "2017");
				campanhasRepository.save(participanesMulher);
			}
			
			for (int i = 0; i < 250; i++) {
				participanesHomens = new Campanha(TipoCampanha.PROSTATA, Sexo.M, "2017");
				campanhasRepository.save(participanesHomens);
			}
			
			for (int i = 0; i < 500; i++) {
				participanesMulher = new Campanha(TipoCampanha.MAMA, Sexo.F, "2016");
				campanhasRepository.save(participanesMulher);
			}
			
			for (int i = 0; i < 400; i++) {
				participanesHomens = new Campanha(TipoCampanha.PROSTATA, Sexo.M, "2016");
				campanhasRepository.save(participanesHomens);
			}
			
			
		} catch (IOException e) {
			throw new UncheckedIOException("Erro ao popular a Base de Dados", e);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}