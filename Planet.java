// The "Ball" class.
import java.awt.*;
import hsa.Console;

public class Planet //I am creating an object called Ball
{
    //All the characteristics of the object Ball

    protected int CX, CY, rad, dis, pr, moon;
    protected double ang, multi; //protected means only approved methods can alter the value of these following variables
    protected Color clr, bclr;
    protected Console c;
    //protected Planet[] Mlist;
    public Planet ()  // Constructor method is used to create (memory) and where values are being initialized
    {
	rad = 50;
	clr = Color.yellow;
	bclr = Color.black;
	CX = 320;
	CY = 250;
	dis = 0;
	ang = 0;
	pr = 365;
	multi = 1;
	moon = 0;
    } // A Constructor method is vital for any object


    public Planet (int CX1, int CY1, int rad1, int dis1, double ang1, int pr1, int clr1, double multi1, int moon1)
    {
	this.CX = CX1;
	this.CY = CY1;
	this.rad = rad1;
	this.dis = dis1;
	this.ang = ang1;
	this.pr = pr1;
	if (clr1 == 0)
	{
	    this.clr = Color.black;
	}
	else if (clr1 == 1)
	{
	    this.clr = Color.blue;
	}
	else if (clr1 == 2)
	{
	    this.clr = Color.green;
	}
	else if (clr1 == 3)
	{
	    this.clr = Color.cyan;
	}
	else if (clr1 == 4)
	{
	    this.clr = Color.red;
	}
	else if (clr1 == 5)
	{
	    this.clr = Color.magenta;
	}
	else if (clr1 == 6)
	{
	    this.clr = new Color (156, 93, 82);
	}
	else if (clr1 == 7)
	{
	    this.clr = Color.white;
	}
	else if (clr1 == 8)
	{
	    this.clr = Color.darkGray;
	}
	else if (clr1 == 9)
	{
	    this.clr = new Color (102, 178, 255);
	}
	else if (clr1 == 10)
	{
	    this.clr = new Color (102, 255, 102);
	}
	else if (clr1 == 11)
	{
	    this.clr = new Color (102, 255, 255);
	}
	else if (clr1 == 12)
	{
	    this.clr = new Color (255, 102, 102);
	}
	else if (clr1 == 13)
	{
	    this.clr = new Color (255, 153, 255);
	}
	else if (clr1 == 14)
	{
	    this.clr = Color.yellow;
	}
	else
	{
	    this.clr = new Color (0, 0, 0);
	}

	this.multi = multi1;
	this.moon = moon1;
	//this.Mlist = new Planet [moon];
	bclr = Color.black;
    } // Another Constructor method - Method overloading


    /*
    Method overloading: Two or three methods that have the same name, but differ
    by either, the parameters that are being passed

    */
    //Behaviours

    public void SetCX (int x1)  // Sets the characteristics
    {
	CX = x1;
    }


    public int GetCX ()  // Returns the characteristic value of x
    {
	return CX;
    } // Returns a characteristic value of x - It is a function method that returns a value


    public void SetCY (int y1)  // Sets the characteristics
    {
	CY = y1;
    }


    public int GetCY ()  // Returns the characteristic value of x
    {
	return CY;
    }


    public void SetDis (int d1)  // Sets the characteristics
    {
	dis = d1;
    }


    public int GetDis ()  // Returns the characteristic value of x
    {
	return dis;
    } // Returns a characteristic value of x - It is a function method that returns a value


    public void SetMoon (int m1)  // Sets the characteristics
    {
	moon = m1;
    }


    public int GetMoon ()  // Returns the characteristic value of x
    {
	return moon;
    }


    public void SetAng (double a1)  //gets degrees input but uses radians in the app
    {

	ang = a1 * Math.PI / 180;
    }


    public double GetAng ()  //returns the degrees angle
    {
	return 180 * ang / Math.PI;
    }



    public void SetRad (int rad1)
    {
	rad = rad1;
    }


    public int GetRad ()
    {
	return rad;
    }


    public void SetMulti (double multi1)
    {
	multi = multi1;
    }


    public double GetMulti ()
    {
	return multi;
    }


    public void SetPr (int pr1)
    {
	pr = pr1;
    }


    public int GetPr ()
    {
	return pr;
    }


    public void SetClr (int clr1)
    {
	if (clr1 == 0)
	{
	    clr = Color.black;
	}
	else if (clr1 == 1)
	{
	    clr = Color.blue;
	}
	else if (clr1 == 2)
	{
	    clr = Color.green;
	}
	else if (clr1 == 3)
	{
	    clr = Color.cyan;
	}
	else if (clr1 == 4)
	{
	    clr = Color.red;
	}
	else if (clr1 == 5)
	{
	    clr = Color.magenta;
	}
	else if (clr1 == 6)
	{
	    clr = new Color (156, 93, 82);
	}
	else if (clr1 == 7)
	{
	    clr = Color.white;
	}
	else if (clr1 == 8)
	{
	    clr = Color.darkGray;
	}
	else if (clr1 == 9)
	{
	    clr = new Color (102, 178, 255);
	}
	else if (clr1 == 10)
	{
	    clr = new Color (102, 255, 102);
	}
	else if (clr1 == 11)
	{
	    clr = new Color (102, 255, 255);
	}
	else if (clr1 == 12)
	{
	    clr = new Color (255, 102, 102);
	}
	else if (clr1 == 13)
	{
	    clr = new Color (255, 153, 255);
	}
	else if (clr1 == 14)
	{
	    clr = Color.yellow;
	}
	else
	{
	    clr = new Color (0, 0, 0);
	}
    }


    public Color GetClr ()
    {
	return clr;
    }


    public void SetBclr (Color background1)
    {
	bclr = background1;
    }


    public Color GetBclr ()
    {
	return bclr;
    }


    public int GetX ()
    {
	int x = (int) (dis * Math.sin (ang)) + CX;  //Math.ceil  ?
	return x;
    }


    public int GetY ()
    {
	int y = (int) (dis * Math.cos (ang) * multi) + CY; //Math.ceil  ?
	return y;
    }


    // public void SetXY (int x1, int y1)
    // {
    //     iDistance = (int) (Math.sqrt (x1 * x1 + y1 * y1));
    //     iAngle = Math.atan (y1 / x1);
    // }


    //Actions

    public void Draw (Console c1)
    {
	c = c1;
	c.setColor (Color.white);
	c.drawOval (CX - dis, (int) (CY - (dis * multi)), 2 * dis, (int) (2 * dis * multi)); //draw the orbitting path
	int x0 = GetX () - rad;
	int y0 = GetY () - rad;
	c.setColor (clr);
	c.fillOval (x0, y0, 2 * rad, 2 * rad);
    }


    public void Erase (Console c1)
    {
	c = c1;
	int x0 = GetX () - rad;
	int y0 = GetY () - rad;
	c.setColor (bclr);
	c.fillOval (x0, y0, 2 * rad, 2 * rad);
	c.drawOval (CX - dis, (int) (CY - (dis * multi)), 2 * dis, (int) (2 * dis * multi)); //draw the orbitting path
    }


    public void Move (int CX1, int CY1, double ang1, Console c1)
    {
	Erase (c1);
	SetCX (CX1);
	SetCY (CY1);
	SetAng (ang1 + (365.0 / (double)(pr)));
	Draw (c1);
    }
} // Ball class

