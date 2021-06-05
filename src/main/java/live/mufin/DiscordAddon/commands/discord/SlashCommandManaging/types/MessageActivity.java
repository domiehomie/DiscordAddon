package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.MessageActivityType;

public class MessageActivity {
    MessageActivityType type;
    String party_id;

    public MessageActivityType getType() {
        return type;
    }

    public String getParty_id() {
        return party_id;
    }

    @Override
    public String toString() {
        return "MessageActivity{" + "type=" + type + ", party_id='" + party_id + '\'' + '}';
    }
}
