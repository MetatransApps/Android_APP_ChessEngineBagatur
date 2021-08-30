package com.bagaturchess.activities;


import org.metatransapps.commons.Activity_Base;
import org.metatransapps.commons.loading.View_Loading_Base;

import com.bagaturchess.lib.R;
import com.bagaturchess.views.View_Loading;
import com.chessartforkids.loading.Activity_Loading;
import com.chessartforkids.utils.StaticCache;


public class Activity_Loading_BagaturChess extends Activity_Loading {
	
	
	@Override
	protected void load() {
		if (!loaded) {
			StaticCache.initBoardManagersClasses_AllRulesOnly(gamedata, userSettings);
		} else {
			super.load();
		}
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		return R.drawable.ic_background_bagaturchess;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getNextActivityClass() {
		return Activity_Main_BagaturChess.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu1() {
		return Activity_MenuPieces_BagaturChess.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu2() {
		return Activity_MenuDifficulty_BagaturChess.class;
	}
	
	
	@Override
	protected View_Loading_Base getLoadingView() {
		View_Loading view = new View_Loading(this);
		return view;
	}
}
