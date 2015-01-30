/**
 * XO2
 */

package userclasses;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

import generated.StateMachineBase;

import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Kasra Madadipouya
 */
public class StateMachine extends StateMachineBase {
    private static final String DB_NAME = "XO2.sqlite";
    private static String TABLE_NAME = "";
    private static String COMPUTER_MAIN_SCORE_TABLE = "computer_main_score";
    private static String MAIN_SCORE_TABLE = "main_score";
    private static final String PLAYER_NAME = "player_name";
    private static final String SCORE = "score";
    private static boolean playingWithComputer = false;
    private static boolean isFirstMove = true;
    private static boolean isComputerWinner = false;
	private String firstPlayer = "";
    private String secondPlayer = "";
    private String computerPlayerName = "";
    private static String XScore = "0";
    private static String OScore = "0";
    private static int counter = 0;
    private static String lastWinner = "";
	public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
	protected void initVars(Resources res){
	}

    @Override
    protected void onFirst_ButtonAction(Component c, ActionEvent event) {
    	identifySelectedButtons();
    	showForm("Second", null);
    	
    
    }

    @Override
    protected void onFirst_RadioButtonAction(Component c, ActionEvent event) {
    	RadioButton rbtn1 = findRadioButton();
    	RadioButton rbtn2 = findRadioButton1();
    	this.toggleButton(rbtn1, rbtn2);
    	
    }

    @Override
    protected void onFirst_RadioButton1Action(Component c, ActionEvent event) {
    	RadioButton rbtn1 = findRadioButton1();
    	RadioButton rbtn2 = findRadioButton();
    	this.toggleButton(rbtn1, rbtn2);
    }

    @Override
    protected void onFirst_RadioButton2Action(Component c, ActionEvent event) {
    	RadioButton rbtn1 = findRadioButton2();
    	RadioButton rbtn2 = findRadioButton3();
    	this.toggleButton(rbtn1, rbtn2);
    
    }

    @Override
    protected void onFirst_RadioButton3Action(Component c, ActionEvent event) {
    	RadioButton rbtn1 = findRadioButton3();
    	RadioButton rbtn2 = findRadioButton2();
    	this.toggleButton(rbtn1, rbtn2);
    }
    
    @Override
    protected void postFirst(Form f) {
    	RadioButton rbtn1 =  findRadioButton();
    	RadioButton rbtn2 = findRadioButton2();
        if(rbtn1 != null && rbtn2 != null)
        {
        	rbtn1.setSelected(true);
        	rbtn2.setSelected(true);
        }
       
    }
    
    public Database databaseOpenup()
    {
    	try{
	    	 Database myDataBase = com.codename1.db.Database.openOrCreate(DB_NAME);
	         
	         if(Storage.getInstance().readObject("initalized") == null){
	             myDataBase.close();
	             String path = com.codename1.db.Database.getDatabasePath(DB_NAME);            
	             OutputStream o = FileSystemStorage.getInstance().openOutputStream(path);
	             InputStream i = Display.getInstance().getResourceAsStream(getClass(), "/" + DB_NAME);
	             Util.copy(i, o);
	             Util.cleanup(o);
	             Util.cleanup(i);
	             
	             myDataBase = com.codename1.db.Database.openOrCreate(DB_NAME);
	             Storage.getInstance().writeObject("initalized", "true");
	         }
	         return myDataBase;
    	}
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    	return null;
	    }
    	
    }
    public TreeMap populateDBValues()
    {
    	TreeMap resultMap = new TreeMap();
    	String playerName = "";
    	int score = -1;
    	try{
	    	 Database myDataBase = databaseOpenup();
	         if(myDataBase != null)
	         {
	        	 Cursor csr = myDataBase.executeQuery("SELECT " + PLAYER_NAME + "," + SCORE + " FROM " + TABLE_NAME);
	        	 if(csr != null)
	        	 {
	        		 while(csr.next())
	        		 {
	        			 Row row = csr.getRow();
	        			 if(row != null)
	        			 {
		        			 playerName = row.getString(0);
		        			 score = row.getInteger(1);
		        			 if(playerName != null && score >= 0)
		        			 {
		        				 resultMap.put(playerName, score);
		        			 }
	        			 }
	        		 }
	        		 
	        	 }
	        	 
	         }
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    		return null;
    	}
    	return resultMap;
    	
    }
    public void updateLabelValues(TreeMap resultMap)
    {
        // Putting the values into labels accordingly
    	if(resultMap != null)
    	{
	    	SpanLabel XwinLbl = findSpanLabel();
	    	SpanLabel OwinLbl = findSpanLabel1();
	        if(XwinLbl != null && OwinLbl != null)
	        {
				//XwinLbl.setText(Integer.toString(Xwin));
				//OwinLbl.setText(Integer.toString(Owin));
				XScore = resultMap.get("X").toString();
				OScore = resultMap.get("Y").toString();
				if(XScore != null && OScore != null)
				{
					XwinLbl.setText(XScore);
					OwinLbl.setText(OScore);
				}
	        }
    	}
      // END putting the values into labels accordingly
    }
    // User defined methods
    public void toggleButton(RadioButton rbtn1, RadioButton rbtn2)
    {
    	if(rbtn1.isSelected())
    	{
    		rbtn2.setSelected(!rbtn1.isSelected());
    	} 
    	else if (rbtn2.isSelected())
    	{
    		rbtn1.setSelected(!rbtn2.isSelected());
    	}
    }
    
    public ArrayList<String> identifySelectedButtons()
    {
    	ArrayList<String> arr = new ArrayList<String>();
    	RadioButton rbtn = findRadioButton();
    	RadioButton rbtn1 = findRadioButton1();
    	RadioButton rbtn2 = findRadioButton2();
    	RadioButton rbtn3 = findRadioButton3();
    	if(rbtn.isSelected())
    	{
    		arr.add("1");
    		playingWithComputer = true;
    		TABLE_NAME = COMPUTER_MAIN_SCORE_TABLE;
    	} else {
    		arr.add("2");
    		playingWithComputer = false;
    		TABLE_NAME = MAIN_SCORE_TABLE;
    	}
    	if(rbtn2.isSelected())
    	{
    		arr.add("X");
    		firstPlayer = "X";
    		secondPlayer = "O";
    		checkStatus.elements = new String [] {"0","0","0","0","0","0","0","0","0","0"};
    		counter = 0;
    	} else {
    		arr.add("O");
    		firstPlayer = "O";
    		secondPlayer = "X";
    		checkStatus.elements = new String [] {"0","0","0","0","0","0","0","0","0","0"};
    		counter = 0;
    	}
    	lastWinner = firstPlayer;
    	return arr;
    }
    
    private void callCheckStatus(Button btn, boolean isComupterRound)
    {
    	
    	if(!isComupterRound)
    	{
	        if(btn.isEnabled())
	        {
	        	
	        	String elString = btn.getText();
	        	int elNumber = Integer.parseInt(elString);
	            btn.setText((counter+1)%2 == 0?secondPlayer:firstPlayer);
	            int isFinished = checkStatus.check(btn,++counter,elNumber, firstPlayer, secondPlayer);
	            if(isFinished == 1)
	            {
	            	//Add score second player
	            	updateScore(secondPlayer);
	            	lastWinner = secondPlayer;
	            	
	            }
	            else if(isFinished == 2)
	            {
	            	// Add score first player
	            	updateScore(firstPlayer);
	            	lastWinner = firstPlayer;
		            	
	            }
	            
	            if(isFinished >0)  //Means game finished, reset everything
	            {
	            	if(isFinished == 3)
	            	{
	            		if(lastWinner.equalsIgnoreCase(firstPlayer))
	            		{
	            			lastWinner = secondPlayer;
	            		}
	            		else {
	            			lastWinner = firstPlayer;
	            		}
	            	}
	            	reset();
	            }
	        }
    	} else
    	{
    		ComputerPlayer cmp = new ComputerPlayer(checkStatus.elements);
    		int move = cmp.makeMove(Integer.toString(counter+1));
    		isComputerWinner = cmp.getIsComputerWinner();
    		btn = mappingButton(move);
    		//int intComputerIdentity = Integer.parseInt(computerIdentity);
    		btn.setText((counter+1)%2 == 0 ? secondPlayer:firstPlayer);
    		int isFinished = checkStatus.check(btn,++counter,move, firstPlayer, secondPlayer);
    		//counter%2 == 0 ?computerPlayerName = secondPlayer:computerPlayerName = firstPlayer;
            if(counter%2 == 0){computerPlayerName = secondPlayer;}else{computerPlayerName=firstPlayer;}
    		if(isFinished == 1)
            {
            	//Add score second player
            	updateScore(secondPlayer);
            	lastWinner = secondPlayer;
            	
            }
            else if(isFinished == 2)
            {
            	// Add score first player
            	updateScore(firstPlayer);
            	lastWinner = firstPlayer;
	            	
            }
            
            if(isFinished >0)  //Means game finished, reset everything
            {
            	if(isFinished == 3)
            	{
            		if(lastWinner.equalsIgnoreCase(firstPlayer))
            		{
            			lastWinner = secondPlayer;
            		}
            		else {
            			lastWinner = firstPlayer;
            		}
            	}
            	reset();
            }
    		
    	}
        
    }
    private void updateScore(String player)
    {
    	TreeMap updatedResult = new TreeMap();
    	int updateScore = -1;
    	if("X".equalsIgnoreCase(player.toUpperCase()))
    	{
    		updateScore = Integer.parseInt(XScore);
    		updatedResult.put("X",++updateScore);
    		updatedResult.put("Y",OScore);
    	} else 
    	{
    		updateScore = Integer.parseInt(OScore);
    		updatedResult.put("X",XScore);
    		updatedResult.put("Y",++updateScore);
    		player = "Y";
    	}
    	// Updating database
    	if(updateScore >= 0)
    	{
	    	try{
	   	    	 Database myDataBase = databaseOpenup();
	   	         if(myDataBase != null)
	   	         {
	   	        	myDataBase.execute("UPDATE " + TABLE_NAME + " SET " + SCORE + " = " 
	   	            + Integer.toString(updateScore) + " WHERE " + PLAYER_NAME + " = '" + player + "'");
	   	        	updateLabelValues(updatedResult); 
	   	        	myDataBase.close();
	   	         }
		         	
	    	}
	    	catch (Exception ex){
	    		
	    		ex.printStackTrace();
	    	}
    	}
    }
    private void reset()
    {
    	Button btn = this.findButton();
    	btn.setText("1");
    	btn.setEnabled(true);
    	btn = this.findButton1();
    	btn.setText("2");
    	btn.setEnabled(true);
    	btn = this.findButton2();
    	btn.setText("3");
    	btn.setEnabled(true);
    	btn = this.findButton3();
    	btn.setText("4");
    	btn.setEnabled(true);
    	btn = this.findButton4();
    	btn.setText("5");
    	btn.setEnabled(true);
    	btn = this.findButton5();
    	btn.setText("6");
    	btn.setEnabled(true);
    	btn = this.findButton6();
    	btn.setText("7");
    	btn.setEnabled(true);
    	btn = this.findButton7();
    	btn.setText("8");
    	btn.setEnabled(true);
    	btn = this.findButton8();
    	btn.setText("9");
    	btn.setEnabled(true);
    	counter = 0;
    	isFirstMove = true;
    	if(lastWinner.equalsIgnoreCase(secondPlayer))
    	{
    		secondPlayer = firstPlayer;
    		firstPlayer = lastWinner;
    	}
    	if(isComputerWinner)
    	{
    		
    		isComputerWinner = false;
    		computerRound();
    	}
    	else if(computerPlayerName.equalsIgnoreCase(firstPlayer))
    	{
    		isComputerWinner = false;
    		computerRound();
    	}
    	
    }
    
    @Override
    protected void onSecond_ButtonAction(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton();
    	performMovement(btn);
    	
    }

    @Override
    protected void onSecond_Button1Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton1();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button2Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton2();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button3Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton3();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button4Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton4();
    	performMovement(btn);    
    }

    @Override
    protected void onSecond_Button5Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton5();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button6Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton6();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button7Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton7();
    	performMovement(btn);
    
    }

    @Override
    protected void onSecond_Button8Action(Component c, ActionEvent event) {
    	
    	Button btn = this.findButton8();
    	performMovement(btn);
    
    }

   
    @Override
    protected void beforeSecond(Form f) {
    	updateLabelValues(populateDBValues());
    }
    private void performMovement(Button btn)
    {
    	isFirstMove = false;
    	this.callCheckStatus(btn,false);
    	if(playingWithComputer)
    	{
    		/*if(isFirstMove && isComputerWinner)
    		{
    		
    		}*/
    		if(playingWithComputer && !isFirstMove)
    		{
    		computerRound();
    		}
    	}
    }
    private void computerRound()
    {
    	Button btn = new Button();
    	this.callCheckStatus(btn, true);
    }
    private Button mappingButton(int move)
    {
    	if(move == 1)
    	{
    		return findButton();
    	} 
    	else if(move == 2)
    	{
    		return findButton1();
    	} 
    	else if(move == 3)
    	{
    		return findButton2();
    	}
    	else if(move == 4)
    	{
    		return findButton3();
    	}
    	else if(move == 5)
    	{
    		return findButton4();
    	}
    	else if(move == 6)
    	{
    		return findButton5();
    	}
    	else if(move == 7)
    	{
    		return findButton6();
    	}
    	else if(move == 8)
    	{
    		return findButton7();
    	}
    	else 
    	{
    		return findButton8();
    	}
    }
}
