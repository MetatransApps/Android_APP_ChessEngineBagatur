package com.bagaturchess.activities;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.bagaturchess.cfg.difficulty.ConfigurationUtils_Difficulty;
import com.bagaturchess.lib.R;
import com.chessartforkids.cfg.pieces.ConfigurationUtils_Pieces;
import com.chessartforkids.menu.MenuActivity_Main;
import com.chessartforkids.model.UserSettings;

import java.util.List;

import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Base;
import org.metatrans.commons.cfg.menu.IConfigurationMenu_Main;
import org.metatrans.commons.web.Activity_WebView_StatePreservingImpl_With_VideoPlayer;


public class Activity_MenuMain_BagaturChess extends MenuActivity_Main /*implements GlobalConstants*/ {
	
	
	public static int CFG_MENU_STAR_ON_GITHUB 	= 30;
	public static int CFG_MENU_EDIT_BOARD 		= 31;
	
	
	@Override
	protected int getBackgroundImageID() {
		boolean left_handed = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
		return left_handed ? R.drawable.ic_background_bagaturchess : R.drawable.ic_background_bagaturchess;
	}
	
	
	@Override
	protected Class<?> getMainActivityClass() {
		return Activity_Main_BagaturChess.class;
	}
	
	
	@Override
	protected List<IConfigurationMenu_Main> getEntries() {
		
		
		List<IConfigurationMenu_Main> entries = super.getEntries();

		if (Application_Base.getInstance().getApp_Me().getPaidVersion() != null) {
			entries.remove(6);//Remove Difficulty menu item (from Chess Art For Kids)
			entries.remove(6);//Remove Pieces menu item (from Chess Art For Kids)
			entries.remove(6);//Remove Rules menu item (from Chess Art For Kids)
		} else {
			entries.remove(5);//Remove Difficulty menu item (from Chess Art For Kids)
			entries.remove(5);//Remove Pieces menu item (from Chess Art For Kids)
			entries.remove(5);//Remove Rules menu item (from Chess Art For Kids)
		}
		
		entries.add(1, new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.menu_edit_board;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_edit_white;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_EDIT_BOARD;
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						
						Intent i = new Intent(getApplicationContext(), Activity_EditBoard.class);
						startActivity(i);
						finish();
						
					}
				};
			}
		});
		
		entries.add(7, new Config_MenuMain_Base() {
			
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
		
		
		entries.add(7, new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.menu_pieces_scheme;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_pieces;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_PIECES;
			}
			
			@Override
			public String getDescription_String() {
				return getString(R.string.label_current) + ": " + getString(ConfigurationUtils_Pieces.getConfigByID(((UserSettings)Application_Base.getInstance().getUserSettings()).uiPiecesID).getName());
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						
						//Pieces
						Intent i = new Intent(getApplicationContext(), Activity_MenuPieces_BagaturChess.class);
						startActivity(i);
						finish();
						
					}
				};
			}
		});
		
		
		entries.add(9, new Config_MenuMain_Base() {
			
			
			@Override
			public int getName() {
				return R.string.menu_about_bagatur;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_star_gold;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_STAR_ON_GITHUB;
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						Activity currentActivity = Application_Base.getInstance().getCurrentActivity();
						if (currentActivity != null) {
				           	Intent intent = new Intent(currentActivity, Activity_WebView_StatePreservingImpl_With_VideoPlayer.class);
			            	intent.putExtra("URL", "https://github.com/bagaturchess/Bagatur");
			            	intent.putExtra("titleID", getName_String());
			            	currentActivity.startActivity(intent);
						}
					}
				};
			}
		});
		
		
		return entries;
	}
}
