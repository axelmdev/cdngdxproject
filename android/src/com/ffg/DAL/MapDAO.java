package com.ffg.DAL;

import com.ffg.Models.Map;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class MapDAO implements BaseDAO<Map> {
    @Override
    public void Insert(Map itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Map> itemsToInsert) {

    }

    @Override
    public Map SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Map> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Map itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Map> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Map itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Map> itemsToDelete) {

    }
}
