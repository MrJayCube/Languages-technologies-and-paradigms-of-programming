#include <stdio.h>
#include <stdlib.h>

#include "almacen.h"

almacen *almacen_new(){
    almacen *ptr = (almacen*)malloc(sizeof(almacen));
    ptr -> capacidad = 4;
    ptr -> num_elementos = 0;
    ptr -> vector_punteros = (elemento**)malloc(4*sizeof(elemento*));
    if (ptr==NULL) {
        perror("Problemas reservando memoria \n");
        exit(1);
    }
    return ptr;
}

elemento *elemento_create(float valor){
    elemento *ptr = (elemento *)malloc(sizeof(elemento));
    ptr -> valor = valor;
    ptr -> suelo = (int) valor;
    ptr -> techo = (int) valor + 1.0;
    ptr -> str = (char*)malloc(1000*sizeof(char));
    sprintf(ptr -> str,"%f",valor);
    return ptr;
}

int almacen_add(almacen *alm, float value){
    if(alm ->num_elementos == alm -> capacidad)
        {
            elemento **vector_punterosnew = (elemento**)malloc(((alm->capacidad)+4)*sizeof(elemento*));
            if (vector_punterosnew==NULL) {
                perror("Problemas reservando memoria \n");
            return -1;
        }
            for(int cont = 0;cont <= (alm -> capacidad) - 1; cont++)
                {
                    vector_punterosnew[cont] = (alm ->vector_punteros[cont]);
                }
            alm ->capacidad = alm->capacidad+4;
            free(alm->vector_punteros);
            alm ->vector_punteros = vector_punterosnew;
        }
    alm -> vector_punteros[(alm->num_elementos)] = elemento_create(value);
    if (alm -> vector_punteros[(alm->num_elementos)]==NULL) {
        perror("Problemas reservando memoria \n");
        return -1;
    }
    int tope = alm->num_elementos;
        elemento *ptr;
    for (int i = 0; i < tope && tope > 1; i++) {
        if ((alm->vector_punteros[i]->valor) > (alm -> vector_punteros[tope]->valor)) {
            ptr = alm->vector_punteros[i];
            alm->vector_punteros[i] = alm -> vector_punteros[tope];
            alm -> vector_punteros[tope] = ptr;
        }
    }
    alm -> num_elementos = (alm -> num_elementos) + 1;
    return 0;
}

int almacen_search(almacen *alm, float min, float max){
    int busqueda = 0;
    for(int i = 0; i <= (alm -> num_elementos) - 1; i++)
        {
            if(((alm -> vector_punteros[i]) -> valor) >= min && ((alm -> vector_punteros[i]) -> valor) <= max){
                printf("El valor, %f ",(alm -> vector_punteros[i]) -> valor);
                printf(" Con suelo, %d ",(alm -> vector_punteros[i]) -> suelo);
                printf(" Con techo, %d ",(alm -> vector_punteros[i]) -> techo);
                printf(" y cadena, %s ",(alm -> vector_punteros[i]) -> str);
                printf(" Se encuentra en la posición %d \n",i);
                busqueda++;
            }
        }
    if(busqueda == 0){
        return -1;
    }
    return 0;
}

void almacen_info(almacen *alm){
    printf("Capacidad del almacen: %d ",alm ->capacidad);
    printf(" Número de elementos: %d \n",alm->num_elementos);
}

void elemento_destroy(elemento *el){
    free(el->str);
    free(el);
}

void almacen_destroy(almacen *a){
    for(int i = 0; i < (a->num_elementos);i++){
        elemento_destroy(a->vector_punteros[i]);
    }
    free(a->vector_punteros);
    free(a);
}
