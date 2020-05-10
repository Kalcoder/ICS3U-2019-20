package me.Kaleb.commands;

import me.Kaleb.Main;
import me.Kaleb.Settings;

import java.util.Arrays;

/**
 * Command to show a list of all commands or get detailed info on a command
 */
public class HelpCommand extends Command{
  
  /**
   * Constructor
   */
  public HelpCommand() {
    super("help", Arrays.asList("?", "h"), "Show a list of all commands or get detailed info on a command", "help [command]");
  }
  
  /**
   * Function called when the command is entered
   *
   * @param args The arguments passed to the command
   */
  @Override
  public void execute(String[] args) {
    if (args.length == 0) {
      System.out.println("Here are all of the commands:");
      for (Command command : Main.commands) {
        System.out.println(Settings.getSetting("prefix").getValue() + command.name);
      }
      return;
    }
  
    for (Command command :
            Main.commands) {
      if (args[0].equalsIgnoreCase(command.name)) {
        System.out.println(Settings.getSetting("prefix").getValue() + command.name);
        System.out.println("-----------------------------");
        System.out.println("Description");
        System.out.println(command.description);
        System.out.println();
        System.out.println("Usage");
        System.out.println(Settings.getSetting("prefix").getValue() + command.usage);
        System.out.println();
        System.out.println("Aliases");
        String argsString = Arrays.toString(command.aliases.toArray());
        System.out.println(argsString.substring(1, argsString.length() - 1));
        System.out.println("-----------------------------");
      }
    }
  }
}
