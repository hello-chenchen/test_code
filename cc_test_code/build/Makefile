CC = g++
PRO_DIR = ../construct-destruct
INC_DIR = $(PRO_DIR)/inc
SRC_DIR = $(PRO_DIR)/src
CFLAGS = -g -I $(PRO_DIR)/inc
TARGET = main
OBJS = class_define.o main.o

${TARGET}:${OBJS}
	$(CC) -o $(TARGET) $(OBJS) $(CFLAGS)
$(OBJS):%.o:../construct-destruct/src/%.cc
	$(CC) -c $(CFLAGS) $< -o $@

clean:
	rm -rf $(TARGET) *.o