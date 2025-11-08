package com.xiaoyu.httpjs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.fml.common.Mod;


@Mod(HttpJS.MODID)
public class HttpJS {

    public static final String MODID = "httpjs";

    public static final Logger LOGGER = LogUtils.getLogger();

    public HttpJS(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HttpJS Common Setup");
        LOGGER.debug("Also try FilesJS!");
    }
}
