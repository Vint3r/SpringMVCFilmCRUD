package com.skilldistillery.film.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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

	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public ModelAndView goToSearch() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/search.jsp");
		return mv;
	}

	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public ModelAndView goToAdd() {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/add.jsp");
		return mv;
	}

	@RequestMapping(path = "searchid.do", params = "id", method = RequestMethod.GET)
	public ModelAndView goToSearchById(@Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		int filmId = film.getId();
		if (errors.getErrorCount() > 0) {
			mv.setViewName("WEB-INF/search.jsp");
			return mv;
		}
		
		film = dao.findFilmById(filmId);
		if (film == null) {
			errors.rejectValue("id", "error.id", "Unable to locate film " + filmId + " in data base");
			mv.setViewName("WEB-INF/search.jsp");
			return mv;
		}
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;
	}

	@RequestMapping(path = "searchkw.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView goToSearchByKW(@Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		String key = film.getKeyword();
		if (errors.getErrorCount() > 0) {
			mv.setViewName("WEB-INF/search.jsp");
			return mv;
		}
		
		List<Film> films = dao.findFilmByWord(key);
		if (films.size() <= 0) {
			errors.rejectValue("keyword", "error.keyword", "Unable to find movies related to keyword: " + key);
			mv.setViewName("WEB-INF/search.jsp");
			return mv;
		}
		
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/displayfullinfolists.jsp");
		return mv;
	}

	@RequestMapping(path = "addFilm.do", params = { "title", "description", "releaseYear", "language", "rentDuration",
			"rentRate", "length", "replaceCost", "rating", "specialFeat", "category" }, method = RequestMethod.GET)
	public ModelAndView addFilm(@Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		System.out.println(film);
		if (errors.getErrorCount() > 0) {
			mv.setViewName("WEB-INF/add.jsp");
			return mv;
		}
		
		film = dao.createFilm(film);
		if (film == null) {
			errors.rejectValue("title", "error.title", "Unable to create movie with the given information, please try again.");
			mv.setViewName("WEB-INF/add.jsp");
			return mv;
		}
		
		mv.addObject(film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;

	}

	@RequestMapping(path = "delete.do", params = "id", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() > 0) {
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/displayfullinfo.jsp");
			return mv;
		}
		if (!dao.deleteFilm(film) || errors.getErrorCount() > 0) {
			errors.rejectValue("film", "error.film", "Unable to delete film from data base");
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/displayfullinfo.jsp");
			return mv;
		} 
		mv.setViewName("index.html");
		return mv;
	}
	
	@RequestMapping(path = "update.do", params = {"id", "title", "description", "releaseYear", "language", "rentDuration",
			"rentRate", "length", "replaceCost", "rating", "specialFeat", "category"}, method = RequestMethod.GET)
	public ModelAndView goToUpdate(@Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		System.out.println(film);
		if (errors.getErrorCount() > 0) {
			mv.setViewName("WEB-INF/displayfullinfo.jsp");
			return mv;
		}
		
		film = dao.updateFilm(film);
		if (film == null) {
			errors.rejectValue("title", "error.title", "Unable to update film in the data base, please try again");
			mv.setViewName("WEB-INF/displayfullinfo.jsp");
			return mv;
		}
		
		mv.addObject(film);
		mv.setViewName("WEB-INF/displayfullinfo.jsp");
		return mv;
	}
}
