package com.bagaturchess.activities;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.apps.mobile.android.commons.cfg.difficulty.IConfigurationDifficulty;
import com.apps.mobile.android.commons.ui.list.ListViewFactory;
import com.apps.mobile.android.commons.ui.list.RowItem_CIdTD;
import com.apps.mobile.android.commons.ui.utils.BitmapUtils;
import com.bagaturchess.cfg.difficulty.ConfigurationUtils_Difficulty;
import com.bagaturchess.lib.R;
import com.chessartforkids.GlobalConstants;
import com.chessartforkids.logic.BoardConstants;
import com.chessartforkids.menu.MenuActivity_Base;
import com.chessartforkids.utils.CachesBitmap;

import java.util.ArrayList;
import java.util.List;


public class Activity_MenuDifficulty_BagaturChess extends MenuActivity_Base implements GlobalConstants, BoardConstants {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		int currOrderNumber = ConfigurationUtils_Difficulty.getInstance().getOrderNumber(getUserSettings().computerModeID);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		ViewGroup frame = ListViewFactory.create_CITD_ByXML(this, inflater, buildRows(currOrderNumber), currOrderNumber, getItemClickListener());
		
		setContentView(frame);
		setFrame(frame);
		
		setBackgroundPoster(R.id.commons_listview_frame, 77);
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		return R.drawable.ic_background_bagaturchess;
	}
	
	
	public List<RowItem_CIdTD> buildRows(int initialSelection) {
		
		List<RowItem_CIdTD> rowItems = new ArrayList<RowItem_CIdTD>();
		
		IConfigurationDifficulty[] cfgs = ConfigurationUtils_Difficulty.getInstance().getAll();
		
		for (int i = 0; i < cfgs.length; i++) {
			
			IConfigurationDifficulty cfg = cfgs[i];
			
			Bitmap bitmap = CachesBitmap.getSingletonIcons(getIconSize()).getBitmap(this, cfg.getIconResID());
			Drawable drawable = BitmapUtils.createDrawable(this, bitmap);
			RowItem_CIdTD item = new RowItem_CIdTD(true, i == initialSelection, drawable, getString(cfg.getName()), getString(cfg.getDescription()));
			rowItems.add(item);
		}
		
		return rowItems;
	}
	
	
	public AdapterView.OnItemClickListener getItemClickListener() {
		return new OnItemClickListener_Menu(); 
	}
	
	
	private class OnItemClickListener_Menu implements AdapterView.OnItemClickListener {


		private OnItemClickListener_Menu() {
		}
		
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			//System.out.println("MenuActivity_Difficulty: selection=" + position);
			
			int currOrderNumber = ConfigurationUtils_Difficulty.getInstance().getOrderNumber(getUserSettings().computerModeID);
			if (position != currOrderNumber) {
				int newCfgID = ConfigurationUtils_Difficulty.getInstance().getID(position);
				setDifficulty(newCfgID);
			}
			
			finish();
		}
		
		
		private void setDifficulty(int computerModeID) {
			
			getUserSettings().computerModeID = computerModeID;
			getUserSettings().save();
			
			if (getGamedata() != null) {
				getGamedata().setComputerModeID(computerModeID);
			}
		}
	}
}
