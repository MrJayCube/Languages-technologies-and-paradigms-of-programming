#include <stdio.h>
#include <stdlib.h>

#include "almacen.h"

int main() {
    almacen *a;
    a = almacen_new();
    float valor = 0;
    int opcion = 0;
    int comp = 0;
    float min = 0;
    float max = 0;
    while(opcion != 4){
        printf ("¿Qué desea hacer? 1 = Introducir nuevo elemento | 2 = Buscar valores | 3 = Info de Almacen | 4 = Liberar memoria y salir \n");
        scanf ("%d", &opcion);
        switch(opcion){
            case 1:
                    printf ("Introduce el valor del elemento: \n");
                    scanf (" %f", &valor);
                    comp = almacen_add(a,valor);
                    if(comp == 0){
                        printf("ÉXITO \n");
                    }else{
                        printf("Error \n");
                    }
                    break;
            case 2:
                    printf ("Introduce el valor del mínimo: \n");
                    scanf ("%f", &min);
                    printf ("Introduce el valor del máximo: \n");
                    scanf ("%f", &max);
                    comp = almacen_search(a, min, max);
                    if(comp == -1){
                        printf ("No se encuentra ningún valor en el rango propuesto o no hay valores \n");
                    }
                break;
            case 3:
                    almacen_info(a);
                break;
            default:
                break;
        }
    }
almacen_destroy(a);
return 0;
}
