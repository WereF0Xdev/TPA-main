package fox.mods.tpa.procedures;

import fox.mods.api.tpa.configuration.TpaFileConfiguration;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import fox.mods.tpa.network.TpaModVariables;
import fox.mods.tpa.TpaMod;

import com.mojang.util.UUIDTypeAdapter;

import java.text.DecimalFormat;

public class AcceptTpHereProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser).equals("")
				|| ((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaReceiver).equals(""))) {
			if (!((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser).equals(entity.getStringUUID())) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPISACCEPTEDACCEPTER.get())), false);
				if ((TpaFileConfiguration.TPISACCEPTEDSENDER.get()).contains("%tptime%")) {
					if (new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)) instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
										(TpaFileConfiguration.PREFIX.get() + "" + (TpaFileConfiguration.TPISACCEPTEDSENDER.get()).replace("%tptime%", new DecimalFormat("##").format((double) TpaFileConfiguration.TELEPORTATIONTIME.get())))),
								false);
				} else {
					if (new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)) instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPISACCEPTEDSENDER.get())), false);
				}
				TpaMod.queueServerWork((int) (20 * (double) TpaFileConfiguration.TELEPORTATIONTIME.get()), () -> {
					{
						Entity _ent = entity;
						_ent.teleportTo((new Object() {
							Entity getEntity(String uuid) {
								Entity _uuidentity = null;
								if (world instanceof ServerLevel _server) {
									try {
										_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
									} catch (IllegalArgumentException e) {
									}
								}
								return _uuidentity;
							}
						}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getX()), (new Object() {
							Entity getEntity(String uuid) {
								Entity _uuidentity = null;
								if (world instanceof ServerLevel _server) {
									try {
										_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
									} catch (IllegalArgumentException e) {
									}
								}
								return _uuidentity;
							}
						}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getY()), (new Object() {
							Entity getEntity(String uuid) {
								Entity _uuidentity = null;
								if (world instanceof ServerLevel _server) {
									try {
										_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
									} catch (IllegalArgumentException e) {
									}
								}
								return _uuidentity;
							}
						}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getX()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getY()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)).getZ()), _ent.getYRot(), _ent.getXRot());
					}
					if (new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaUser)) instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHAPPENED.get())), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHAPPENED.get())), false);
					{
						String _setval = "";
						entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tpaUser = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tpaReceiver = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORSELFACCEPT.get())), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORNOTP.get())), false);
		}
	}
}
