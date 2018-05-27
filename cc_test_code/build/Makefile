CC = g++
CFLAGS = -g -I ../construct-destruct/inc
TARGET = main
OBJS = class_define.o main.o

TARGET=main

${TARGET}:${OBJS}
	$(CC) -o $(TARGET) $(OBJS) $(CFLAGS)
$(OBJS):%.o:../construct-destruct/src/%.cc
	$(CC) -c $(CFLAGS) $< -o $@

clean:
	rm -rf $(TARGET) *.o