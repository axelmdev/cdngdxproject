package com.ffg.DAL;

import com.ffg.Models.Game;

import java.util.ArrayList;

/**
 * Created by edern on 10/07/2018.
 */

public class GameDAO implements BaseDAO<Game>
{
    @Override
    public void Insert(Game itemToInsert) {
        System.out.println("Insertion : Game");
    }

    @Override
    public void InsertMany(ArrayList<Game> itemsToInsert) {

    }

    @Override
    public Game SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Game> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Game itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Game> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Game itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Game> itemsToDelete) {

    }
}
