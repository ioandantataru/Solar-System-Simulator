// The "SolarSystemFinalAssignment" class.
import java.awt.*; //EXTRAS: 3D effects, random solar system, random generation of stars, ability to close program
import hsa.Console;
import java.io.*;

public class Solar_Main
{
    static Console c;           // The output console
    static File f1;
    static double multi = 1;
    static Planet[] Plist; //stores all the planet objects
    static Planet[] [] Mlist; // = new Planet [10] [10];
    static Planet sun = new Planet ();                                        //stores moons for all planets
    static char cKey;
    static int[] StarX;
    static int[] StarY;
    static int numS = 0, sizeS = 0;
    public static void main (String[] args) throws Exception
    {
	c = new Console ();
	int answer, answer2, answer3, answer4;
	String answer1, answer5;
	c.println ("Welcome to Galaxy Creator!!!");
	c.println ("Would you like to read the instructions? (y/n)");
	answer5 = c.readLine ();
	while (!answer5.equals ("y") && !answer5.equals ("n") && !answer5.equals ("Y") && !answer5.equals ("N"))
	{
	    c.clear ();
	    c.println ("Invalid input");
	    c.println ("Would you like to read the instructions? (y/n)");
	    answer5 = c.readLine ();
	}
	if (answer5.equals ("y") || answer5.equals ("Y"))
	{
	    c.clear ();
	    c.println ("Unless you chose to randomize the solar system, you will need to input all the information required to create it.");
	    c.println ("Once the solar system is displayed, you can press (2) or (8) to change the angle of view (special 3D effects)");
	    c.println ("You can press 'q' tp quit");
	    c.println ();
	    c.println ("Press any key to continue ...");
	    c.getChar ();
	}
	c.clear ();
	c.println ("Do you wish to see stars in your solar system (other than the sun)? (y/n)");
	answer5 = c.readLine ();
	while (!answer5.equals ("y") && !answer5.equals ("n") && !answer5.equals ("Y") && !answer5.equals ("N"))
	{
	    c.clear ();
	    c.println ("Invalid input");
	    c.println ("Do you wish to see stars in your solar system (other than the sun)? (y/n)");
	    answer5 = c.readLine ();
	    c.clear ();
	}
	if (answer5.equals ("y") || answer5.equals ("Y"))
	{
	    c.println ("How many stars would you like to see? (Max 200)");
	    numS = c.readInt ();
	    while (numS < 0 || numS > 200)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("How many stars would you like to see? (Max 200)");
		numS = c.readInt ();
	    }
	    c.clear ();
	    c.println ("What size to you want the stars to be? (Min 2 - Max 7)");
	    sizeS = c.readInt ();
	    while (sizeS < 2 || sizeS > 7)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("What size to you want the stars to be? (Min 2 - Max 7)");
		sizeS = c.readInt ();
	    }
	    c.clear ();
	    GenStar (numS, sizeS);
	}
	c.println ("Do you wish to load the data from a file (1), to input data from keyboard (2) or to generate a random solar system (3)?");
	answer = c.readInt ();
	while (answer != 1 && answer != 2 && answer != 3)
	{
	    c.clear ();
	    c.println ("Invalid input");
	    c.println ("Do you wish to load the data from a file (1), to input data from keyboard (2) or to generate a random solar system (3)?");
	    answer = c.readInt ();
	}
	c.clear ();
	if (answer == 1)
	{
	    c.println ("Enter the name of the file");
	    answer1 = c.readLine ();
	    f1 = new File (answer1);
	    while (f1.exists () == false)
	    {
		c.clear ();
		c.println ("The file cannot be found");
		c.println ("Enter a valid file name");
		answer1 = c.readLine ();
		f1 = new File ("answer1");
	    }
	    Load ();
	    Display ();
	}
	else if (answer == 3)
	{
	    c.println ("Enter the amount of planets you want to see (Max 10)");
	    int numplane = c.readInt ();
	    while (numplane < 0 || numplane > 10)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("Enter the amount of planets you want to see (Max 10)");
		numplane = c.readInt ();
	    }
	    c.clear ();
	    c.println ("Watch out!!! This might become really complicated.");
	    RandomSys (numplane);
	    Thread.sleep (3500);
	    Display ();
	}
	else
	{
	    c.println ("Enter the radius of the sun. (Max 300)");
	    answer2 = c.readInt ();
	    while (answer2 > 300 || answer2 <= 0)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("Enter the radius of the sun. (Max 300)");
		answer2 = c.readInt ();
	    }
	    c.clear ();
	    sun.SetRad (answer2);
	    c.println ("Enter the number for the color of the sun:");
	    c.println ("0. Black");
	    c.println ("1. Blue");
	    c.println ("2. Green");
	    c.println ("3. Cyan");
	    c.println ("4. Red");
	    c.println ("5. Magenta");
	    c.println ("6. Orange");
	    c.println ("7. White");
	    c.println ("8. Dark Gray");
	    c.println ("9. Light Blue");
	    c.println ("10. Light Green");
	    c.println ("11. Light Cyan");
	    c.println ("12. Light Red");
	    c.println ("13. Light Magenta");
	    c.println ("14. Yellow");
	    c.println ("Any other integer for white.");
	    answer2 = c.readInt ();
	    sun.SetClr (answer2);
	    c.clear ();
	    c.println ("Enter the x coordinate for the center of the sun. (between 0 and 640)");
	    answer2 = c.readInt ();
	    while (answer2 < 0 || answer2 > 640)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("Enter the x coordinate for the center of the sun. (between 0 and 640)");
		answer2 = c.readInt ();
	    }
	    sun.SetCX (answer2);
	    c.clear ();
	    c.println ("Enter the y coordinate for the center of the sun. (between 0 and 500)");
	    answer2 = c.readInt ();
	    while (answer2 < 0 || answer2 > 500)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("Enter the y coordinate for the center of the sun. (between 0 and 500)");
		answer2 = c.readInt ();
	    }
	    sun.SetCY (answer2);
	    c.clear ();
	    c.println ("Enter the amount of planets orbiting around the sun (max 10)");
	    answer2 = c.readInt ();
	    while (answer2 < 0 || answer2 > 10)
	    {
		c.clear ();
		c.println ("Invalid input");
		c.println ("Enter the amount of planets orbiting around the sun (max 10)");
		answer2 = c.readInt ();
	    }
	    c.clear ();
	    sun.SetMoon (answer2);
	    Mlist = new Planet [sun.GetMoon ()] [10];
	    Plist = new Planet [sun.GetMoon ()];
	    for (int i = 0 ; i < sun.GetMoon () ; i++)
	    {
		Plist [i] = new Planet ();
		c.println ("Enter the radius of planet " + (i + 1) + " (Max 300)");
		answer3 = c.readInt ();
		while (answer3 > 300 || answer3 <= 0)
		{
		    c.clear ();
		    c.println ("Invalid input");
		    c.println ("Enter the radius of the sun. (Max 300)");
		    answer3 = c.readInt ();
		}
		c.clear ();
		Plist [i].SetRad (answer3);
		c.println ("Enter the number for the color of planet " + (i + 1));
		c.println ("0. Black");
		c.println ("1. Blue");
		c.println ("2. Green");
		c.println ("3. Cyan");
		c.println ("4. Red");
		c.println ("5. Magenta");
		c.println ("6. Orange");
		c.println ("7. White");
		c.println ("8. Dark Gray");
		c.println ("9. Light Blue");
		c.println ("10. Light Green");
		c.println ("11. Light Cyan");
		c.println ("12. Light Red");
		c.println ("13. Light Magenta");
		c.println ("14. Yellow");
		c.println ("Any other integer for white.");
		answer3 = c.readInt ();
		c.clear ();
		Plist [i].SetClr (answer3);
		c.println ("Enter the distance from the sun for planet " + (i + 1));
		answer3 = c.readInt ();
		while (answer3 <= 0)
		{
		    c.clear ();
		    c.println ("Invalid input");
		    c.println ("Enter the distance from the sun for planet " + (i + 1));
		    answer3 = c.readInt ();
		}
		c.clear ();
		Plist [i].SetDis (answer3);
		c.println ("Enter the period of rotation of planet " + (i + 1));
		answer3 = c.readInt ();
		// while (answer3 < 0)
		// {
		//     c.clear ();
		//     c.println ("Invalid input");
		//     c.println ("Enter the orbiting period of planet " + (i + 1));
		//     answer3 = c.readInt ();
		// }
		c.clear ();
		Plist [i].SetPr (answer3);
		c.println ("Enter the amount of moons orbiting around planet " + (i + 1) + " (Max 10)");
		answer3 = c.readInt ();
		while (answer3 < 0 || answer3 > 10)
		{
		    c.clear ();
		    c.println ("Invalid input");
		    c.println ("Enter the amount of moons orbiting around planet " + (i + 1) + " (Max 10)");
		    answer3 = c.readInt ();
		}
		c.clear ();
		Plist [i].SetMoon (answer3);
		for (int q = 0 ; q < Plist [i].GetMoon () ; q++)
		{
		    Mlist [i] [q] = new Planet ();
		    c.println ("Enter the radius of moon " + (q + 1) + " (Max 300)");
		    answer4 = c.readInt ();
		    while (answer4 > 300 || answer4 <= 0)
		    {
			c.clear ();
			c.println ("Invalid input");
			c.println ("Enter the radius of moon " + (q + 1) + " (Max 300)");
			answer4 = c.readInt ();
		    }
		    Mlist [i] [q].SetRad (answer4);
		    c.clear ();
		    c.println ("Enter the number for the color of moon " + (q + 1));
		    c.println ("0. Black");
		    c.println ("1. Blue");
		    c.println ("2. Green");
		    c.println ("3. Cyan");
		    c.println ("4. Red");
		    c.println ("5. Magenta");
		    c.println ("6. Orange");
		    c.println ("7. White");
		    c.println ("8. Dark Gray");
		    c.println ("9. Light Blue");
		    c.println ("10. Light Green");
		    c.println ("11. Light Cyan");
		    c.println ("12. Light Red");
		    c.println ("13. Light Magenta");
		    c.println ("14. Yellow");
		    c.println ("Any other integer for white.");
		    answer4 = c.readInt ();
		    c.clear ();
		    Mlist [i] [q].SetClr (answer4);
		    c.println ("Enter the distance of moon " + (q + 1) + " from planet " + (i + 1));
		    answer4 = c.readInt ();
		    while (answer4 <= 0)
		    {
			c.clear ();
			c.println ("Invalid input");
			c.println ("Enter the distance of moon " + (q + 1) + " from planet " + (i + 1));
			answer4 = c.readInt ();
		    }
		    c.clear ();
		    Mlist [i] [q].SetDis (answer4);
		    c.println ("Enter the period of rotation of moon " + (q + 1) + " from planet " + (i + 1));
		    answer4 = c.readInt ();
		    c.clear ();
		    Mlist [i] [q].SetPr (answer4);
		}
	    }
	    Display ();
	}

	// Place your program here.  'c' is the output console
    } // main method


    public static void Load () throws IOException
    {
	BufferedReader input = new BufferedReader (new FileReader (f1));
	String line;
	line = input.readLine ();
	int num;

	num = Integer.parseInt (line);
	sun.SetRad (num); //35
	line = input.readLine ();
	num = Integer.parseInt (line);
	sun.SetClr (num); //14
	line = input.readLine ();
	num = Integer.parseInt (line);
	sun.SetCX (num); //320
	line = input.readLine ();
	num = Integer.parseInt (line);
	sun.SetCY (num); //240
	// num = Integer.parseInt (line);
	// sun.SetPr (num);
	line = input.readLine ();
	num = Integer.parseInt (line);
	sun.SetMoon (num); //3
	Mlist = new Planet [sun.GetMoon ()] [10]; // 2D array size [number of planets][10]
	Plist = new Planet [sun.GetMoon ()]; // array size [number of planets]
	for (int i = 0 ; i < sun.GetMoon () ; i++)
	{
	    Plist [i] = new Planet ();
	    line = input.readLine ();
	    num = Integer.parseInt (line);

	    Plist [i].SetRad (num);
	    line = input.readLine ();
	    num = Integer.parseInt (line);

	    Plist [i].SetClr (num);
	    line = input.readLine ();
	    num = Integer.parseInt (line);

	    Plist [i].SetDis (num);
	    line = input.readLine ();
	    num = Integer.parseInt (line);

	    Plist [i].SetPr (num);
	    line = input.readLine ();
	    num = Integer.parseInt (line);

	    Plist [i].SetMoon (num);
	    Plist [i].SetCX (sun.GetCX ());
	    Plist [i].SetCY (sun.GetCY ());

	    for (int q = 0 ; q < Plist [i].GetMoon () ; q++)
	    {
		Mlist [i] [q] = new Planet ();
		line = input.readLine ();
		num = Integer.parseInt (line);
		Mlist [i] [q].SetRad (num);
		line = input.readLine ();
		num = Integer.parseInt (line);
		Mlist [i] [q].SetClr (num);
		line = input.readLine ();
		num = Integer.parseInt (line);
		Mlist [i] [q].SetDis (num);
		line = input.readLine ();
		num = Integer.parseInt (line);
		Mlist [i] [q].SetPr (num);
		Mlist [i] [q].SetCX (Plist [i].GetX ());
		Mlist [i] [q].SetCY (Plist [i].GetY ());
	    }
	}
	input.close ();
    }


    public static void Display () throws InterruptedException
    {
	//int angle = 0;
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	while (cKey != 'q' && cKey != 'Q')
	{
	    Thread.sleep (25);
	    if (numS != 0)
	    {
		DrawStar (numS, sizeS);
	    }
	    sun.Draw (c);
	    if (c.isCharAvail ())
	    {
		cKey = c.getChar ();
		if (cKey == '8' && multi < 1)
		{
		    multi = multi + 0.025;
		    EraseAll ();
		}
		else if (cKey == '2' && multi > 0)
		{
		    multi = multi - 0.025;
		    EraseAll ();
		}
	    }
	    sun.SetMulti (multi);
	    for (int i = 0 ; i < sun.GetMoon () ; i++)
	    {

		Plist [i].SetMulti (multi);

		Plist [i].Move (sun.GetCX (), sun.GetCY (), Plist [i].GetAng (), c);

		for (int q = 0 ; q < Plist [i].GetMoon () ; q++)
		{
		    Mlist [i] [q].SetMulti (multi);

		    Mlist [i] [q].Move (Plist [i].GetX (), Plist [i].GetY (), Mlist [i] [q].GetAng (), c);
		}
	    }
	}
	c.close ();
    }


    public static void EraseAll () throws InterruptedException
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);
    }


    public static void GenStar (int number, int size)
    {
	int x;
	StarX = new int [number];
	StarY = new int [number];
	for (int i = 0 ; i < number ; i++)
	{
	    x = (int) (Math.random () * (640 + 1));
	    StarX [i] = x;
	    x = (int) (Math.random () * (500 + 1));
	    StarY [i] = x;
	}
	//c.fillStar (10, 10, 15, 15);
    }


    public static void DrawStar (int number, int size)
    {
	c.setColor (Color.white);
	for (int i = 0 ; i < number ; i++)
	{
	    c.fillStar (StarX [i], StarY [i], size, size);
	}
    }


    public static void RandomSys (int numplan)
    {
	int moons, radius, color, temp, temp1, pdis = 25, mdis = 10, period;
	radius = 20 + (int) (Math.random () * (40 + 1));
	sun.SetRad (radius); //35
	color = (int) (Math.random () * (15 + 1));
	sun.SetClr (color); //14
	sun.SetCX (320); //320
	sun.SetCY (250); //240
	// moons = 1 + (int) (Math.random () * (9 + 1));
	sun.SetMoon (numplan); //3
	Mlist = new Planet [sun.GetMoon ()] [10]; // 2D array size [number of planets][10]
	Plist = new Planet [sun.GetMoon ()]; // array size [number of planets]
	for (int i = 0 ; i < sun.GetMoon () ; i++)
	{
	    Plist [i] = new Planet ();
	    radius = 15 + (int) (Math.random () * (25 + 1));
	    Plist [i].SetRad (radius);
	    color = (int) (Math.random () * (15 + 1));
	    Plist [i].SetClr (color);
	    temp = (int) (Math.random () * (50 + 1));
	    if (pdis <= sun.GetRad () + Plist [i].GetRad ())
	    {
		temp = (int) (Math.random () * (50 + 1));
	    }
	    pdis += temp;
	    Plist [i].SetDis (pdis);
	    period = (int) (Math.random () * (1800 + 1)) - 900;
	    Plist [i].SetPr (period);
	    moons = 1 + (int) (Math.random () * (9 + 1));
	    Plist [i].SetMoon (moons);
	    Plist [i].SetCX (sun.GetCX ());
	    Plist [i].SetCY (sun.GetCY ());
	    mdis = 10;
	    for (int q = 0 ; q < Plist [i].GetMoon () ; q++)
	    {
		Mlist [i] [q] = new Planet ();
		radius = 5 + (int) (Math.random () * (15 + 1));
		Mlist [i] [q].SetRad (radius);
		color = (int) (Math.random () * (15 + 1));
		Mlist [i] [q].SetClr (color);
		temp1 = (int) (Math.random () * (30 + 1));
		if (mdis <= Plist [i].GetRad () + Mlist [i] [q].GetRad ())
		{
		    temp1 = (int) (Math.random () * (30 + 1));
		}
		mdis += temp1;
		mdis = mdis + (int) (Math.random () * (40 + 1));
		Mlist [i] [q].SetDis (mdis);
		period = (int) (Math.random () * (1000 + 1)) - 500;
		Mlist [i] [q].SetPr (period);
		Mlist [i] [q].SetCX (Plist [i].GetX ());
		Mlist [i] [q].SetCY (Plist [i].GetY ());
	    }
	}

    }
} // SolarSystemFinalAssignment class


