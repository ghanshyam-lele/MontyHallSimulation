package com.capedcrusader.montyhall;

import java.util.Random;

public class MontyHallSimulation 
{
	boolean[] hats;
	int myChoice;
	int hisChoice;
	int remainingChoice;
	int numberOfGames;
	int win;
	int winbyswitch;
	Random random;
	private final int NO_OF_GAMES=9000;
	
	public MontyHallSimulation() 
	{
		// TODO Auto-generated constructor stu
		hats=new boolean[3];
		myChoice=0;
		hisChoice=0;
		numberOfGames=0;
		win=0;
		winbyswitch=0;
		random=new Random();
	}
	
	public void startSimulation() 
	{
		System.out.println("simulation started...");
		while(numberOfGames<=NO_OF_GAMES)
		{
			initHats();
			play();
			numberOfGames++;
		}
		System.out.println("simulation ended");
		displayResults();
	}

	private void displayResults() 
	{
		// TODO Auto-generated method stub
		System.out.println("out of "+NO_OF_GAMES+" games , win by staying = "+ win +" and win by switch= "+winbyswitch);
		System.out.println("probab of winning by staying = " + (float)((float)win/(float)(win+winbyswitch)));
		System.out.println("probab of winning by switching = " + (float)((float)winbyswitch/(float)(win+winbyswitch)));
	}

	private void play() 
	{
		// TODO Auto-generated method stub
		myChoice = random.nextInt(3);
		for(int i=0;i<3;i++)
			if(hats[i]==false && i!=myChoice)
				hisChoice=i;
		if(numberOfGames%2==0)
		{
			if(hats[myChoice]==true)
				win++;
		}
		else
		{
			for(int i=0;i<3;i++)
				if(i!=hisChoice && i!=myChoice)
					remainingChoice=i;
			
			if(hats[remainingChoice]==true)
				winbyswitch++;
		}
		
	}

	private void initHats() 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++)
			hats[i]=false;
		hats[random.nextInt(3)]=true;
	}
}
