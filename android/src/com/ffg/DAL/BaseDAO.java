package com.ffg.DAL;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public interface BaseDAO<T> {
    public void Insert(T itemToInsert);
    public void InsertMany(ArrayList<T> itemsToInsert);
    public T SelectOne(ArrayList<String> parameters);
    public ArrayList<T> SelectMany(ArrayList<String> parameters);
    public void Update(T itemToUpdate);
    public void UpdateMany(ArrayList<T> itemToUpdate);
    public void DeleteOne(T itemToDelete);
    public void DeleteMany(ArrayList<T> itemsToDelete);
}
