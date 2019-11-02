package com.skilldistillery.film.controllers;

import java.util.List;

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
	
	 {
		dao = new DatabaseAccessObjectImpl();
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

	@RequestMapping(path="searchid.do", params="id", method=RequestMethod.GET)
	public ModelAndView goToSearchById(Film film) {
		ModelAndView mv = new ModelAndView();
		int filmId = film.getId();
		film = dao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;
	}
	
	@RequestMapping(path="searchkw.do", params="keyword", method=RequestMethod.GET)
	public ModelAndView goToSearchByKW(Film film) {
		ModelAndView mv = new ModelAndView();
		String key = film.getKeyword();
		List<Film> films = dao.findFilmByWord(key);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/displayfullinfolists.jsp");
		return mv;
	}
	
	@RequestMapping(path="addFilm.do",
			params= {"title", "description", "releaseYear", "language", "rentDuration", "rentRate", "length", "replaceCost", "rating", "specialFeat"},
			method=RequestMethod.GET)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.createFilm(film);
//		if (film.getId() == 0) {
//			mv.setViewName("WEB-INF/add.jsp");
//			return mv;
//		}
		mv.addObject(film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;
		
	}

}
