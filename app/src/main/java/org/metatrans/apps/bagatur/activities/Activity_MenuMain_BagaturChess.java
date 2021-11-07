package org.metatrans.apps.bagatur.activities;


import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.bagatur.cfg.difficulty.ConfigurationUtils_Difficulty;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Base;
import org.metatrans.commons.cfg.menu.IConfigurationMenu_Main;
import org.metatrans.commons.chess.R;
import org.metatrans.commons.chess.menu.Activity_MenuMain;
import org.metatrans.commons.chess.model.UserSettings;


public class Activity_MenuMain_BagaturChess extends Activity_MenuMain {


	public static int CFG_MENU_DIFFICULTY		 		= 15;


	@Override
	protected Class<?> getMainActivityClass() {
		return Activity_Main_BagaturChess.class;
	}


	@Override
	protected Class<?> getEditBoardActivityClass() { return Activity_EditBoard.class; }

	
	@Override
	protected List<IConfigurationMenu_Main> getEntries() {


		List<IConfigurationMenu_Main> result = new ArrayList<IConfigurationMenu_Main>();


		result.add(new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.menu_difficulty;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_computer;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_DIFFICULTY;
			}
			
			@Override
			public String getDescription_String() {
				return getString(R.string.label_current) + ": " + getString(ConfigurationUtils_Difficulty.getInstance().getConfigByID(((UserSettings)Application_Base.getInstance().getUserSettings()).computerModeID).getName());
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						
						//Difficulty
						Intent i = new Intent(getApplicationContext(), Activity_MenuDifficulty_BagaturChess.class);
						startActivity(i);
						finish();
						
					}
				};
			}
		});


		List<IConfigurationMenu_Main> parent_cfg = super.getEntries();

		result.addAll(parent_cfg);


		return result;
	}
}
