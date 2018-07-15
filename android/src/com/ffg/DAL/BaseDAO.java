package com.ffg.DAL;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public interface BaseDAO<T> {
    public void Insert(T itemToInsert,DBHelper dbContext);
    public void InsertMany(ArrayList<T> itemsToInsert,DBHelper dbContext);
    public T SelectOne(String id,DBHelper dbContext);
    public ArrayList<T> SelectMany(DBHelper dbContext);
    public void Update(T itemToUpdate,DBHelper dbContext);
    public void UpdateMany(ArrayList<T> itemToUpdate,DBHelper dbContext);
    public void DeleteOne(T itemToDelete,DBHelper dbContext);
    public void DeleteMany(ArrayList<T> itemsToDelete,DBHelper dbContext);
}
