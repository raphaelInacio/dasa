package com.dasa.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dasa.domain.Campanha;
import com.dasa.domain.Sexo;
import com.dasa.domain.TipoCampanha;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampanhaControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	private byte[] objectToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	@Test
	public void deveBuscarDadosDeCampanhaPorAnoAPI() throws Exception {
		mvc.perform(get("/api/v1/campanhas/anos/2017")).andExpect(status().isOk())
				.andExpect(jsonPath("$.ano").value("2017"))
				.andExpect(jsonPath("$.campanhas[0].campanha").value("MAMA"));
	}

	@Test
	public void deveBuscarDadosDeProporcaoCampanhaPorAnoAPI() throws Exception {
		mvc.perform(get("/api/v1/campanhas/proporcao/anos/2017")).andExpect(status().isOk())
				.andExpect(jsonPath("$.ano").value("2017"))
				.andExpect(jsonPath("$.proporcaoCampanha[0].campanha").value("MAMA"));
	}
	
	@Test
	public void deveGravarDadosCampanhaAPI() throws Exception {

		Campanha cancer = new Campanha(TipoCampanha.PROSTATA, Sexo.M, "2017");

		mvc.perform(
				post("/api/v1/campanhas/").contentType(MediaType.APPLICATION_JSON_UTF8).content(objectToJson(cancer)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.campanha").value(TipoCampanha.PROSTATA.toString()))
				.andExpect(jsonPath("$.ano").value("2017")).andExpect(jsonPath("$.sexo").value(Sexo.M.toString()));
	}

}
