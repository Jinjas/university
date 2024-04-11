#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>

struct person {
    char * name;
    int age;
};

void newPerson(char * name, int age){
    struct person p;
    strcpy(p.name, name);
    p.age = age;

    int fd = open("pessoas", O_WRONLY | O_CREAT | O_APPEND,0600);
    write(fd,&p,sizeof(struct person));
    close(fd);
}

int updatePerson(char * name, int age){
    struct person p;
    
    int fd = open("pessoas", O_RDWR,0600);
    ssize_t n;
    int i = 1;
    while (n = read(fd,&p,sizeof(struct person))>0 && strcmp(p.name,name)){
        i++;
    }
    if (n > 0){
        //existe pessoa
        lseek(fd,-sizeof(struct person),SEEK_CUR);
        p.age = age;
        write(fd,&p,sizeof(struct person));
    }
    else{
        perror("pessoa não existe");
        i = -1;
    }
    close(fd);
    return i;
}



int main(int argc, char **argv){
    if (argc < 4 || argc > 5)
        return -1;
    if (!strcmp(argv[1],"-i")){
        newPerson(argv[2],atoi(argv[3]));
    }else if (!strcmp(argv[1],"-u")){
        int i = updatePerson(argv[2],atoi(argv[3]));
        char *index;
        sprintf(index, "%d", i);
        write (1,index,strlen(index));
    }
    else  return -1;

    return 0;

}