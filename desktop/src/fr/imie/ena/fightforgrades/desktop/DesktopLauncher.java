package fr.imie.ena.fightforgrades.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.imie.ena.fightforgrades.FightForGrades;
import fr.imie.ena.fightforgrades.UIDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new UIDemo(), config);
	}
}
