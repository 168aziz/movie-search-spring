package uz.moviesearch.service;

import uz.moviesearch.models.Scene;

public interface InfoService<T> {

    <T> T getDetails();

    <T> Scene getCredits();

}


