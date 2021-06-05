package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging;

public class Interactions {

  /**
   * Discord API type
   */
  public enum OverwriteType {
    ROLE(0), MEMBER(1);

    int type;

    OverwriteType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum InteractionType {
    PING(1), APPLICATION_COMMAND(2), MESSAGE_COMPONENT(3);

    int type;

    InteractionType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum PremiumType {
    NONE(0), CLASSIC(1), NITRO(2);

    int type;

    PremiumType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum UserFlag {
    NONE(0), DISCORD_EMPLOYEE(1 << 0), PARTNERED_SERVER_OWNER(1 << 1), HYPESQUAD_EVENTS(1 << 2),
    BUG_HUNTER_LVL_ONE(1 << 3), HOUSE_BRAVERY(1 << 6), HOUSE_BRILLIANCE(1 << 7), HOUSE_BALANCE(1 << 8),
    EARLY_SUPPORTER(1 << 9), TEAM_USER(1 << 10), BUG_HUNTER_LVL_TWO(1 << 14), VERIFIED_BOT(1 << 16),
    EARLY_VERIFIED_BOT_DEVELOPER(1 << 17), DISCORD_CERTIFIED_MODERATOR(1 << 18);

    int userFlag;

    UserFlag(int userFlag) {
      this.userFlag = userFlag;
    }
  }

  /**
   * Discord API type
   */
  public enum ChannelType {
    GUILD_TEXT(0), DM(1), GUILD_VOICE(2), GROUP_DM(3), GUILD_CATEGORY(4), GUILD_NEWS(5), GUILD_STORE(6),
    GUILD_NEWS_THREAD(10), GUILD_PUBLIC_THREAD(11), GUILD_PRIVATE_THREAD(12), GUILD_STAGE_VOICE(13);

    public int type;

    ChannelType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum VideoQualityMode {
    AUTO(1), FULL(2);

    int mode;

    VideoQualityMode(int mode) {
      this.mode = mode;
    }
  }

  /**
   * Discord API type
   */
  public enum EmbedType {
    RICH("rich"), IMAGE("image"), VIDEO("video"), GIFV("gifv"), ARTICLE("article"), LINK("link");

    String type;

    EmbedType(String type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum MessageType {
    DEFAULT(0), RECIPIENT_ADD(1), RECIPIENT_REMOVE(2), CALL(3), CHANNEL_NAME_CHANGE(4), CHANNEL_ICON_CHANGE(5),
    CHANNEL_PINNED_MESSAGE(6), GUILD_MEMBER_JOIN(7), USER_PREMIUM_GUILD_SUBSCRIPTION(8),
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_1(9), USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_2(10),
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_3(11), CHANNEL_FOLLOW_ADD(12), GUILD_DISCOVERY_DISQUALIFIED(14),
    GUILD_DISCOVERY_REQUALIFIED(15), GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING(16),
    GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING(17), THREAD_CREATED(18), REPLY(19), APPLICATION_COMMAND(20),
    THREAD_STARTER_MESSAGE(21), GUILD_INVITE_REMINDER(22);

    int type;

    MessageType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum MessageActivityType {
    JOIN(1), SPECTATE(2), LISTEN(3), JOIN_REQUEST(4);

    int type;

    MessageActivityType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum MembershipState {
    INVITED(1), ACCEPTED(2);

    int state;

    MembershipState(int state) {
      this.state = state;
    }
  }

  /**
   * Discord API type
   */
  public enum ApplicationFlags {
    GATEWAY_PRESENCE(1 << 12), GATEWAY_PRESENCE_LIMITED(1 << 13), GATEWAY_GUILD_MEMBERS(1 << 14),
    GATEWAY_GUILD_MEMBERS_LIMITED(1 << 15), VERIFICATION_PENDING_GUILD_LIMIT(1 << 16), EMBEDDED(1 << 17);

    int flag;

    ApplicationFlags(int flag) {
      this.flag = flag;
    }
  }

  /**
   * Discord API type
   */
  public enum MessageFlags {
    CROSSPOSTED(1 << 0), IS_CROSSPOST(1 << 1), SUPRESS_EMBEDS(1 << 2), SOURCE_MESSAGE_DELETED(1 << 3), URGENT(1 << 4),
    HAS_THREAD(1 << 5), EPHEMERAL(1 << 6), LOADING(1 << 7);

    int flag;

    MessageFlags(int flag) {
      this.flag = flag;
    }
  }

  /**
   * Discord API type
   */
  public enum StickerFormatType {
    PNG(1), APNG(2), LOTTIE(3);

    int type;

    StickerFormatType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum ComponentType {
    ACTION_ROW(1), BUTTON(2);

    int type;

    ComponentType(int type) {
      this.type = type;
    }
  }

  /**
   * Discord API type
   */
  public enum ButtonStyle {
    PRIMARY(1), SECONDARY(2), SUCCESS(3), DANGER(4), LINK(5);

    int style;

    ButtonStyle(int style) {
      this.style = style;
    }
  }

  /**
   * Discord API type
   */
  public enum InteractionCallbackType {
    PONG(1), CHANNEL_MESSAGE_WITH_SOURCE(4), DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE(5), DEFERRED_UPDATE_MESSAGE(6),
    UPDATE_MESSAGE(7);

    public int type;

    InteractionCallbackType(int type) {
      this.type = type;
    }
  }

}
