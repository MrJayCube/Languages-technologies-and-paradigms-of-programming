#ifndef ALMACEN_H_INCLUDED
#define ALMACEN_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>

typedef struct {
 float valor; // Valor a almacenar
 int suelo; // Valor a almacenar sin decimales
 int techo; // Valor a almacenar sin decimales + 1.0
 char *str; // Contiene el valor numérico convertido a texto
}elemento;

typedef struct {
 int capacidad; // Capacidad actual del almacén
 int num_elementos; // Número de elementos en el almacén
 elemento **vector_punteros; // Vector de punteros a elemento del almacén (doble puntero)
}almacen;

almacen *almacen_new();
elemento *elemento_create(float valor);
int almacen_add(almacen *alm, float value);
int almacen_search(almacen *alm, float min, float max);
void almacen_info(almacen *alm);
void elemento_destroy(elemento *el);
void almacen_destroy();
#endif // ALMACEN_H_INCLUDED
