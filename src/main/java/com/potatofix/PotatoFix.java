package com.potatofix;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PotatoFix implements ModInitializer {

    public static final String MOD_ID = "potatofix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("PotatoFix loaded! Fixing performance issues for low-end PCs...");
    }
}