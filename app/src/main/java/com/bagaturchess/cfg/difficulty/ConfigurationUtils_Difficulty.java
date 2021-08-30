package com.bagaturchess.cfg.difficulty;


import org.metatransapps.commons.cfg.IConfigurationEntry;
import org.metatransapps.commons.cfg.difficulty.ConfigurationUtils_Base_Difficulty;
import org.metatransapps.commons.cfg.difficulty.IConfigurationDifficulty;


public class ConfigurationUtils_Difficulty extends ConfigurationUtils_Base_Difficulty {	
	
	
	private static final String TAG_NAME = ConfigurationUtils_Difficulty.class.getName();
	
	
	public static ConfigurationUtils_Difficulty getInstance() {
		return (ConfigurationUtils_Difficulty) getInstance(TAG_NAME);
	}
	
	
	public static void createInstance() {
		
		IConfigurationEntry[] cfgs_entries = new IConfigurationDifficulty[] {
				new Config_Difficulty_1(),
				new Config_Difficulty_2(),
				new Config_Difficulty_3(),
				new Config_Difficulty_4(),
				new Config_Difficulty_5(),
				new Config_Difficulty_6(),
				new Config_Difficulty_7(),
				new Config_Difficulty_8(),
				new Config_Difficulty_9(),
				new Config_Difficulty_10(),
				new Config_Difficulty_11(),
				new Config_Difficulty_12(),
				new Config_Difficulty_13(),
				new Config_Difficulty_14(),
				new Config_Difficulty_15(),
				new Config_Difficulty_16(),
			};
		
		createInstance(TAG_NAME, new ConfigurationUtils_Difficulty(), cfgs_entries);
		
	}
}
