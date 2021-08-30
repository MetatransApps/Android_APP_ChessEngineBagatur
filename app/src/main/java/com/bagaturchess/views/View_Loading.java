package com.bagaturchess.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatransapps.commons.ui.utils.BitmapUtils;

import com.bagaturchess.lib.R;


public class View_Loading extends com.chessartforkids.loading.View_Loading {
	
	
	private Bitmap[] bitmap_commons;
	private Bitmap background_image;
	
	private RectF rectf_leaderboards = new RectF();//Empty leader board (with size 0)
	
	
	public View_Loading(Context context) {
		
		super(context);
		
		background_image = BitmapUtils.fromResource(getContext(), R.drawable.ic_background_bagaturchess);
	}
	
	
	@Override
	protected Bitmap getBitmapBackground() {
		return background_image;
	}
	
	
	@Override
	protected void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_computer_moving),
				getImageBitmap(R.drawable.ic_logo_bagaturchess),
		};
		
		super.initPiecesBitmaps();
	}
	
	
	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}
	
	
	@Override
	public RectF getRectangle_LeaderBoards() {
		return rectf_leaderboards;
	}
}
