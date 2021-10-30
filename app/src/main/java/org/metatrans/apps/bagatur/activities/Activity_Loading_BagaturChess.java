package org.metatrans.apps.bagatur.activities;


import org.metatrans.apps.bagatur.views.View_Loading;
import org.metatrans.commons.Activity_Base;
import org.metatrans.commons.chess.loading.Activity_Loading;
import org.metatrans.commons.chess.utils.StaticCache;
import org.metatrans.commons.loading.View_Loading_Base;


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
	protected Class<? extends Activity_Base> getNextActivityClass() {
		return Activity_Main_BagaturChess.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu1() {
		return null;
	}
	
	
	@Override
	protected View_Loading_Base getLoadingView() {
		View_Loading view = new View_Loading(this);
		return view;
	}
}
