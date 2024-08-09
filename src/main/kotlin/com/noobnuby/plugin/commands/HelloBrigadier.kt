package com.noobnuby.plugin.commands

import com.mojang.brigadier.Command
import com.noobnuby.plugin.Main.Companion.instance
import io.papermc.paper.command.brigadier.Commands.literal
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import net.kyori.adventure.text.Component.text

@Suppress("UnstableApiUsage")
object HelloBrigadier {
    fun register() {
        instance.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { command ->
            command.registrar().register(
                literal("hello-brigadier")
                    .requires { it.sender.isOp }
                    .executes {
                        val ctx = it.source.sender
                        ctx.sendMessage(text("Hello, world!"))
                        Command.SINGLE_SUCCESS
                    }
                    .build(),
                "send to player hello message",
                listOf("hb")
            )
        }
    }
}