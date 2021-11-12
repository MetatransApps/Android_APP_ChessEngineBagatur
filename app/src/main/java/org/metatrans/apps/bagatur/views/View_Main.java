package org.metatrans.apps.bagatur.views;


import org.metatrans.commons.chess.views_and_controllers.BoardView;
import org.metatrans.commons.chess.views_and_controllers.MainView_WithMovesNavigation;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;


public class View_Main extends MainView_WithMovesNavigation {
	
	
	public View_Main(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	@Override
	protected BoardView createBoardView(RectF rectf_board) {
		return new View_Board(getContext(), this, rectf_board);
	}
}
