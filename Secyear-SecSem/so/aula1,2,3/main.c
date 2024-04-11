#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>



//SEEK_SET-> pointing to the beginning of the file
//SEEK_CUR-> pointing to the corent point of the file
//SEEK_END-> pointing to the end of the file
// int main (int argc, char const* argv[]){

//     int fd = open ("out", O_CREAT | O_RDWR, 0600);
//     int i1 = 60;
//     int i2 = 123456;

//     write(fd,&i1, sizeof(int));
//     write(fd,&i2, sizeof(int));
    
//     lseek(fd,-2*sizeof(int),SEEK_CUR);
//     // lseek(fd,0,SEEK_SET);
    
//     int i3;
//     int i4;
//     ssize_t bytes = read(fd,&i3, sizeof(int));
//     read(fd,&i4, sizeof(int));
//     printf("3\t%d\n4\t%d\n",i3,i4);
//     printf("%d\n",bytes);

//     close(fd);
// }

int main(int agrc, char *argv[]){
    if(!strcmp(argv[1],"-i")){
        new_person(argv[2],atoi(argv[3]));
    }
    else if(!strcmp(argv[1],"-u")){
        person_change_age(argv[2],atoi(argv[3]));
    }
    return 0;
}
