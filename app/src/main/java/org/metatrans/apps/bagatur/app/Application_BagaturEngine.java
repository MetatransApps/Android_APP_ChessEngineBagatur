package org.metatrans.apps.bagatur.app;


import org.metatrans.apps.bagatur.cfg.difficulty.ConfigurationUtils_Difficulty;
import org.metatrans.commons.chess.cfg.rules.ConfigurationUtils_Bagatur_AllRules;
import org.metatrans.commons.chess.logic.game.GameDataUtils;
import org.metatrans.commons.chess.model.UserSettings;
import org.metatrans.commons.model.GameData_Base;


public abstract class Application_BagaturEngine extends org.metatrans.commons.chess.app.Application_Chess_BaseImpl {


	@Override
	protected void loadCustomConfigurations() {
		ConfigurationUtils_Bagatur_AllRules.init(this);
		ConfigurationUtils_Difficulty.createInstance();
	}


	@Override
	public GameData_Base createGameDataObject() {

		UserSettings settings = (UserSettings) getUserSettings();

		return GameDataUtils.createGameDataForNewGame(settings.playerTypeWhite, settings.playerTypeBlack,
				settings.boardManagerID, settings.computerModeID);
	}
}
