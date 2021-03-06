package me.Kaleb.commands;

import me.Kaleb.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Command used to exit the program
 */
public class ExitCommand extends Command {
  
  /**
   * Constructor
   */
  public ExitCommand() {
    super("exit", Arrays.asList("e"), "Used to exit the program", "exit");
  }
  
  /**
   * Function called when the command is entered
   *
   * @param args The arguments passed to the command
   */
  @Override
  public void execute(String[] args) {
    // Confirm if the user would like to exit out of the program
    Scanner reader = new Scanner(System.in);
    boolean exit = InputUtils.confirm("Are you sure you wish to exit?", reader);
    if (exit) {
      System.out.println("Goodbye!");
      System.exit(0);
    }
  }
}
