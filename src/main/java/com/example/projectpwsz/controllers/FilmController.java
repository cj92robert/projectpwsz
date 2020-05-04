package com.example.projectpwsz.controllers;

import com.example.projectpwsz.dao.FilmDao;
import com.example.projectpwsz.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*" ,allowedHeaders = "*")
@RestController
public class FilmController {

    private final FilmDao filmDao;

    @Autowired
    public FilmController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }


    @GetMapping
    ResponseEntity<List<Film>> getAllFilms(){
        List<Film> list= filmDao.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Film> getFimlbyId(@PathVariable long id) throws SQLException {
        Film film = filmDao.findByID(id);
        if(film != null)
            return new ResponseEntity<>(film,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    ResponseEntity add(@RequestBody Film film){
        if(filmDao.save(film)> 0)
            return new ResponseEntity(HttpStatus.CREATED);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("{id}")
    ResponseEntity update(@PathVariable long id, @RequestBody Film film){
        if(filmDao.update(film) > 0)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable long id){
        if(filmDao.deleteById(id)==0)
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/test")
    void getTest(){
        filmDao.save(
                new Film(1,"testowytytul","1999",1234,"gatunek","jakiestam"));
    }

}
