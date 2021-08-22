package com.bagaturchess.views;


import android.content.Context;
import android.util.AttributeSet;

import com.chessartforkids.main.views.BoardView;
import com.chessartforkids.main.views.MainView;


public class View_Main extends MainView {
	
	
	public View_Main(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	@Override
	protected BoardView createBoardView() {
		return new View_Board(getContext(), this, rectf_board);
	}
}
