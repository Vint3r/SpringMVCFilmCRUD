package com.skilldistillery.film.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class DatabaseAccessObjectImpl implements DatabaseAccessObjectInterface {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
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

			String sqlComm = "SELECT film.*, language.name, category.name FROM film "
					+ "JOIN language ON language.id = film.language_id "
					+ "join film_category on film.id = film_category.film_id "
					+ "join category on category.id = film_category.category_id " + "WHERE film.id = ?";

			PreparedStatement ps = conn.prepareStatement(sqlComm);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				filmWanted = new Film();
				filmWanted.setId(rs.getInt("id"));
				filmWanted.setTitle(rs.getString("title"));
				filmWanted.setDescription(rs.getString("description"));
				filmWanted.setReleaseYear(rs.getInt("release_year"));
				filmWanted.setLanguage(rs.getString("language.name"));
				filmWanted.setRentDuration(rs.getInt("rental_duration"));
				filmWanted.setRentRate(rs.getDouble("rental_rate"));
				filmWanted.setLength(rs.getInt("length"));
				filmWanted.setReplaceCost(rs.getDouble("replacement_cost"));
				filmWanted.setCategory(rs.getString("category.name"));
				filmWanted.setRating(rs.getString("rating"));
				filmWanted.setSpecialFeat(rs.getString("special_features"));
				filmWanted.setActors(findActorsByFilmId(filmId));
			}
			conn.close();
			ps.close();
			rs.close();
			return filmWanted;
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

//	select film.*, language.name, category.name from film join language on language.id = film.language_id join film_category on film.id = film_category.film_id join category on category.id = film_category.category_id where film.id = 1;
	@Override
	public List<Film> findFilmByWord(String key) {
		Connection conn = null;
		List<Film> filmsWanted = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqlComm = "select film.*, language.name, category.name from film "
					+ "join language on film.language_id = language.id "
					+ "join film_category on film.id = film_category.film_id "
					+ "join category on category.id = film_category.category_id "
					+ "where title like ? or description like ?";

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
				filmWanted.setLanguage(rs.getString("language.name"));
				filmWanted.setRentDuration(rs.getInt("rental_duration"));
				filmWanted.setRentRate(rs.getDouble("rental_rate"));
				filmWanted.setLength(rs.getInt("length"));
				filmWanted.setReplaceCost(rs.getDouble("replacement_cost"));
				filmWanted.setRating(rs.getString("rating"));
				filmWanted.setSpecialFeat(rs.getString("special_features"));
				filmWanted.setCategory("category.name");
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
		int languageId = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);

			String sqlLang = "SELECT language.id FROM language " + "where language.name like ?";
			PreparedStatement psLang = conn.prepareStatement(sqlLang);
			psLang.setString(1, "%" + film.getLanguage() + "%");
			ResultSet rs = psLang.executeQuery();
			if (rs.next()) {
				languageId = rs.getInt("id");
			}

			String sqlCat = "SELECT category.id from category join film_category on film_category.category_id = category.id where category.name like ?";
			psLang = conn.prepareStatement(sqlCat);
			int categoryId = 0;
			psLang.setString(1, "%" + film.getCategory() + "%");
			rs = psLang.executeQuery();
			if (rs.next()) {
				categoryId = rs.getInt("id");
			}

			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, "
					+ "replacement_cost, rating, special_features) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getReleaseYear());
			ps.setInt(4, languageId);
			ps.setInt(5, film.getRentDuration());
			ps.setDouble(6, film.getRentRate());
			ps.setInt(7, film.getLength());
			ps.setDouble(8, film.getReplaceCost());
			ps.setString(9, film.getRating());
			ps.setString(10, film.getSpecialFeat());
			film.setActors(generateActors());

			int rowsChanged = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				film.setId(rs.getInt(1));
				System.out.println(rowsChanged + " movies added to the data base.");
				System.out.println("Film id is " + film.getId());
			}

			String insertCat = "insert into film_category (category_id, film_id) values (?, ?)";
			ps = conn.prepareStatement(insertCat);
			ps.setInt(1, categoryId);
			ps.setInt(2, film.getId());
			rowsChanged = ps.executeUpdate();
			if (rs.next()) {
				System.out.println(rowsChanged + " to the film_category table");
			}

			conn.commit();
			psLang.close();
			ps.close();
			rs.close();
			conn.close();
			return film;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e1) {
					System.err.println("Problem with rollback");
					e1.printStackTrace();
				}
			}
			return null;
		}
	}

	public List<Actor> generateActors() {
		int actorCount = (int) (Math.random() * 10) + 1;
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sql = "SELECT * from actor";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);

			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			String sql2 = "DELETE FROM film WHERE id = ?";
			String sql3 = "DELETE FROM film_category WHERE film_id = ?";
			int filmId = film.getId();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			int rowsChanged = ps.executeUpdate();
			System.out.println(rowsChanged + " rows deleted from the Film_Actor data base.");
			
			ps = conn.prepareStatement(sql3);
			ps.setInt(1, filmId);
			rowsChanged = ps.executeUpdate();
			System.out.println(rowsChanged + " rows deleted from the Film_category table.");

			ps = conn.prepareStatement(sql2);
			ps.setInt(1, filmId);
			rowsChanged = ps.executeUpdate();
			System.out.println(rowsChanged + " film deleted from the Film data base.");

			conn.commit();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.err.println("Problem with rollback on Data base.");
				}
			}
			return false;
		}
	}

	@Override
	public Film updateFilm(Film film) {
		Connection conn = null;

		try {
			int languageId = 0;
			int catId = 0;
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);

			String sqlLang = "SELECT language.id FROM language "
					+ "join film on film.language_id = language.id where language.name like ?";
			PreparedStatement psLang = conn.prepareStatement(sqlLang);
			psLang.setString(1, "%" + film.getLanguage() + "%");
			ResultSet rs = psLang.executeQuery();
			if (rs.next()) {
				languageId = rs.getInt("id");
			}

			String sqlCate = "SELECT category.id from category where category.name like ?";
			psLang = conn.prepareStatement(sqlCate);
			psLang.setString(1, "%" + film.getCategory() + "%");
			rs = psLang.executeQuery();
			if (rs.next()) {
				catId = rs.getInt("id");
			}

			String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?, rental_rate = ?"
					+ ", length = ?, replacement_cost = ?, rating = ?, special_features = ? where id = ?";
			String sql2 = "UPDATE film_category SET category_id = ? where film_id = ?";

			psLang = conn.prepareStatement(sql2);
			psLang.setInt(1, catId);
			psLang.setInt(2, film.getId());

			int rowsChanged = psLang.executeUpdate();
			System.out.println(rowsChanged + " rows changed in the film_category table");
			
			System.out.println(film);
			psLang = conn.prepareStatement(sql);
			psLang.setString(1, film.getTitle());
			psLang.setString(2, film.getDescription());
			psLang.setInt(3, film.getReleaseYear());
			psLang.setInt(4, languageId);
			psLang.setInt(5, film.getRentDuration());
			psLang.setDouble(6, film.getRentRate());
			psLang.setInt(7, film.getLength());
			psLang.setDouble(8, film.getReplaceCost());
			psLang.setString(9, film.getRating());
			psLang.setString(10, film.getSpecialFeat());
			psLang.setInt(11, film.getId());
			System.out.println(psLang);

			rowsChanged = psLang.executeUpdate();
			System.out.println(rowsChanged + " rows changed in the film table");

			conn.commit();
			psLang.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				System.err.println("Error encountered, starting rollback");
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.err.println("Problem encountered with rollback.");
				}
			}
		}
		return null;
	}
}
