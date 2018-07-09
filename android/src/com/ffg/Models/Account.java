package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Account {
    private String pseudo;
    private String mail;
    private String pwd;
    private Game game;

    public static String GetNameUrlVersion(){
        return "Accounts";
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
