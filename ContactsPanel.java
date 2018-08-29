

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.NotActiveException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContactsPanel extends JPanel{
 JLabel status = new JLabel(); //a label for the bottom
 Person[] contacts = new Person[200]; //MAX number of contacts is 200
 int length = 0; //number of contacts currently in the list
 
 /* The constructor for the ContactsPanel Object. Read through and try to
  * understand how this object is created.
  */
 public ContactsPanel(){
  super(new BorderLayout()); //call to JFrame's constructor, passing in a BorderLayout
  
  //create the different tabs (which are JPanels) in different methods that return JPanels
  JPanel addTab = createAddTab(); //you create the createAddTab() method 
  JPanel viewTab = createViewTab(); //you create the createViewTab() method 
  
  //creates a JLabel and tells it to be in the center
  status = new JLabel("", JLabel.CENTER);
  
  //creates the tabs, each with its 
  JTabbedPane tabbedPane = new JTabbedPane();
  tabbedPane.addTab("Add Contacts", addTab);
  tabbedPane.addTab("View Contacts", viewTab);
  
  //adds the tabbedPAne and the bottom JLabel to the main window.
  this.add(tabbedPane, BorderLayout.CENTER);
  this.add(status, BorderLayout.PAGE_END);
  
  //sets a border around the JLabel
        status.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 }
 
 
 
 /* Use this method to create and return a JPanel for adding 
  * a contact to the contacts list.
  */
 private JPanel createAddTab(){
  JPanel result = new JPanel(); //the JPanel to return
  final int numFields = 3; //the number of fields in a person,
  
  //create an array  of JLabels with length of the int numFields
  JLabel[] labels = new JLabel[numFields];
  
  //create an array of JTextFields with length of the int numFields
  JTextField[] textFields = new JTextField[numFields];
  
  //set each label and textfield. 
 
  //The 0th label and textfield should be for the name, this field can not be empty.
  result.add(labels[0]= new JLabel("Enter Contact Name"));
  result.add(textFields[0] = new JTextField());
//  if(textFields[0].getText().isEmpty()){
//	  
//  }
  //The 1st should be for the phone number, it can be empty or numbers without dashes,
  //and the phone number should not exceed 10 digits.
  result.add(labels[1] = new JLabel("Enter phone number (no dashes)"));
  result.add(textFields[1] = new JTextField());
//  if(textFields[1].getText().length() > 10){
//	  
//  }
  //The 2nd should be for the email, can be empty.
  //(Run the jar file for exact wording)
  result.add(labels[2]= new JLabel("Enter Contact Email"));
  result.add(textFields[2]= new JTextField());
  
  //create a submit button
  JButton submit = new JButton("submit");
  result.add(submit);
  /* Add a new action listener to the button. In the action listener's
   * actionPreformed method, make sure that name is not blank, and that 
   * if a phone number has been entered correctly (no dashes). If so
   * add the person into the contacts array.
   */
  submit.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//validate name, phone, (optional) email
		//only if all are valid then add new person
		//else set text of status field to error message
		
	}
	  
  });
  
  //this statement must be called for aesthetics
  //try commenting it out when finished to see what happens
  result.setLayout(new BoxLayout(result, BoxLayout.PAGE_AXIS));
  
  //prepare the result JPanel by adding all fields and buttons
  
  
  return result;
 }
 
 /* create the method that returns the panel that you see in the 
  * finished product when you click the view tab.
  * There are some tips in the handout that can be helpful for you.
  */
 private JPanel createViewTab(){
	 JPanel view = new JPanel();
	 view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
	 
	 
	 JButton refresh = new JButton("Refresh");
	  view.add(refresh);
	  
	 return view;//replace this with your JPanel
 }
   //create a JPanel and set its layout with proper type by calling setLayout()
  
   
   
   //create a JButtion with name "refresh" and add it to the JPanel you just created
   
   
   /* Add a new action listener to the JButtion you just created. In the action listener's
    * actionPerformed method, you need to get an JLabel array that contains all the JLabels.
    * Then you need to add all these Jlabels to the panel. 
    * /
   //All for createViewTab?
   
 
 
 
 /*
  * This is a method that creates a bunch of JLabels based on the number of contacts
  * in the Person array.
  */
 private JLabel[] contactLabels(){
  JLabel[] contactLabels = new JLabel[4 * length]; //4 JLabels per person
  for(int i = 0; i < length; i ++){
   int j = 4 * i; //starting index contactLabels
   contactLabels[j] = new JLabel("Name: "+ contacts[i].getName());
   String phoneNumber = contacts[i].getNumber() == 0 ? "" : Long.toString(contacts[i].getNumber());
   contactLabels[j+1] = new JLabel("Phone Number: "+ phoneNumber);
   contactLabels[j+2] = new JLabel("Email: "+ contacts[i].getEmail());
   contactLabels[j+3] = new JLabel("*******************************");
  }
  
  return contactLabels;
 }
 
 
 
 //the main method. follow instructions.
 public static void main(String[] args){
  //create the JFrame to be used as the main window.
	 Dimension d = new Dimension(320,240);
	 JFrame frame = new JFrame("Contacts");
  //set the default close operation to JFrame.DISPOSE_ON_CLOSE.
	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  //creates the ContactsPanel.
ContactsPanel c = new ContactsPanel();
  //set the preferred size of the Contactpanels to 320 by 240 using a Dimension object
  c.setPreferredSize(d);
  
  //call setContentPane on your JFrame object and pass in your ContactsPanel object
  frame.setContentPane(c);
  
  //packs the window
  frame.pack();
  //sets it visible
  frame.setVisible(true);
 }
}
