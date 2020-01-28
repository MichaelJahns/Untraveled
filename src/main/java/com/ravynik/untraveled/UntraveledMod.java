package com.ravynik.untraveled;

import com.ravynik.untraveled.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            event.getRegistry().registerAll(
            ItemList.ornate_sword = new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ornate_sword"))
            );
            logger.info("Items Registered");
        }

        private static ResourceLocation location(String name){
            return new ResourceLocation(Reference.MOD_ID, name);
        }
    }

}
