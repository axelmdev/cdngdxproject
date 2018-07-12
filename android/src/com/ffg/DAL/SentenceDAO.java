package com.ffg.DAL;

import com.ffg.Models.Sentence;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class SentenceDAO implements BaseDAO<Sentence> {
    @Override
    public void Insert(Sentence itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Sentence> itemsToInsert) {

    }

    @Override
    public Sentence SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Sentence> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Sentence itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Sentence> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Sentence itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Sentence> itemsToDelete) {

    }
}
