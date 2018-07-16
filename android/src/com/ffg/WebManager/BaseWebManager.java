package com.ffg.WebManager;

import java.util.ArrayList;

/**
 * Created by edern on 08/07/2018.
 */

public interface BaseWebManager<T> {

    public T GetOne(String id);
    public ArrayList<T> GetMany();
    public boolean PostOne(T itemToPost);
    public boolean PostMany(ArrayList<T> itemsToPost);
    public boolean PutOne(T itemToPut);
    public boolean PutMany(ArrayList<T> itemsToPut);
    public boolean DeleteOne(T itemToDelete);
    public boolean DeleteMany(ArrayList<T> itemsToDelete);

}
