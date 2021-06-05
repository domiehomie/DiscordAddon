package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.PremiumType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.UserFlag;

public class User {
    String id;
    String username;
    String avatar;
    String discriminator;
    boolean bot;
    boolean system;
    boolean mfa_enabled;
    String locale;
    boolean verified;
    String email;
    UserFlag flags;
    PremiumType premium_type;
    int public_flags;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public boolean isBot() {
        return bot;
    }

    public boolean isSystem() {
        return system;
    }

    public boolean isMfa_enabled() {
        return mfa_enabled;
    }

    public String getLocale() {
        return locale;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getEmail() {
        return email;
    }

    public UserFlag getFlags() {
        return flags;
    }

    public PremiumType getPremium_type() {
        return premium_type;
    }

    public int getPublic_flags() {
        return public_flags;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", username='" + username + '\'' + ", avatar='" + avatar + '\''
                + ", discriminator='" + discriminator + '\'' + ", bot=" + bot + ", system=" + system + ", mfa_enabled="
                + mfa_enabled + ", locale='" + locale + '\'' + ", verified=" + verified + ", email='" + email + '\''
                + ", flags=" + flags + ", premium_type=" + premium_type + ", public_flags=" + public_flags + '}';
    }
}
