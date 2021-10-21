package com.bagaturchess.activities;


import android.content.Intent;
import android.view.Gravity;

import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.web.WebUtils;

import com.chessartforkids.edit.EditBoardView;
import com.chessartforkids.lib.R;
import com.chessartforkids.model.GameData;
import com.chessartforkids.utils.StorageUtils;


public class Activity_EditBoard extends com.chessartforkids.edit.EditBoardActivity {
	
	
	@Override
	protected GameData getGameData() throws Exception {
		
		Object[] objs = StorageUtils.readStorage(this);
		
		if (objs == null) {
			objs = new Object[3];
		}
		
		GameData gamedata = (GameData) objs[0];
		
		return gamedata;
	}
	
	
	@Override
	protected void storeGameData(GameData gameData) {
		StorageUtils.writeStore(this, gameData, null, getUserSettings());
	}
	
	
	@Override
	protected EditBoardView createView() {
		return new EditBoardView(this, null);
	}
	
	
	@Override
	protected int button1ImageID() {
		return R.drawable.ic_action_like_black;
	}
	
	
	@Override
	protected int button2ImageID() {
		return R.drawable.ic_computer_moving;
	}
	
	
	@Override
	protected void processButton1() {
		WebUtils.openApplicationStorePage(this, Application_Base.getInstance().getApp_Me());
	}
	
	
	@Override
	protected void processButton2() {
		Intent intent = new Intent(this, Activity_Main_BagaturChess.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		startActivity(intent);
	}
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER2;
	}
	
	
	@Override
	protected int getGravity() {
		return Gravity.TOP | Gravity.CENTER_HORIZONTAL;
	}
}
