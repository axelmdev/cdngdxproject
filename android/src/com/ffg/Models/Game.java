package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.Date;

/**
 * Created by edern on 07/07/2018.
 */

public class Game {
    private List<Map> mapList;
    private List<Character> characterList;
    private List<ActiveCharacter> activeCharacterList;
    private Date lastSave;

    public static String GetNameUrlVersion(){
        return "Games";
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public List<ActiveCharacter> getActiveCharacterList() {
        return activeCharacterList;
    }

    public void setActiveCharacterList(List<ActiveCharacter> activeCharacterList) {
        this.activeCharacterList = activeCharacterList;
    }

    public Date getLastSave() {
        return lastSave;
    }

    public void setLastSave(Date lastSave) {
        this.lastSave = lastSave;
    }
}
