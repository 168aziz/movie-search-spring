package uz.moviesearch.service;

import uz.moviesearch.models.AbstractMovie;

public interface InfoService<T> {

    <T> T getDetails();

    <T> AbstractMovie getCredits();

}


