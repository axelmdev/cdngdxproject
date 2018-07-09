package com.ffg.DAL;

import com.ffg.Models.Oiseau;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public class OiseauDao implements BaseDAO<Oiseau> {

    @Override
    public void Insert(Oiseau itemToInsert) {
        System.out.println("Insertion : " + itemToInsert.getName());
    }

    @Override
    public void InsertMany(ArrayList<Oiseau> itemsToInsert) {
        for (Oiseau oiseau : itemsToInsert) {
            System.out.println("Insertion : " + oiseau.getName());
        }
    }

    @Override
    public Oiseau SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Oiseau> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Oiseau itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Oiseau> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Oiseau itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Oiseau> itemsToDelete) {

    }
}
