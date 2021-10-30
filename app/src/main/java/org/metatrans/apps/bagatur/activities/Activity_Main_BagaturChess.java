package org.metatrans.apps.bagatur.activities;


import org.metatrans.commons.chess.main.MainActivity;


public class Activity_Main_BagaturChess extends MainActivity {


	@Override
	public Class<? extends Object> getMainMenuClass() { 
		return Activity_MenuMain_BagaturChess.class;
	}
}
