package org.metatrans.apps.bagatur.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.security.KeyChainException;

import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.chess.R;
import org.metatrans.commons.chess.edit.EditBoardView;
import org.metatrans.commons.chess.views_and_controllers.IBoardVisualization;
import org.metatrans.commons.web.WebUtils;

import java.util.concurrent.ExecutorService;


public class Activity_EditBoard extends org.metatrans.commons.chess.edit.EditBoardActivity {


	@Override
	protected EditBoardView createView() {
		return new EditBoardView(this, null);
	}


	@Override
	protected int button1ImageID() {
		return R.drawable.ic_action_like_white;
	}


	@Override
	protected int button2ImageID() {
		return R.drawable.ic_computer_moving_bagatur;
	}


	@Override
	protected void processButton1() {

		WebUtils.openApplicationStorePage(this, Application_Base.getInstance().getApp_Me());
	}


	@Override
	protected void processButton2() {

		Intent intent = new Intent(this, Activity_Main_BagaturChess.class);

		intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

		startActivity(intent);
	}


	@Override
	public void updateViewWithGameResult(int gameStatus) {
		//Do nothing
	}

	@Override
	public Class<? extends Activity> getMainMenuClass() {
		return null;
	}

	@Override
	public void createNewGame(String initialBoard) {
		throw new IllegalStateException();
	}


	@Override
	public Handler getUIHandler() {

		throw new UnsupportedOperationException();
	}


	@Override
	public void executeJob(Runnable runnable) {

		throw new UnsupportedOperationException();
	}


	@Override
	public IBoardVisualization getBoard() {

		throw new UnsupportedOperationException();
	}


	@Override
	public ExecutorService getExecutor() {

		throw new UnsupportedOperationException();
	}
}
