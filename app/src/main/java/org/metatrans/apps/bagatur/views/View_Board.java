package org.metatrans.apps.bagatur.views;


import android.content.Context;
import android.graphics.RectF;
import android.view.View;

import org.metatrans.commons.chess.views_and_controllers.BoardView;
import org.metatrans.commons.engagement.leaderboards.View_Achievements_And_Leaderboards_Base;


public class View_Board extends BoardView {


	public View_Board(Context context, View _parent, RectF _rectangle) {
		super(context, _parent, _rectangle);
	}


	@Override
	public View_Achievements_And_Leaderboards_Base getLeaderboard() {
		return null;
	}
}
