class Ball {
  //inst 
  float xVel;
  float yVel;
  float vel;
  //float dir;
  
  int xCor;
  int yCor;

  int radius;
  color col;
  boolean DEAD;
  
  //state;
  Ball() {
    xVel = random(1,180);
    yVel = random(1,180);
    vel = sqrt( pow(xVel,2) + pow(yVel,2) );

    xCor = (int) random(1,600);
    yCor = (int) random(1,600);

    radius = (int)random(1,10);
    col = color( random(0,255) , random(0,255) , random(0,255) );
    DEAD = false;
  }
  
  boolean state() {
    return DEAD;
  }
  
  
}
