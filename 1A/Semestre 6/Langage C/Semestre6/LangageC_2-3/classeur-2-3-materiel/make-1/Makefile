test: main.o affine.o 
	gcc main.o affine.o -o test 
	@echo "Cibles : $@, dépendances : $^"

main.o: main.c
	gcc -c main.c -o main.o

affine.o:
	gcc -c affine.c -o affine.o


