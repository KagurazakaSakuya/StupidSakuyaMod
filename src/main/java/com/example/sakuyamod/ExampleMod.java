package com.example.sakuyamod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "sakuyamod";
	public static final Item stupidsakuya = new Item(new Item.Settings()
			.food((new FoodComponent.Builder()
					.nutrition(4)
					.saturationModifier(0.3f)
					.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,15*20),1.0F)
					.alwaysEdible()
					.build())));



	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM, Identifier.of(MOD_ID,"stupidsakuya"), stupidsakuya);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.add(stupidsakuya);
		});

		LOGGER.info("Hello Fabric world!");
	}
}