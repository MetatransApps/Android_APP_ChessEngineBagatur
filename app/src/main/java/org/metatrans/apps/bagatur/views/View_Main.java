package org.metatrans.apps.bagatur.views;


import org.metatrans.commons.chess.main.views.BoardView;
import org.metatrans.commons.chess.main.views.MainView;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;


public class View_Main extends MainView {
	
	
	public View_Main(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	@Override
	protected BoardView createBoardView(RectF rectf_board) {
		return new View_Board(getContext(), this, rectf_board);
	}
}
