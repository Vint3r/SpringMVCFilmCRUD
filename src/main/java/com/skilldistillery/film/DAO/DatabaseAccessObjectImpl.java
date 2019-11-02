package com.skilldistillery.film.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class DatabaseAccessObjectImpl implements DatabaseAccessObjectInterface {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Connection conn = null;
		Film filmWanted = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);

			String sqlComm = "SELECT film.*, language.name FROM film "
					+ "JOIN language ON language.id = film.language_id WHERE film.id = ?";

			PreparedStatement ps = conn.prepareStatement(sqlComm);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				filmWanted = new Film();
				filmWanted.setId(rs.getInt("id"));
				filmWanted.setTitle(rs.getString("title"));
				filmWanted.setDescription(rs.getString("description"));
				filmWanted.setReleaseYear(rs.getInt("release_year"));
				filmWanted.setLanguage(rs.getString("name"));
				filmWanted.setRentDuration(rs.getInt("rental_duration"));
				filmWanted.setRentRate(rs.getDouble("rental_rate"));
				filmWanted.setLength(rs.getInt("length"));
				filmWanted.setReplaceCost(rs.getDouble("replacement_cost"));
				filmWanted.setRating(rs.getString("rating"));
				filmWanted.setSpecialFeat(rs.getString("special_features"));
				filmWanted.setActors(findActorsByFilmId(filmId));
				return filmWanted;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return filmWanted;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		Connection conn = null;

		List<Actor> actors = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(URL, user, password);

		String sqlComm = "SELECT actor.id, actor.first_name, actor.last_name FROM actor "
				+ "JOIN film_actor ON actor.id = film_actor.actor_id "
				+ "JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";

		PreparedStatement ps = conn.prepareStatement(sqlComm);
		ps.setInt(1, filmId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Actor actor = new Actor();
			actor.setActorID(rs.getInt("id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
			actors.add(actor);
			actor = null;
		}
		rs.close();
		ps.close();
		conn.close();
		return actors;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return actors;
		}
	}
	@Override
	public List<Film> findFilmByWord(String key) {
		Connection conn = null;
		List<Film> filmsWanted = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, user, password);
		String sqlComm = "select film.*, language.name from film "
				+ "join language on film.language_id = language.id where title like ? or description like ?";

		PreparedStatement ps = conn.prepareStatement(sqlComm);
		ps.setString(1, "%" + key + "%");
		ps.setString(2, "%" + key + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Film filmWanted = new Film();
			filmWanted.setId(rs.getInt("id"));
			filmWanted.setTitle(rs.getString("title"));
			filmWanted.setDescription(rs.getString("description"));
			filmWanted.setReleaseYear(rs.getInt("release_year"));
			filmWanted.setLanguage(rs.getString("name"));
			filmWanted.setRentDuration(rs.getInt("rental_duration"));
			filmWanted.setRentRate(rs.getDouble("rental_rate"));
			filmWanted.setLength(rs.getInt("length"));
			filmWanted.setReplaceCost(rs.getDouble("replacement_cost"));
			filmWanted.setRating(rs.getString("rating"));
			filmWanted.setSpecialFeat(rs.getString("special_features"));
			filmWanted.setActors(findActorsByFilmId(filmWanted.getId()));
			filmsWanted.add(filmWanted);
			filmWanted = null;
		}
		rs.close();
		ps.close();
		conn.close();
		return filmsWanted;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return filmsWanted;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Film> findFilmByActorId(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film createFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film updateFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

}
