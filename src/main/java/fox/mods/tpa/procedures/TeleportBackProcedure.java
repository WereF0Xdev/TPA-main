package fox.mods.tpa.procedures;

import fox.mods.api.tpa.configuration.TpaFileConfiguration;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import fox.mods.tpa.network.TpaModVariables;
import fox.mods.tpa.TpaMod;

public class TeleportBackProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (TpaFileConfiguration.BACKENABLED.get() == true) {
			if ((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).setBack == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPISACCEPTEDSENDER.get())), false);
				TpaMod.queueServerWork((int) (20 * (double) TpaFileConfiguration.TELEPORTATIONTIME.get()), () -> {
					{
						Entity _ent = entity;
						_ent.teleportTo(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backX),
								((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backY),
								((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backZ));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backX),
									((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backY),
									((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).backZ), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHAPPENED.get())), false);
					{
						boolean _setval = false;
						entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.setBack = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else if ((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).setBack == false) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORNOBACKPOS.get())), false);
			}
		} else if (TpaFileConfiguration.BACKENABLED.get() == false) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORNOPERMS.get())), false);
		}
	}
}
