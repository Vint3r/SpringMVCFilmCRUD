package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.DAO.DatabaseAccessObjectImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private DatabaseAccessObjectImpl dao;
	
	public void setDatabaseAccessorObjectImpl(DatabaseAccessObjectImpl dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path="search.do", method=RequestMethod.GET)
	public ModelAndView goToSearch() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/search.jsp");
		return mv;
	}
	
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public ModelAndView goToAdd() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/add.jsp");
		return mv;
	}

	@RequestMapping(path="displayfullinfo.do", method=RequestMethod.GET)
	public ModelAndView goToResults() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;
	}

}
