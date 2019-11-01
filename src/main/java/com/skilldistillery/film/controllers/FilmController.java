package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.DAO.DatabaseAccessObjectInterface;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private DatabaseAccessObjectInterface dao;
	
	@RequestMapping(path="search.do", method=RequestMethod.GET)
	public ModelAndView goToSearch() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/search.jsp");
		return mv;
	}
}
