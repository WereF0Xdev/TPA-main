package fox.mods.tpa.procedures;

import fox.mods.api.tpa.configuration.TpaFileConfiguration;
import fox.mods.tpa.TpaMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import fox.mods.tpa.network.TpaModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.level.LevelAccessor;

public class SendTpHereProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaInCooldown == false) {
			if (!(entity == (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()))) {
				{
					boolean _setval = true;
					entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.tpaInCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaToggle == true) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHEREISSENT.get())), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHAPPENED.get())), false);
					{
						Entity _ent = entity;
						_ent.teleportTo(((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getX()), ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getY()), ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getX()), ((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getY()), ((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getZ()), _ent.getYRot(), _ent.getXRot());
					}
				} else if (((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaToggle == false) {
					{
						String _setval = entity.getStringUUID();
						(new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tpaUser = _setval;
							capability.syncPlayerVariables((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()));
						});
					}
					{
						String _setval = (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getStringUUID();
						(new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tpaReceiver = _setval;
							capability.syncPlayerVariables((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "player");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()));
						});
					}
					if ((TpaFileConfiguration.TPHEREISRECEIVED.get()).contains("%tpauser%")) {
						if ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + (TpaFileConfiguration.TPHEREISRECEIVED.get()).replace("%tpauser%", entity.getDisplayName().getString()))), false);
					} else {
						if ((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.TPHEREISRECEIVED.get())), false);
					}
				}
				TpaMod.queueServerWork((int) (20 * (double) TpaFileConfiguration.COOLDOWNTIME.get()), () -> {
					{
						boolean _setval = false;
						entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tpaInCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else if (entity == (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity())) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORSELFTP.get())), false);
			}
		} else if ((entity.getCapability(TpaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TpaModVariables.PlayerVariables())).tpaInCooldown == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((TpaFileConfiguration.PREFIX.get() + "" + TpaFileConfiguration.ERRORTPAINCOOLDOWN.get())), false);
		}
	}
}