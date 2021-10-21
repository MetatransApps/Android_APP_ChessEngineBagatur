package com.bagaturchess.activities;


import com.bagaturchess.lib.R;
import com.chessartforkids.main.MainActivity;


public class Activity_Main_BagaturChess extends MainActivity {
	
	
	@Override
	public Class<? extends Object> getMainMenuClass() { 
		return Activity_MenuMain_BagaturChess.class;
	}
	
	
	@Override
	protected int getMainLayoutID() {
		return R.id.layout_main_vertical_bagaturchess;
	}
	
	
	@Override
	protected int getMainLayout() {
		return R.layout.main_vertical_bagaturchess;
	}
}
