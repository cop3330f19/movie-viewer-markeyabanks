/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movies.models;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.util.ArrayList;

/**
 *
 * @author markeyabanks
 */
public class Movies {
    //TMDB API connection
    private static final TmdbApi CONNECTION = new TmdbApi("00e6697579cdbc8d3ec432732596b288");
    //language
    private static final String LANGUAGE = "en-us";
    
    //return the list of currently playing
    public ArrayList<MovieDb> getMovies(){
        TmdbMovies movies = new TmdbMovies(CONNECTION);
        MovieResultsPage result = movies.getNowPlayingMovies(LANGUAGE, 1,"");
        return (ArrayList<MovieDb>) result.getResults();
    }
    //get trailers
    public ArrayList<Video> getVideo(int movieId){
     TmdbMovies movies = new TmdbMovies(CONNECTION);
     return (ArrayList<Video>) movies.getVideos(movieId, LANGUAGE);
    }
}
