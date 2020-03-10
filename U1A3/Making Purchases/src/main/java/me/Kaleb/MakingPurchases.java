/*
    Created on 2020-03-10 at 3:56 PM
    Author: Kalcoder
*/
package me.Kaleb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static me.Kaleb.MakingPurchases.Prices.*;

public class MakingPurchases {
//  Auto-generated GUI variables
  private JTextField txtUSBAmount;
  private JTextField txtKeyboardAmount;
  private JTextField txtMouseAmount;
  private JTextField txtMonitorAmount;
  private JButton calculateTotalButton;
  private JPanel pnlMain;
  private JLabel lblSubtotal;
  private JLabel lblTaxes;
  private JLabel lblTotal;
  
//  Register listeners
  public MakingPurchases() {
    calculateTotalButton.addActionListener(this::onCalculateClicked);
  }
  
//  Runs when program starts
  public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    JFrame frame = new JFrame("MakingPurchases");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    frame.setContentPane(new MakingPurchases().pnlMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
//  Fired when calculate button clicked
  private void onCalculateClicked(ActionEvent e) {
//    Declare variables
    int usbAmount;
    int keyboardAmount;
    int mouseAmount;
    int monitorAmount;
  
    try {
//      Attempt to initialize variables
      usbAmount = Integer.parseInt(txtUSBAmount.getText());
      keyboardAmount = Integer.parseInt(txtKeyboardAmount.getText());
      mouseAmount = Integer.parseInt(txtMouseAmount.getText());
      monitorAmount = Integer.parseInt(txtMonitorAmount.getText());
    } catch (NumberFormatException ex) {
//      Show error message if amount was inputted incorrectly
      JOptionPane.showMessageDialog(pnlMain, "One or more of your amounts was not inputted correctly! Please ensure that the number of items that you would like to buy is a number and try again!");
      return;
    }
  
//    Calculate costs
    double usbCost = usbAmount * USB_PRICE;
    double keyboardCost = keyboardAmount * KEYBOARD_PRICE;
    double mouseCost = mouseAmount * MOUSE_PRICE;
    double monitorCost = monitorAmount * MONITOR_PRICE;
  
  
//    Calculate subtotal, taxes, and grand total
    double subtotal = usbCost + keyboardCost + mouseCost + monitorCost;
    lblSubtotal.setText("$" + subtotal);
    
    double taxes = subtotal * 0.13;
    lblTaxes.setText("$" + taxes);
    
    double total = subtotal + taxes;
    lblTotal.setText("$" + total);
  }
  
//  Static class to contain prices
  static class Prices {
    public static final double USB_PRICE = 15.99;
    public static final double KEYBOARD_PRICE = 36.99;
    public static final double MOUSE_PRICE = 45.99;
    public static final double MONITOR_PRICE = 136.99;
  }
}
