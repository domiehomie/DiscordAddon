package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Interaction;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.RawGatewayEvent;
import net.dv8tion.jda.api.hooks.EventListener;

/**
 * Initializing listeners and sending event.
 */
public class Initiater implements EventListener {
    private static List<InteractionListener> listeners = new ArrayList<InteractionListener>();

    public void addListener(InteractionListener toAdd) {
        listeners.add(toAdd);
    }

    public void sendInteraction(Interaction interaction) {
        for (InteractionListener hl : listeners) {
            hl.onInteraction(interaction);
        }
    }

    /**
     * Method to register a listener
     * 
     * @param listener Class implementing InteractionListener
     */
    public void registerListener(InteractionListener listener) {
        this.addListener(listener);
    }

    @Override
    public void onEvent(GenericEvent ge) {
        if (!(ge instanceof RawGatewayEvent))
            return;
        RawGatewayEvent event = (RawGatewayEvent) ge;
        if (!event.getType().equals("INTERACTION_CREATE"))
            return;
        byte[] rawJson = event.getPayload().toJson();
        String json = new String(rawJson, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        Interaction interaction = gson.fromJson(json, new TypeToken<Interaction>() {
        }.getType());
        this.sendInteraction(interaction);
    }

}