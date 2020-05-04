package com.example.projectpwsz.dao;

import com.example.projectpwsz.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class FilmDaoImpl implements FilmDao  {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long count() {
        return jdbcTemplate
                .queryForObject("select count(*) from filmy", Long.class);
    }

    @Override
    public Film findByID(long id)  {
        try {
            RowMapper<Film> filmRowMapper = (rs, rowNum) ->
                    new Film(
                            rs.getLong("id"),
                            rs.getString("tytul"),
                            rs.getString("rok"),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
            return jdbcTemplate
                    .queryForObject("SELECT * FROM Filmy where id=?",
                            filmRowMapper
                            , id);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Film> findAll() {
        RowMapper<Film> filmRowMapper = (rs, rowNum) ->
                new Film(
                        rs.getLong("id"),
                        rs.getString("tytul"),
                        rs.getString("rok"),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                );
        return jdbcTemplate
                .query("SELECT * FROM Filmy",
                        filmRowMapper
                        );
        
    }

    @Override
    public int save(Film film) {
        return jdbcTemplate
                .update("INSERT INTO Filmy (tytul,rok,czas_trwania, gatunek, nazwa_studia) values(?,?,?,?,?) ",
                film.getTytul(),film.getRok(),film.getCzasTrwania(),film.getGatunek(),film.getNazwaStudia());
    }

    @Override
    public int update(Film film) {
        return jdbcTemplate
                .update("UPDATE Filmy SET tytul=?,rok=?,czas_trwania=?, gatunek=?, nazwa_studia=? where id=? ",
                        film.getTytul(),film.getRok(),film.getCzasTrwania(),
                        film.getGatunek(),film.getNazwaStudia(),film.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate
                .update(
                        "DELETE FROM Filmy WHERE id=?",
                        id
                );
    }
}
