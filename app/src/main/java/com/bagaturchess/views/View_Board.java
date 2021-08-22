package com.bagaturchess.views;


import android.content.Context;
import android.graphics.RectF;
import android.view.View;

import com.apps.mobile.android.commons.engagement.leaderboards.View_Achievements_And_Leaderboards_Base;
import com.chessartforkids.main.views.BoardView;


public class View_Board extends BoardView {
	
	
	private RectF dummy_leaderboards = new RectF();
	
	
	public View_Board(Context context, View _parent, RectF _rectangle) {
		super(context, _parent, _rectangle);
	}
	
	
	@Override
	public View_Achievements_And_Leaderboards_Base getLeaderboard() {
		return null;
	}
	
	
	@Override
	public RectF getRect_leaderboards() {
		return dummy_leaderboards;
	}
}
