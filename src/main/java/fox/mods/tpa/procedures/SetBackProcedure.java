package fox.mods.tpa.procedures;

import fox.mods.api.tpa.configuration.TpaFileConfiguration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import fox.mods.tpa.network.TpaModVariables;

@Mod.EventBusSubscriber
public class SetBackProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				double _setval = entity.getX();
				entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.backX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getY();
				entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.backX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getZ();
				entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.backX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (TpaFileConfiguration.BACKENABLED.get() == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.BACKPOSSETBACKENABLED.get())), false);
			} else if (TpaFileConfiguration.BACKENABLED.get() == false) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.BACKPOSSETBACKDISABLED.get())), false);
			}
		}
	}
}
