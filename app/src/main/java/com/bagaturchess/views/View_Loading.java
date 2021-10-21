package com.bagaturchess.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;

import com.bagaturchess.lib.R;
import com.chessartforkids.cfg.pieces.ConfigurationUtils_Pieces;
import com.chessartforkids.cfg.pieces.IConfigurationPieces;
import com.chessartforkids.logic.BoardConstants;

import java.util.ArrayList;
import java.util.List;


public class View_Loading extends com.chessartforkids.loading.View_Loading {
	
	
	private Bitmap[] bitmap_commons;
	
	
	public View_Loading(Context context) {
		
		super(context);
	}
	
	
	@Override
	public void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_computer_moving),
				getImageBitmap(R.drawable.ic_logo_bagaturchess),
		};

		IConfigurationPieces[] piecesCfgs = ConfigurationUtils_Pieces.getAll();

		List<Bitmap> bitmap_others_arr = new ArrayList<Bitmap>();

		for (int i=0; i<piecesCfgs.length; i++) {

			IConfigurationPieces piecesCfg = piecesCfgs[i];

			if (piecesCfg.getID() == IConfigurationPieces.CFG_PIECES_ASCII_droid_sans_fallback_1
					|| piecesCfg.getID() == IConfigurationPieces.CFG_PIECES_ASCII_arial_unicode_ms
					|| piecesCfg.getID() == IConfigurationPieces.CFG_PIECES_CUSTOM_2
					|| piecesCfg.getID() == IConfigurationPieces.CFG_PIECES_ASCII_segoe_ui_symbol
				) {

				for (int j = 0; j < 1; j++) {//Add them 1 times

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
	}
	
	
	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}
	
	
	@Override
	public RectF getRectangle_LeaderBoards() {
		return null;
	}
}
