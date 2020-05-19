package com.uca.capas.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudiantesDao;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {

	@Autowired
	private EstudiantesDao estudianteDao;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante =new Estudiante();
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView mostrarLista() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes =null;
		try {
			estudiantes = estudianteDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante.getNombre());
		}
		return mav;
	}
	
	@RequestMapping("/ingresar")
	public ModelAndView procesar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("index");
		}else {
			estudianteDao.save(estudiante);
			mv.setViewName("index");
		}
		return mv;
	}
}
