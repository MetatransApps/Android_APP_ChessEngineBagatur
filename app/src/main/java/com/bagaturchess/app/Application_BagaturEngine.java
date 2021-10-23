package com.bagaturchess.app;


import org.metatrans.commons.engagement.ILeaderboardsProvider;
import org.metatrans.commons.model.GameData_Base;

import com.bagaturchess.cfg.difficulty.ConfigurationUtils_Difficulty;
import com.chessartforkids.engines.EngineClient_LocalImpl;
import com.chessartforkids.logic.GameDataUtils;


public abstract class Application_BagaturEngine extends com.chessartforkids.app.Application_CAFK_Impl2 {

	
	@Override
	public void onCreate() {
		
		super.onCreate();
		
		ConfigurationUtils_Difficulty.createInstance();
		
		EngineClient_LocalImpl.MEMORY_USAGE_PERCENT = 0.25;
	}


	@Override
	protected ILeaderboardsProvider createLeaderboardsProvider() {
		return null;
	}


	@Override
	public GameData_Base createGameDataObject() {
		return GameDataUtils.createGameDataForNewGame(getUserSettings().playerTypeWhite, getUserSettings().playerTypeBlack,
				getUserSettings().boardManagerID, getUserSettings().computerModeID);
	}
}
