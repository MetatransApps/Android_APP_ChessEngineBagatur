package org.metatrans.apps.bagatur.activities;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.bagatur.app.Application_BagaturEngine;
import org.metatrans.apps.bagatur.cfg.difficulty.ConfigurationUtils_Difficulty;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.cfg.difficulty.IConfigurationDifficulty;
import org.metatrans.commons.chess.GlobalConstants;
import org.metatrans.commons.chess.R;
import org.metatrans.commons.chess.logic.BoardConstants;
import org.metatrans.commons.chess.menu.MenuActivity_Base;
import org.metatrans.commons.chess.model.GameData;
import org.metatrans.commons.chess.utils.CachesBitmap;
import org.metatrans.commons.ui.list.ListViewFactory;
import org.metatrans.commons.ui.list.RowItem_CIdTD;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class Activity_MenuDifficulty_BagaturChess extends MenuActivity_Base implements GlobalConstants, BoardConstants {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		int currOrderNumber = ConfigurationUtils_Difficulty.getInstance().getOrderNumber(getUserSettings().computerModeID);

		LayoutInflater inflater = LayoutInflater.from(this);

		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(((Application_Base) getApplication()).getUserSettings().uiColoursID);
		int color_background = coloursCfg.getColour_Background();

		ViewGroup frame = ListViewFactory.create_CITD_ByXML(this, inflater, buildRows(currOrderNumber), currOrderNumber, color_background, getItemClickListener());

		frame.setBackgroundColor(color_background);

		setContentView(frame);
		setFrame(frame);

		setBackgroundPoster(R.id.commons_listview_frame, 77);
	}


	public AdapterView.OnItemClickListener getItemClickListener() {
		return new OnItemClickListener_Menu();
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
			
			if (Application_BagaturEngine.getInstance().getGameData() != null) {
				((GameData) Application_Base.getInstance().getGameData()).setComputerModeID(computerModeID);
				Application_Base.getInstance().getGameData().save();
			}
		}
	}
}
