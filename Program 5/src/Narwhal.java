/**  Narwhal class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Narwhal extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Narwhal( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Narwhal( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Tortoise move characteristics: "slow & steady wins the race"
   *      increment x by 1 most of the time
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
       setX( getX( ) + 3 );
   }

   /** draw: draws the Tortoise at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     g.setColor(Color.CYAN);

     // tail
     g.fillOval( startX - 37, startY + 8,  12, 12 ) ;

     //body
     g.fillOval( startX - 30, startY,  30,  20 );

     //flatten bottom
     g.clearRect( startX - 37, startY + 15, 32, 5 );
     
     // eye
     g.setColor(Color.BLACK);
     g.fillOval( startX - 13, startY+5,  4,  4 );
     
     // horn
     g.setColor( Color.GRAY );
     int xpoints[] = {startX-10, startX-5, startX+5};
     int ypoints[] = {startY+1, startY+2, startY-10};
     int npoints = 3;
     g.fillPolygon(xpoints, ypoints, npoints);
     
     if (this.isWinner) {
    	 morph(g);
     }
     
     
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this tortoise moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }
   
   
 /** draws a hat on the Narwhal if the Narwhal wins the race
 *	@param g Graphics context
 */
@Override
   public void morph( Graphics g) {
	   	int startX = getX( );
	    int startY = getY( );
	    g.setColor(Color.BLACK);
	    g.fillRect(startX-14, startY-10, 6, 12);
    	g.fillRect(startX-16, startY-1, 10, 2);
    	g.setColor(Color.RED);
    	g.fillRect(startX-14, startY-4, 6, 2);
	     
	}
}