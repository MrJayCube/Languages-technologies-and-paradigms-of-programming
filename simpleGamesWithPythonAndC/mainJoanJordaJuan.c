#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
 int main() {
 int vmax;
 int max;
 int min = 0;
 int num;
 char ch = '1';
    do{
        printf("Introduce un NÚMERO ENTERO máximo: \n");
        scanf("%d", &max);
        fpurge(stdin);
    }while (max <= 0);
 vmax = (int)(log( max )/log( 2 ));
 num = max/2;
 while (vmax > 0) {
    switch(ch){
    case '=':
        printf("Olé, he acertado");
        return 0;
    case '<':
        max = num;
        break;
    case '>':
        min = num;
        break;
    case '1':
        break;
    default:
        printf("Qué haces?\n");
        break;
    }
    num = (min + max)/2;
    printf("¿El numero que has pensado es: %d? introduce '=' si he acertado, '<' si es menor o '>' si es mayor.\n", num);
    scanf(" %c", &ch);
    vmax--;
    printf("Me quedan %d Intentos\n", vmax);
 }
    printf("¡Oh!, no me quedan más intentos, como he podido fallar, ¿No habrás hecho trampa verdad?");
 return 0;
}
