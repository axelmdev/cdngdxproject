package com.ffg.DAL;

import com.ffg.Models.Case;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class CaseDAO implements BaseDAO<Case> {
    @Override
    public void Insert(Case itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Case> itemsToInsert) {

    }

    @Override
    public Case SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Case> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Case itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Case> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Case itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Case> itemsToDelete) {

    }
}
