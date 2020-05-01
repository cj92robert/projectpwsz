package com.example.projectpwsz.dao;

import com.example.projectpwsz.models.Film;

import java.sql.SQLException;
import java.util.List;

public interface FilmDao {

    Long count();

    Film findByID(long id) throws SQLException;

    List<Film> findAll();

    int save(Film film);

    int update(Film film);

    int deleteById(Long id);

}
