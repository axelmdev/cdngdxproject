package com.ffg.DAL;

import com.ffg.Models.Account;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public class AccountDAO implements BaseDAO<Account> {
    @Override
    public void Insert(Account itemToInsert) {
        System.out.println("Insertion : " + itemToInsert.getPseudo());
    }

    @Override
    public void InsertMany(ArrayList<Account> itemsToInsert) {

        for (Account account : itemsToInsert) {
            System.out.println("Insertion : " + account.getPseudo());
        }
    }

    @Override
    public Account SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Account> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Account itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Account> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Account itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Account> itemsToDelete) {

    }
}
