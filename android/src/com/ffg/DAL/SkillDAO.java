package com.ffg.DAL;

import com.ffg.Models.Skill;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class SkillDAO implements BaseDAO<Skill> {
    @Override
    public void Insert(Skill itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Skill> itemsToInsert) {

    }

    @Override
    public Skill SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Skill> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Skill itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Skill> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Skill itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Skill> itemsToDelete) {

    }
}
