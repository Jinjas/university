#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include "person.h"


#define FILENAME "dbfile"

struct person{
    char name[200];
    int age;
};


int new_person(char*name, int age){
    struct person p;
    strcpy (p.name, name);
    p.age = age;

    int fd = open (FILENAME, O_CREAT | O_WRONLY | O_APPEND, 0600);
    
    ssize_t r = write(fd, &p, sizeof(struct person));
    if (r < 0){
        perror("error");
        return -1;
    }
    close(fd);
    return 0;
}

int person_change_age(char* name, int age){
    
    int fd = open (FILENAME, O_RDWR, 0600);

    struct person person;
    int prev_age;
    // find person
    ssize_t flag = read(fd,&person, sizeof(struct person));
    while (flag && strcmp (name, person.name))
        flag = read(fd,&person, sizeof(struct person));

    //chegou ao fim do ficheiro
    if (!flag){
        printf("error msg: name doesnt exist\n\n");
        return -1;
    }

    lseek(fd,-sizeof(struct person),SEEK_CUR);
    prev_age = person.age;
    person.age = age;
    write(fd, &person, sizeof(struct person));

    close(fd);
    return prev_age;

}