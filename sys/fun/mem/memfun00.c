#include <stdio.h>
#include <stdlib.h>

int main() {

  int i = 76;
  short arr[5];
  short *sp;

  sp = &i;
  printf("%d\n",sizeof(i));
  printf("%d\n",sizeof(arr));
  printf("%d\n",sizeof(sp));
  printf("%d\n",*sp);
  printf("%d\n",&sp);

  *sp = 10;
  sp++;
  printf("%d\n",sp);
  return 0;
}
