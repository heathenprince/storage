Ball[] balls;

boolean reactionStarted;

void setup() {
   
   size(600,600);
   reactionStarted = false;
   balls = new Ball[25];
   for( int i = 0; i < balls.length; i++ ) { //populate balls
     balls[i] = new Ball();
   }
   
   balls[0].state() = Ball.DEAD; //what??? why???
   background(0);
    
}

void draw() {
  
}
