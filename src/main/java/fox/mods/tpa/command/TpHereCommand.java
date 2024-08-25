
package fox.mods.tpa.command;

import fox.mods.tpa.procedures.SendTpHereProcedure;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class TpHereCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		if (event.getCommandSelection() == Commands.CommandSelection.INTEGRATED)
			event.getDispatcher().register(Commands.literal("tpahere")

					.then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
						Level world = arguments.getSource().getUnsidedLevel();

						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();

						Entity entity = arguments.getSource().getEntity();
						if (entity == null && world instanceof ServerLevel _servLevel)
							entity = FakePlayerFactory.getMinecraft(_servLevel);

						Direction direction = Direction.DOWN;
						if (entity != null)
							direction = entity.getDirection();

						SendTpHereProcedure.execute(world, arguments, entity);
						return 0;
					})));
	}

}