package com.skilldistillery.film.DAO;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;


public interface DatabaseAccessObjectInterface {
	public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmByWord(String key);
	  public List<Film> findFilmByActorId(int actorId);
	  public Film createFilm(Film film);
	  public boolean deleteFilm(Film film);
	  public Film updateFilm(Film film);
	  public List<Actor> generateActors(Film film);
	  
}
