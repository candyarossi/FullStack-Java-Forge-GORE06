package com.demo.controllers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Imagenes {
	private static String ruta = "C:/Users/candy/Documents/workspace-spring-tool-suite-4-4.22.1.RELEASE/demoJuegos/src/main/resources/static";

	public static String uploadImg(MultipartFile img) throws Exception {
		if (img.isEmpty()) {
			throw new Exception("El archivo de imagen no se ha cargado correctamente.");
		}
		try {
			File directorio = new File(ruta + "/images/");
			if (!directorio.exists()) {
				directorio.mkdirs();
			}
			String nombreImg = img.getOriginalFilename();
			Path path = Paths.get(ruta + "/images/" + nombreImg);
			img.transferTo(path.toFile());
			return "images/" + nombreImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean deleteImg(String img) {
		File imgFile = new File(ruta + "/" + img);
		if (imgFile.exists()) {
			imgFile.delete();
			return true;
		}
		return false;
	}

}
