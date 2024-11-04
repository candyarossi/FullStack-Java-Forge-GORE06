package com.demo.rawg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.demo.models.Videojuego;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InfoApi {
	private final static String url = "https://api.rawg.io/api/games";
	// TODO conseguir API KEY en https://rawg.io
	private final static String key = "";

	public static ArrayList<Videojuego> get10Videogames(int page) throws Exception {
		String resultado = convertInfoAPIToString(InfoApi.url + "?key=" + InfoApi.key + "&page_size=10&page=" + page);
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Videojuego> videojuegos = new ArrayList<>();
		try {
			JsonNode rootNode = objectMapper.readTree(resultado.toString());
			JsonNode results = rootNode.path("results");
			for (JsonNode result : results) {
				Videojuego v = convertJSONToVideogame(result);
				videojuegos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videojuegos;
	}

	public static Videojuego getVideogame(int id) throws Exception {
		String resultado = convertInfoAPIToString(InfoApi.url + "/" + id + "?key=" + InfoApi.key);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(resultado.toString());
		Videojuego v = convertJSONToVideogame(rootNode);
		return v;
	}

	private static String convertInfoAPIToString(String query) {
		StringBuilder resultado = new StringBuilder();
		try {
			URL url = new URL(query);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
			String linea;
			while ((linea = rd.readLine()) != null) {
				resultado.append(linea);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado.toString();
	}

	private static Videojuego convertJSONToVideogame(JsonNode json) {
		int id = json.path("id").asInt();
		String nombre = json.path("name").asText();
		String descripcion = json.path("description_raw").asText();
		String portada = json.path("background_image").asText();
		String fecha_lanzamiento = json.path("released").asText();
		double rating = json.path("rating").asDouble();
		ArrayList<String> generos = new ArrayList<>();
		ArrayList<String> plataformas = new ArrayList<>();
		JsonNode platforms = json.path("parent_platforms");
		for (JsonNode platform : platforms) {
			JsonNode single = platform.path("platform");
			plataformas.add(single.path("name").asText());
		}
		JsonNode genres = json.path("genres");
		for (JsonNode genre : genres) {
			generos.add(genre.path("name").asText());
		}
		Videojuego v = new Videojuego(id, nombre, descripcion, portada, fecha_lanzamiento, rating, generos,
				plataformas);
		return v;
	}

}
