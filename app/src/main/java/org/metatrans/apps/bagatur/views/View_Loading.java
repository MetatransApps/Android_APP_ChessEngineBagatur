package org.metatrans.apps.bagatur.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.chess.R;
import org.metatrans.commons.chess.cfg.pieces.ConfigurationUtils_Pieces;
import org.metatrans.commons.chess.cfg.pieces.IConfigurationPieces;
import org.metatrans.commons.chess.logic.BoardConstants;
import org.metatrans.commons.chess.model.UserSettings;


public class View_Loading extends org.metatrans.commons.chess.views_and_controllers.View_Loading {
	
	
	private Bitmap[] bitmap_commons;
	
	
	public View_Loading(Context context) {
		
		super(context);

		invalidate();
	}


	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}

	
	@Override
	public void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {

				getImageBitmap(R.drawable.ic_computer_moving_bagatur),

				getImageBitmap(R.drawable.ic_logo_bagaturchess),
		};


		UserSettings settings = (UserSettings) Application_Base.getInstance().getUserSettings();

		IConfigurationPieces piecesCfg = ConfigurationUtils_Pieces.getConfigByID(settings.uiPiecesID);

		List<Bitmap> bitmap_others_arr = new ArrayList<Bitmap>();


		for (int j = 0; j < 3; j++) {//Add them 1 times

			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_KING));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_QUEEN));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_BISHOP));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_KNIGHT));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_ROOK));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_W_PAWN));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));

			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_KING));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_QUEEN));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_BISHOP));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_KNIGHT));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_ROOK));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
			bitmap_others_arr.add(getPieceBitmap(piecesCfg, BoardConstants.ID_PIECE_B_PAWN));
			createEntry(bitmap_others_arr.get(bitmap_others_arr.size() - 1));
		}
	}
}
