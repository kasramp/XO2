package userclasses;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import java.util.*;

public class checkStatus {

public static String[] elements = {"0","0","0","0","0","0","0","0","0","0"};
    
    public static int check(Button btn,int cnt, int elNumber, String firstPlayer, String secondPlayer)
    {
        //JOptionPane.showMessageDialog(null, "Hello");
        //String[] params = new String[2];
        //params[0] = btn.getName().toString();
        //params[1] = Integer.toString(cnt%2);
        //vec.add(params);
    	boolean finished = false;
        elements[elNumber] = Integer.toString(cnt%2+1);
        btn.setEnabled(false);
        btn.setFocusable(false);
        checkStatus chk = new checkStatus();
        int whoIsWinner = chk.checkWinner();
        if(whoIsWinner == 1)
        {
        	finished = true;
        	Dialog.show("Winner", secondPlayer + " player won!", "OK", null);
        	//Dialog.show("Winner", "O player won!", "OK", null);

            //JOptionPane.showConfirmDialog(null, "O player Won!");
        } else if(whoIsWinner == 2)
        {
        	finished = true;
        	Dialog.show("Winner", firstPlayer + " player won!", "OK", null);
            //JOptionPane.showConfirmDialog(null, "X player Won!");
        } else if(whoIsWinner == 3)
        {
        	finished = true;
            //JOptionPane.showConfirmDialog(null, "Game finished with no winner!");
        	Dialog.show("Winner", "Game finished with no winner!", "OK", null);
        }
        if(finished)
        {
        	elements = new String [] {"0","0","0","0","0","0","0","0","0","0"};
        }	
        return whoIsWinner;
    }
    
    private int checkWinner()
    {
        
      if ( (elements[1].equals("1") && elements[2].equals("1") && elements[3].equals("1"))|| //Row check
        (elements[4].equals("1") && elements[5].equals("1") && elements[6].equals("1"))||
        (elements[7].equals("1") && elements[8].equals("1") && elements[9].equals("1"))|| 
        (elements[1].equals("1") && elements[4].equals("1") && elements[7].equals("1"))|| //Column check
        (elements[2].equals("1") && elements[5].equals("1") && elements[8].equals("1"))||
        (elements[3].equals("1") && elements[6].equals("1") && elements[9].equals("1"))|| //Cross check
        (elements[1].equals("1") && elements[5].equals("1") && elements[9].equals("1"))||
        (elements[3].equals("1") && elements[5].equals("1") && elements[7].equals("1")) )
      {
          return 1;
      }     
      else if (
        (elements[1].equals("2") && elements[2].equals("2") && elements[3].equals("2"))|| //Row check
        (elements[4].equals("2") && elements[5].equals("2") && elements[6].equals("2"))||
        (elements[7].equals("2") && elements[8].equals("2") && elements[9].equals("2"))|| 
        (elements[1].equals("2") && elements[4].equals("2") && elements[7].equals("2"))|| //Column check
        (elements[2].equals("2") && elements[5].equals("2") && elements[8].equals("2"))||
        (elements[3].equals("2") && elements[6].equals("2") && elements[9].equals("2"))|| //Cross check
        (elements[1].equals("2") && elements[5].equals("2") && elements[9].equals("2"))||
        (elements[3].equals("2") && elements[5].equals("2") && elements[7].equals("2")) )
      {
          return 2;
      }
      boolean allFill = true;
      for(int i=1;i<=9;i++)
      {
          if(!(elements[i].equals("1")||elements[i].equals("2")))
          {
              allFill = false;
          }
      }
      if(allFill)
      {
          return 3;
      } else 
      {
          return 0;
      }
      
    }
}