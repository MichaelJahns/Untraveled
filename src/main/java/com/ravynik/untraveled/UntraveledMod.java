package com.ravynik.untraveled;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ravynik.untraveled.util.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class UntraveledMod {

    public static UntraveledMod instance;
    public static final String modid = Reference.MOD_ID;
    private static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public UntraveledMod(){
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        logger.info("RAV: Setup method registered");
    }

    private void clientRegistries(final FMLClientSetupEvent event){
        logger.info("RAV: clientRegistries method registered");

    }
}
