#include <stdio.h>
#include <stdlib.h>

int main() {
  char a[9] = {'s','e','g','f','a','u',0,'l','t'}; 

  a[0]--;
  
  printf( "charray: %s \n" , a );
  printf( "charray: %p \n" , a );

  return 0;
}
