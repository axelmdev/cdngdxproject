package com.ffg.DAL;

import com.ffg.Models.Character;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class CharacterDAO implements BaseDAO<Character> {
    @Override
    public void Insert(Character itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Character> itemsToInsert) {

    }

    @Override
    public Character SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Character> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Character itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Character> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Character itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Character> itemsToDelete) {

    }
}
