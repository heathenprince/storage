#include <stdio.h>
#include <stdlib.h>

int main() {

  int a[2];
  a[0] = 24;
  a[1] = 86;
  int *ip = a;
  
  printf( "a[0]: %i\n", a[0] );
  printf( "0[a]: %i\n", 0[a] );
  printf( "value of ip: %p\n", ip );
  
  ip++;
  
  printf( "value of ip: %p\n", ip );
  printf( "value of *ip: %i\n", *ip );

  return 0;
  
}
